package toolUtil;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;

public class areaCityQueryTest {


    public static void main(String[] args) throws Exception {

        //先获取到查询实例，默认提供的0-9的10个静态实例，每个实例可以分别使用一个数据文件进行初始化和查询，当然自己调用new AreaCityQuery()创建一个新实例使用也是一样的
        AreaCityQuery Instance=AreaCityQuery.Instances[0];
//static public final AreaCityQuery Instance=new AreaCityQuery(); //也可以自己创建静态实例

//查询前先初始化，每个实例全局只会初始化一次，每次查询前都调用即可（查询会在初始化完成后进行），两种初始化方式根据自己业务情况二选一
//首次初始化会从.json或.geojson文件中读取边界图形数据，速度比较慢，会自动生成.wkbs结尾的结构化文件，下次初始化就很快了
//首次初始化生成了.wkbs文件后，后续初始化可以只使用此wkbs文件，允许不用再提供geojson文件（数据更新时需删除wkbs文件再重新用geojson文件进行初始化），具体请阅读对应初始化方法的注释文档
        Instance.Init_StoreInWkbsFile("f:\\download\\ok_geo.csv\\geoJson\\GeoJSON-Polygon-ok_geo-250105-222632.json", "f:\\download\\ok_geo.csv\\geoJson\\GeoJSON-Polygon-ok_geo-250105-222632.wkbs", true);
//Instance.Init_StoreInMemory("geojson文件路径", "geojson文件路径.wkbs", true);

//Instance.OnInitProgress=(initInfo)->{ ... } //初始化过程中的回调，可以绑定一个函数，接收初始化进度信息（编写时需在Init之前进行绑定）
        System.out.println(Instance.GetInitInfo().toString()); //打印初始化详细信息，包括性能信息

//注意：以下查询中所有坐标参数的坐标系必须和初始化时使用的geojson数据的坐标系一致，否则坐标可能会有比较大的偏移，导致查询结果不正确
//查询包含一个坐标点的所有边界图形的属性数据，可通过res参数让查询额外返回wkt格式边界数据
//查询结果的判定：请不要假定查询结果的数量（坐标刚好在边界上可能会查询出多个省市区），也不要假定查询结果顺序（结果中省市区顺序是乱序的），请检查判定res1.Result中的结果是否符合查询的城市级别，比如查询省市区三级：结果中必须且仅有3条数据，并且省市区都有（判断deep=0省|1市|2区 来区分数据的级别），其他一律判定为查询无效
        AreaCityQuery.QueryResult res1=Instance.QueryPoint(40.410542221099,-2.291623088784, null, null);
        System.out.println(res1);
    }
}
