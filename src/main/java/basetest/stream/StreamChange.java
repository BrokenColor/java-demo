package basetest.stream;

/**
 * @author guwanli
 * @date 2021/8/16 8:46 下午
 */
public class StreamChange extends StreamDemo{
    public static void main(String[] args) {
        //stram会改变原集合吗
        nameList.stream().map(item->item + " NO ").forEach(System.out::print);
        System.out.println();
        nameList.forEach(System.out::print);
    }
}
