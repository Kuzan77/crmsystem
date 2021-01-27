package com.bh.crms.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author ：mmzs
 * @date ：Created in 2021/1/22 13:37
 */
public class JdbcUtils {

    /**
     * 读取配置文件config.properties
     */
    // 第一种方式:
//    // 定义4个存储数据库信息的变量
//    private static String driver;
//    private static String url;
//    private static String username;
//    private static String password;
//
//    static {
//        // 创建properties对象获取属性文件的内容
//        Properties p = new Properties();
//        try {
//            // 通过类加载器获得src路径
//            // 获取属性文件的读取流对象
//            // JdbcUtil.class.会动态定位目前的项目src目录     // 链式编程
//            InputStream is = JdbcUtil.class.getResourceAsStream("/config.properties");
//
//            //加载属性配置文件
//            p.load(is);
//            /**
//             * 获取集合中的数据库连接信息,给成员变量赋值
//             */
//            driver = p.getProperty("driver");
//            url = p.getProperty("url");
//            username = p.getProperty("username");
//            password = p.getProperty("password");
//
//        }catch (NullPointerException npe) {
//            System.out.println("文件不存在!!!");
//        }
//        catch (IOException e) {
//            System.out.println("加载配置文件失败!!!");
//        }
//    }

//    // 第二种方式:
//    // 定义一个指向存储数据库信息的文件名常量
//    private static final String dbconfig = "dbconfig.properties";
//    // 创建properties对象获取属性文件的内容
//    private static Properties prop = new Properties();
//
//    static {
//        try {
//            //得到当前的classpath的绝对路径的URI表示法
//            // Thread.currentThread(): 返回当前正在执行的线程对象
//            // getClassLoader()是当前类加载器,而getContextClassLoader是当前线程的类加载器
//            // getResourceAsStream方法的使用
//            //  1.this.getClass().getResourceAsStream(String path) ：
//            //    path 不以’/’开头时默认是从此类所在的包下取资源，
//            //    以’/’开头则是从 ClassPath根下获取。其只是通过path构造一个绝对路径，最终是由ClassLoader获取资源。
//            //  2.this.getClass().getClassLoader().getResourceAsStream(String path) ：
//            //      默认则是从ClassPath根下获取，path不能以’/’开头，最终还是由 ClassLoader获取资源。
//            //  3.ServletContext.getResourceAsStream(String path)：
//            //      默认从项目根目录下取资源，Tomcat下path是否以’/’开头无所谓， 当然这和具体的容器实现有关。
//            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(dbconfig);
//
//            //加载属性配置文件
//            prop.load(is);
//
//            // 注册驱动
//            Class.forName(prop.getProperty("driver"));
//        }
//        catch (IOException e) {
//            System.out.println("加载配置文件失败!!!");
//        } catch (ClassNotFoundException e) {
//            System.out.println("注册驱动失败!!!");
//        }
//    }
//
//
//    /**
//     * 获取数据库的连接
//     * @return
//     */
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(
//                    prop.getProperty("url"),
//                    prop.getProperty("username"),
//                    prop.getProperty("password")
//            );
//        } catch (SQLException se) {
//            System.out.println("获取连接失败!!!");
//        }
//        return connection;
//    }


    /**
     * c3p0数据库连接池
     */
    // 加载配置文件
    private static DataSource dataSource = new ComboPooledDataSource("mysql-config");

    // 数据源
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    /**
     * 关闭连接方法
     * 查询
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e2) {
                System.out.println("关闭ResultSet失败");
            }
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e1) {
                System.out.println("关闭Statement失败!!!");
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭Connection失败!!!");
            }
    }
    /**
     * 关闭连接方法
     * 增加、修改、删除
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt) {
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e1) {
                System.out.println("关闭Statement失败!!!");
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭Connection失败!!!");
            }
    }

    public static void closep(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e2) {
                System.out.println("关闭ResultSet失败");
            }
        if (pstmt != null)
            try {
                pstmt.close();
            } catch (SQLException e1) {
                System.out.println("关闭PreparedStatement失败!!!");
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭Connection失败!!!");
            }
    }

    public static void closep(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null)
            try {
                pstmt.close();
            } catch (SQLException e1) {
                System.out.println("关闭PreparedStatement失败!!!");
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭Connection失败!!!");
            }
    }


    /**
     * 数据库连接池
     */
//    private static DataSource dataSource = new ComboPooledDataSource();
//    public static DataSource getDataSource() {
//        return dataSource;
//    }
//    public static Connection getConnectionPoll() {
//        try {
//            return dataSource.getConnection();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
