package basetest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guwanli
 * @date 2023/2/10 23:05
 */
public class JsonTest {
    public static void main(String[] args) {
        File file = new File("/Users/shareit/Downloads/358.json");
        try {
            String fileToString = FileUtils.readFileToString(file);
            JSONObject jsonObject = JSONObject.parseObject(fileToString);
            System.out.println(jsonObject.size());
            List<Map.Entry<String, Object>> food = jsonObject.getJSONObject("food").entrySet().stream().filter(x -> x.getValue().equals("153714")).collect(Collectors.toList());

            jsonObject.getJSONObject("manufacturer").entrySet().stream().filter(x->x.getValue()!=null).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
