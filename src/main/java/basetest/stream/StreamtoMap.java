package basetest.stream;

import basetest.stream.entity.ConfigPoolInfo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2021/8/15 10:18 下午
 */
public class StreamtoMap {
    public static void main(String[] args) {
        ConfigPoolInfo configPoolInfo = new ConfigPoolInfo();
        configPoolInfo.setPool(1);
        configPoolInfo.setLabel("q,w,e,r");
        List<ConfigPoolInfo> configPoolInfoList = new ArrayList<>();
        configPoolInfoList.add(configPoolInfo);
        //1:"q,w,e,r"
        Map<Integer, String> map = configPoolInfoList.stream()
                .collect(Collectors.toMap(ConfigPoolInfo::getPool, ConfigPoolInfo::getLabel));
        //to "q"=1;"w"=1;"e"=1;"r"=1
        Map<String, Integer> resultMap = new HashMap<>();
        map.entrySet().forEach(item ->
                Arrays.stream(item.getValue().split(",")).forEach(str -> {
                    resultMap.put(str, item.getKey());
                })
        );
        resultMap.entrySet().forEach(System.out::println);
    }
}
