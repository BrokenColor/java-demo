package basetest.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Arrays.asList 测试
 *
 * @Author: bc
 * @DateTime: 2020/9/2 下午4:12
 * @Description: Arrays.asList()在平时开发中还是比较常见的，我们可以使用它将一个数组转换为一个List集合。
 */
public class ArrayasListTest {
    public static void main(String[] args) {
        testAsList();
    }

    /**
     * Arrays.asList()将数组转换为集合后,底层其实还是数组
     * <p>
     * 返回由指定数组支持的固定大小的列表。此方法作为基于数组和基于集合的API之间的桥梁，
     * 与Collection.toArray()结合使用。返回的List是可序列化并实现RandomAccess接口。
     */
    static void testAsList() {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        //上面两个语句等价于下面一条语句
        List<String> myList1 = Arrays.asList("Apple", "Banana", "Orange");
    }

    /**
     * 传递的数组必须是对象数组，而不是基本类型。
     * <p>
     * 当传入一个原生数据类型数组时，Arrays.asList() 的真正得到的参数就不是数组中的元素，
     * 而是数组对象本身！此时List 的唯一元素就是这个数组，
     */
    static void testAsList_object() {
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1

        //使用集合的修改方法:add()、remove()、clear()会抛出异常。
        myList.add(4);//运行时报错：UnsupportedOperationException
        myList.remove(1);//运行时报错：UnsupportedOperationException
        myList.clear();//运行时报错：UnsupportedOperationException

        System.out.println(myList.getClass());//class java.util.Arrays$ArrayList

        //使用包装类型数组就可以解决这个问题。
        Integer[] myArray1 = {1, 2, 3};
        System.out.println(myArray1.getClass());////class java.util.ArrayList

    }

    /**
     * 自己动手实现
     * JDK1.5+
     */
    static <T> List<T> arrayToList(final T[] array) {
        final List<T> l = new ArrayList<T>(array.length);

        for (final T s : array) {
            l.add(s);
        }
        return (l);
    }

    //最简便的方法(推荐)
    static void asList() {
        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    }

    //使用 Java8 的Stream(推荐)
    static void asListStream() {
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        //基本类型也可以实现转换（依赖boxed的装箱操作）
        int[] myArray2 = {1, 2, 3};
        List myListBoxed = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
    }

    //使用 Guava(推荐)
    static void asListGuava() {
//        List<String> il = ImmutableList.of("string", "elements");  // from varargs
//        List<String> il1 = ImmutableList.copyOf(aStringArray);      // from array
    }

    //使用 Apache Commons Collections
    static void asListCommons() {
//        List<String> list = new ArrayList<String>();
//        CollectionUtils.addAll(list, str);
    }

    /**
     * 该方法是一个泛型方法：<T> T[] toArray(T[] a);
     * 如果toArray方法中没有传递任何参数的话返回的是Object类型数组。
     * <p>
     * 由于JVM优化，new String[0]作为Collection.toArray()方法的参数现在使用更好，
     * new String[0]就是起一个模板的作用，指定了返回数组的类型，
     * 0是为了节省空间，因为它只是为了说明返回的类型
     */
    static void toArrays() {
        String[] s = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s = list.toArray(new String[0]);//没有指定类型的话会报错

    }
}
