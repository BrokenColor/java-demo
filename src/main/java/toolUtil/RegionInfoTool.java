package toolUtil;

import com.alibaba.fastjson.JSONObject;
import tech.spiro.addrparser.common.RegionInfo;
import tech.spiro.addrparser.io.RegionDataInput;
import tech.spiro.addrparser.io.file.JSONFileRegionDataInput;
import tech.spiro.addrparser.parser.Location;
import tech.spiro.addrparser.parser.LocationParserEngine;

/**
 * @Description: 坐标转 行政名称
 * @author: gwl
 * @date: 2024/11/6 18:12
 */
public class RegionInfoTool {

    public static void main(String[] args) {
        // china-region.json文件作为基础数据
        RegionDataInput regionDataInput = new JSONFileRegionDataInput("path/china-region.json");

        // 创建并初始化位置解析引擎，一般配置为全局单例
        LocationParserEngine engine = new LocationParserEngine(regionDataInput);
        // 初始化，加载数据，比较耗时
        try {
            engine.init();
        }catch(Exception e){
            e.printStackTrace();
        }

        // 执行解析操作
        Location location = engine.parse(118.750934,32.038634);

        // 获取省市区信息
        RegionInfo provInfo = location.getProv();
        System.out.println(JSONObject.toJSONString(provInfo));
        RegionInfo cityInfo = location.getCity();
        System.out.println(JSONObject.toJSONString(cityInfo));
        RegionInfo districtInfo = location.getDistrict();
        System.out.println(JSONObject.toJSONString(districtInfo));
    }
}
