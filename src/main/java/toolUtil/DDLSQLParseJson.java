package toolUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 解析crate table sql 文档
 * @author: bc
 * @date: 2024/12/5 19:44
 */
public class DDLSQLParseJson {

    private static int rowNum = 1;

    /**
     * 主函数，用于处理SQL文件并生成Excel报告
     * 该函数遍历指定目录下的SQL文件，提取数据库名称和表名称，并将其写入Excel文件中
     * @param args 命令行参数
     * @throws IOException 如果文件读写过程中发生错误
     */
    public static void main(String[] args) throws IOException {

        // 定义存放SQL文件的目录路径
        File file = new File("/Users/bailongm/Downloads/createTable");
        // 生成Excel文件路径，包含当前时间戳以避免重名
        String excelFilePath = "/Users/bailongm/Downloads/createTable/output-" + System.currentTimeMillis() + ".xlsx";
        // 获取SQL文件目录下的所有子目录
        File[] directories = file.listFiles();
        if (Objects.isNull(directories)) {
            System.out.println("directories is empty");
            return;
        }
        // 创建Excel工作簿
        Workbook workbook = new XSSFWorkbook();
        // 创建文件输出流，用于写入Excel文件
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        for (File sqlFile : directories) {
            String fileName = sqlFile.getName();
            String regex = "DDL_(.*?)\\.sql";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileName);
            if (!matcher.find()) {
                System.out.println("fileName not match " + fileName);
                continue;
            }
            System.out.println(fileName);

            // 创建Excel工作簿和工作表
            Sheet sheet = workbook.getSheet(matcher.group(1));
            if (Objects.isNull(sheet)){
                sheet = workbook.createSheet(matcher.group(1));
            }

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("DatabaseName");
            headerRow.createCell(1).setCellValue("TableName");
            // 自动调整列宽
            for (int i = 0; i < 2; i++) {
                sheet.autoSizeColumn(i);
            }
            int rowNum = sheet.getLastRowNum() + 1;
            String regex1 = "/\\*\\s*DatabaseName\\s*=\\s*(.*?)\\s*\\*/";
            String regex2 = "/\\*\\s*TableName\\s*=\\s*(.*?)\\s*\\*/";
            Pattern databaseNamePattern = Pattern.compile(regex1);
            Pattern tableNamePattern = Pattern.compile(regex2);
            try (BufferedReader reader = new BufferedReader(new FileReader(sqlFile))) {
                // 读取整个文件内容
                String line;
                String databaseName = "", tableName = "";
                while ((line = reader.readLine()) != null) {
                    Matcher databaseNameMatcher = databaseNamePattern.matcher(line);
                    Matcher tableNameMatcher = tableNamePattern.matcher(line);
                    if (databaseNameMatcher.find()) {
                        databaseName = databaseNameMatcher.group(1);
                    } else if (tableNameMatcher.find()) {
                        tableName = tableNameMatcher.group(1);
                    }
                    if (StringUtils.isNotBlank(databaseName) && StringUtils.isNotBlank(tableName)) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(databaseName);
                        row.createCell(1).setCellValue(tableName);
                        databaseName = "";
                        tableName = "";
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // 写入文件
        workbook.write(outputStream);
    }

}
