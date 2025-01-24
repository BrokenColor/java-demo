package toolUtil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class ExcelParserDemo {
    public static void main(String[] args) {
        String excelFilePath = "/Users/bailongm/Downloads/disableCarId.xlsx";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
                XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            int index = 0;
            Sheet sheet = workbook.getSheetAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Cell cell = row.getCell(0);
                if (Objects.isNull(cell)){
                    continue;
                }
                String stringCellValue = cell.getStringCellValue();
                stringBuilder.append(stringCellValue + ",");
                if (row.getRowNum() % 2000 == 0) {
//                    System.out.println(index++ + ":");
                    String carIds = stringBuilder.toString();
                    if (carIds.endsWith(",")) {
                        carIds = carIds.substring(0, carIds.length()-1);
                    }
                    System.out.println(carIds);
                    stringBuilder = new StringBuilder();
                }
            }
            String carIds = stringBuilder.toString();
            if (carIds.endsWith(",")) {
                carIds = carIds.substring(0, carIds.length()-1);
            }
            System.out.println(carIds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
