package toolUtil;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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

/**
 * @Description:
 * @author: gwl
 * @date: 2024/12/5 19:44
 */
public class SchedulerxParseJson {

    private static int rowNum = 1;

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/bailongm/Downloads/job");
        String excelFilePath = "/Users/bailongm/Downloads/job/output.xlsx";
        File[] directories = file.listFiles();
        if (Objects.isNull(directories)) {
            System.out.println("directories is empty");
            return;
        }
        Workbook workbook = new XSSFWorkbook();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        for (File directory : directories) {
            if (!directory.isDirectory()) {
                continue;
            }
            System.out.println(directory.getName());
            // 创建Excel工作簿和工作表
            Sheet sheet = workbook.createSheet(directory.getName());

            // 创建表头
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("appName");
            headerRow.createCell(1).setCellValue("name");
            headerRow.createCell(2).setCellValue("className");
            headerRow.createCell(3).setCellValue("status");
            headerRow.createCell(4).setCellValue("timeExpression");
            // 自动调整列宽
            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }
            rowNum = 1;
            File[] jsonFiles = directory.listFiles();
            for (File jsonFile : jsonFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
                    // 读取整个文件内容
                    StringBuilder jsonContent = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        jsonContent.append(line);
                    }
                    // 解析JSON对象
                    handleJson(jsonContent, sheet);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 写入文件
        workbook.write(outputStream);
    }

    private static void handleJson(StringBuilder jsonContent, Sheet sheet) {

        JSONObject root = JSONUtil.parseObj(jsonContent);
        JSONObject content = root.getJSONObject("content");
        String appName = content.getStr("appName");
        JSONArray jobConfigInfo = content.getJSONArray("jobConfigInfo");
        // 填充数据
        for (Object object : jobConfigInfo) {
            JSONObject jobInfo = (JSONObject) object;
            String className = jobInfo.getStr("className");
            String name = jobInfo.getStr("name");
            String status = jobInfo.getStr("status");
            JSONObject timeConfig = jobInfo.getJSONObject("timeConfig");
            String timeExpression = timeConfig.getStr("timeExpression");
            System.out.println(rowNum + " " +appName + " " + name + " " + className + " " + status + " " + timeExpression);

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(appName);
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(className);
            row.createCell(3).setCellValue(status);
            row.createCell(4).setCellValue(timeExpression);
        }
    }

}
