package toolUtil.carparkEncrypt;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: gwl
 * @date: 2024/9/26 10:32
 */
public class JsonUtils {


    private static final String name = "JsonUtils";

    private final static ObjectMapper objectMapper;
    private final static ObjectMapper objectMapperWithoutXetter;
    private final static ObjectMapper objectMapperWithoutNull;
    private final static ObjectMapper objectMapperWithUnquotedFieldNames;

    public static <T> void registerModule(Class<T> clazz) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(clazz, new JsonSerializer<T>() {
            @Override
            public void serialize(T arg0, JsonGenerator jgen,
                    SerializerProvider arg2) throws IOException {
                jgen.writeString(clazz.getCanonicalName());
            }
        });
        objectMapper.registerModule(module);
    }

    static {
        objectMapper = new ObjectMapper();
        // 反序列化时，遇到未知字段不会失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 无setter与getter支持
        objectMapperWithoutXetter = new ObjectMapper();
        objectMapperWithoutXetter.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapperWithoutXetter.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 序列化json时，不包含null字段
        objectMapperWithoutNull = new ObjectMapper();
        //objectMapperWithoutNull.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        // 允许序列空对象
        objectMapperWithoutNull.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 属性为NULL 不序列化
        objectMapperWithoutNull.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        objectMapperWithUnquotedFieldNames = new ObjectMapper();
        // 允许解析不带引号的字段名
        objectMapperWithUnquotedFieldNames.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

    }

    /*
     *  序列化接口
     */

    /**
     * 普通json序列化
     *
     * @param obj
     * @return  json字符串
     * @throws JsonProcessingException
     */
    public static String toJson(Object obj) throws Exception {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new Exception(name + ": [" + obj.getClass().getSimpleName() + "] to json failed", e);
        }
    }

    /**
     * 漂亮打印，将JSON数据缩进并添加换行符，使其更具可读性
     *
     * @param obj
     * @return json字符串
     * @throws Exception
     */
    public static String toPrettyJson(Object obj) throws Exception {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new Exception(name + ": [" + obj.getClass().getSimpleName() + "] to pretty json failed", e);
        }
    }

    /**
     * 序列化json时，不包含null字段。
     * 允许序列空对象
     *
     * @param obj
     * @return  json字符串
     * @throws Exception
     */
    public static String toJsonWithoutNull(Object obj) throws Exception {
        try {
            return objectMapperWithoutNull.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new Exception(name + ": [" + obj.getClass().getSimpleName() + "] to json failed", e);
        }
    }

    /**
     * 序列化json时，支持无getter。
     *
     * @param obj
     * @return  json字符串
     * @throws Exception
     */
    public static String toJsonWithoutGetter(Object obj) throws Exception {
        try {
            return objectMapperWithoutXetter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new Exception(name + ": [" + obj.getClass().getSimpleName() + "] to json failed", e);
        }
    }

    /*
     *  反序列化接口
     */


    /**
     * 普通json反序列化
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString  源json字符串
     * @param tClass  目标转化对象
     * @return
     * @throws Exception
     */
    public static <T> T jsonToObject(String jsonString, Class<T> tClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, tClass);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize Object failed [" + tClass.getSimpleName() + "]", e);
        }
    }

    /**
     * json反序列化，支持无setter
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString  源json字符串
     * @param tClass  目标转化对象
     * @return
     * @throws Exception
     */
    public static <T> T jsonToObjectWithoutSetter(String jsonString, Class<T> tClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            return objectMapperWithoutXetter.readValue(jsonString, tClass);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize Object failed [" + tClass.getSimpleName() + "]", e);
        }
    }

    /**
     * json反序列化，支持目标对象使用泛型
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString  源json字符串
     * @param tClass  目标转化对象
     * @param eClass  目标对象使用的泛型
     * @return
     * @throws Exception
     */
    public static <T> T jsonToObject(String jsonString, Class<?> tClass, Class<?> eClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(tClass, eClass);
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize Object failed [" + tClass.getSimpleName() + "]", e);
        }
    }


    /**
     * json反序列化到HashMap。注意该方法不支持map的value值再包含泛型，推荐使用jsonToTree
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString  源json字符串
     * @param keyClass  HashMap的key类型
     * @param valueClass  HashMap的value类型
     * @return
     * @throws Exception
     */
    public static <K,V> Map<K,V> jsonToMap(String jsonString, Class<K> keyClass, Class<V> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructMapType(HashMap.class, keyClass, valueClass);
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize HashMap failed", e);
        }
    }

    /**
     * json反序列化到HashMap。该方法允许解析不带引号的字段名
     *
     * @param jsonString 源json字符串
     * @param keyClass HashMap的key类型
     * @param valueClass HashMap的value类型
     * @return
     * @throws Exception
     */
    public static <K,V> Map<K,V> jsonToMapWithUnquotedFieldNames(String jsonString, Class<K> keyClass, Class<V> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapperWithUnquotedFieldNames.getTypeFactory().constructMapType(HashMap.class, keyClass, valueClass);
            return objectMapperWithUnquotedFieldNames.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize HashMap failed", e);
        }
    }

    /**
     * json反序列化到HashMap，支持无setter。注意该方法不支持map的value值再包含泛型，推荐使用jsonToTree
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString  源json字符串
     * @param keyClass  HashMap的key类型
     * @param valueClass  HashMap的value类型
     * @return
     * @throws Exception
     */
    public static <K,V> Map<K,V> jsonToMapWithoutSetter(String jsonString, Class<K> keyClass, Class<V> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapperWithoutXetter.getTypeFactory().constructMapType(HashMap.class, keyClass, valueClass);
            return objectMapperWithoutXetter.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize HashMap failed", e);
        }
    }


    /**
     * json反序列化到List。注意该方法不支持List的value值再包含泛型，推荐使用jsonToTree
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString 源json字符串
     * @param valueClass  List的value类型
     * @return
     * @throws Exception
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, valueClass);
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize List failed", e);
        }
    }

    /**
     * json反序列化到List，支持无setter。注意该方法不支持List的value值再包含泛型，推荐使用jsonToTree
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString 源json字符串
     * @param valueClass  List的value类型
     * @return
     * @throws Exception
     */
    public static <T> List<T> jsonToListWithoutSetter(String jsonString, Class<T> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapperWithoutXetter.getTypeFactory().constructCollectionType(List.class, valueClass);
            return objectMapperWithoutXetter.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize List failed", e);
        }
    }


    /**
     * json反序列化到数组。注意该方法不支持数组的value值再包含泛型，推荐使用jsonToTree
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString 源json字符串
     * @param valueClass  数组的value类型
     * @return
     * @throws Exception
     */
    public static <T> T[] jsonToArray(String jsonString, Class<T> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructArrayType(valueClass);
            return objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize array failed", e);
        }
    }

    /**
     * json反序列化到数组，支持无setter。注意该方法不支持数组的value值再包含泛型，推荐使用jsonToTree
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString 源json字符串
     * @param valueClass  数组的value类型
     * @return
     * @throws Exception
     */
    public static <T> T[] jsonToArrayWithoutSetter(String jsonString, Class<T> valueClass) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapperWithoutXetter.getTypeFactory().constructArrayType(valueClass);
            return objectMapperWithoutXetter.readValue(jsonString, javaType);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize array failed", e);
        }
    }

    /**
     * json反序列化到JsonNode
     * 反序列化时，遇到未知字段不会失败
     *
     * @param jsonString 源json字符串
     * @return
     * @throws Exception
     */
    public static JsonNode jsonToTree(String jsonString) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            return objectMapper.readTree(jsonString);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize JsonNode failed", e);
        }
    }

    /**
     * json反序列化到ArrayNode
     *
     * @param jsonString 源json字符串
     * @return
     * @throws Exception
     */
    public static ArrayNode jsonToArrayNode(String jsonString) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            JsonNode node = objectMapper.readTree(jsonString);
            if(node.isArray()) {
                return (ArrayNode) node;
            }
            return null;
        } catch (IOException e) {
            throw new Exception(name + ": deserialize ArrayNode failed", e);
        }
    }

    /**
     * 泛型类json反序列化，适用于多级泛型嵌套的json反序列化
     * 反序列化时，遇到未知字段不会失败 <br/>
     * 使用时通过继承{@link TypeReference}或者通过{@link TypeReference}的匿名内部类方式绑定具体的多级泛型，例： <br/>
     * Map<String, List<<Map<String, Long>>>> multiLevelGenericType = jsonToObject("...", new TypeReference<Map<String, List<Map<String, Long>>>>() {});
     * @param jsonString  源json字符串
     * @param typeReference  泛型类的类型引用
     * @return
     * @throws Exception
     * @see TypeReference
     */
    public static <T> T jsonToParameterizedType(String jsonString, TypeReference<T> typeReference) throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize Object failed [" + typeReference.getType() + "]", e);
        }
    }

    /**
     * 泛型类json反序列化，支持无setter，适用于多级泛型嵌套的json反序列化
     * 反序列化时，遇到未知字段不会失败 <br/>
     * 使用时通过继承{@link TypeReference}或者通过{@link TypeReference}的匿名内部类方式绑定具体的多级泛型，例： <br/>
     * Map<String, List<<Map<String, Long>>>> multiLevelGenericType = jsonToObject("...", new TypeReference<Map<String, List<Map<String, Long>>>>() {});
     * @param jsonString  源json字符串
     * @param typeReference  泛型类的类型引用
     * @return
     * @throws Exception
     * @see TypeReference
     */
    public static <T> T jsonToParameterizedTypeWithoutSetter(String jsonString, TypeReference<T> typeReference)
            throws Exception {
        if (jsonString == null) {
            return null;
        }
        try {
            return objectMapperWithoutXetter.readValue(jsonString, typeReference);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize Object failed [" + typeReference.getType() + "]", e);
        }
    }

    /**
     * 将JsonNode对象转换为指定类型的Java对象
     *
     * @param jsonNode 要转换的JsonNode对象
     * @param tClass 目标转化对象
     * @return
     * @param <T> 目标转化对象的泛型
     */
    public static <T> T treeToValue(JsonNode jsonNode, Class<T> tClass) throws Exception {
        try {
            return objectMapper.treeToValue(jsonNode, tClass);
        } catch (IOException e) {
            throw new Exception(name + ": deserialize Object failed from tree node [" + tClass.getSimpleName() + "]", e);
        }
    }

    /**
     * 将Java对象转换为对应的JsonNode对象
     *
     * @param fromValue 源Java对象
     * @return 转换后的JsonNode对象
     */
    public static JsonNode valueToTree(Object fromValue) throws Exception {
        try {
            return objectMapper.valueToTree(fromValue);
        } catch (IllegalArgumentException e) {
            throw new Exception(name + ":convert to JsonNode failed", e);
        }
    }

    /**
     * 将一个对象转换为指定类型的对象
     *
     * @param fromValue 源对象
     * @param toValueType 目标对象类型
     * @return
     * @param <T> 目标对象的泛型
     */
    public static <T> T convertValue(Object fromValue, Class<T> toValueType) throws Exception {
        try {
            return objectMapper.convertValue(fromValue, toValueType);
        } catch (IllegalArgumentException e) {
            throw new Exception(name + ":convert Object failed [" + toValueType.getSimpleName() + "]", e);
        }
    }

    /**
     * 将一个对象转换为指定类型的对象, 适用于多级泛型嵌套的反序列化
     * @param fromValue 源Java对象
     * @param toValueTypeRef 泛型类的类型引用
     * @return
     */
    public static <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) throws Exception {
        try {
            return objectMapper.convertValue(fromValue, toValueTypeRef);
        } catch (IllegalArgumentException e) {
            throw new Exception(name + ":convert Object failed [" + toValueTypeRef.getType() + "]", e);
        }
    }

}
