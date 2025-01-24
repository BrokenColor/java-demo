package toolUtil;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DecimalFormat;
import java.util.TimeZone;

@Slf4j
public class NumberConvertor implements Converter<Object> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public Object convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration) throws Exception {
        Object value = null;
        if (null != cellData) {
            if (DateUtils.isADateFormat(cellData.getDataFormat(), cellData.getDataFormatString())) {
                value = DateUtils.format(
                        DateUtil.getJavaDate(cellData.getNumberValue().doubleValue(),
                                globalConfiguration.getUse1904windowing(), TimeZone.getDefault()),
                        "yyyy-MM-dd'T'HH:mm:ss.SSS");
            } else {
                DecimalFormat df = new DecimalFormat("0");
                value = df.format(cellData.getNumberValue());
            }
        }
        return value;
    }

    @Override
    public CellData convertToExcelData(Object value, ExcelContentProperty contentProperty,
            GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}