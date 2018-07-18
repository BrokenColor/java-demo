package java.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *  单例数据库连接
 * @author BONC-g
 * @date 2018年7月18日下午4:28:23
 * @tags 
 */
public class ConnFacory {
	public static Connection conn;
    private ConnFacory(){

    }
    static{
        try {
            Properties p=new Properties();
            p.load(ConnFacory.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String dirver=p.getProperty("driver");
            String url=p.getProperty("url");
            String name=p.getProperty("username");
            String pwd=p.getProperty("password");
            Class.forName(dirver);
            conn=DriverManager.getConnection(url, name, pwd);
            System.out.println("conn:"+conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
}
