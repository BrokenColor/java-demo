package toolUtil;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openjdk.jol.info.ClassLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toolUtil.carparkEncrypt.JsonUtils;
import toolUtil.param.DriverContactParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.sql.Types.NUMERIC;
import static org.apache.xmlbeans.impl.piccolo.xml.Piccolo.STRING;

public class ExcelParserDemoV2 {
    private static final Logger logger = LoggerFactory.getLogger(ExcelParserDemoV2.class);

    public static void main1(String[] args) {
        String excelFilePath = System.getProperty("excel.file.path", "/Users/bailongm/Downloads/test.xlsx");
//        String excelFilePath = System.getProperty("excel.file.path", "/Users/bailongm/Downloads/driverInfoContact.xlsx");
        List<DriverContactParam> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(excelFilePath);
                XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null || sheet.getLastRowNum() < 1) {
                logger.warn("Excel file is empty or only contains header row.");
                return;
            }

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }

                Cell driverIdCell = row.getCell(0);
                Cell contactNameCell = row.getCell(4);
                Cell contactPhoneCell = row.getCell(5);
                Cell contactAddressCell = row.getCell(6);

                if (driverIdCell == null || contactNameCell == null || contactPhoneCell == null || contactAddressCell == null) {
                    logger.warn("Missing required cells in row: " + row.getRowNum());
                    continue;
                }

//                String driverIdStr = getCellValueAsString(driverIdCell);
//                String contactName = getCellValueAsString(contactNameCell);
//                String contactPhone = getCellValueAsString(contactPhoneCell);
//                String contactAddress = getCellValueAsString(contactAddressCell);

                String driverIdStr = ((XSSFCell) driverIdCell).getRawValue();
                String contactName = ((XSSFCell) contactNameCell).getRawValue();
                String contactPhone = ((XSSFCell) contactPhoneCell).getRawValue();;
                String contactAddress = contactAddressCell.getStringCellValue();

                try {
                    long driverId = Long.parseLong(driverIdStr);
                    DriverContactParam param = new DriverContactParam();
                    param.setDriverId(driverId);
                    param.setName(contactName);
                    param.setPhone(contactPhone);
                    param.setAddress(contactAddress);
                    list.add(param);
                } catch (NumberFormatException e) {
                    logger.error("Invalid driver ID format in row: " + row.getRowNum(), e);
                }
            }

            System.out.println(ClassLayout.parseInstance(list).toPrintable());

        } catch (IOException e) {
            logger.error("Error reading Excel file: " + excelFilePath, e);
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        return ((XSSFCell) cell).getRawValue();
//        if (cell.getCellTypeEnum().equals(CellType.NUMERIC)){
//            double numericCellValue = cell.getNumericCellValue();
//            return String.valueOf(((XSSFCell) cell).getRawValue());
//        }else {
//            return cell.getStringCellValue();
//        }
    }

    public static void main(String[] args) {
//        String filePath = System.getProperty("excel.file.path", "/Users/bailongm/Downloads/test.xlsx");
        String filePath = System.getProperty("excel.file.path", "/Users/bailongm/Downloads/driverInfoContact.xlsx");
        List<DriverContactParam> list = Lists.newArrayList();
        File file = new File(filePath);
        if (file.exists()) {
            // 解析excel
            EasyExcel.read(filePath, new AnalysisEventListener<Object>() {
                Map<String, String> nameMap = Maps.newHashMap();

                @Override
                public void invoke(Object o, AnalysisContext analysisContext) {
                    try {
                        nameMap = JsonUtils.jsonToMap(JsonUtils.toJson(o), String.class, String.class);
//                        nameMap = JsonUtils.readMapValue(JsonUtils.toJson(o), String.class, String.class);
                        DriverContactParam param = new DriverContactParam();
                        param.setDriverId(Long.valueOf(nameMap.get("0")));
                        param.setName(nameMap.get("4"));
                        param.setPhone(nameMap.get("5"));
                        param.setAddress(nameMap.get("6"));

                        list.add(param);
                    } catch (Exception e) {
                       e.getStackTrace();
                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    System.out.println("dealTask 解析excel完成");
                }
            }).registerConverter(new NumberConvertor()).sheet().doRead();
        }
        System.out.println(list);
    }
}
