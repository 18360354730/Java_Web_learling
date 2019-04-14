package com.cn.jdbcd.demo;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;


public class javaTest {
   
    public static void main(String[] args) throws Exception  {
        String URL="jdbc:mysql://localhost:3306/databasename?serverTimezone=UTC";
        String USER="root";
        String PASSWORD="databasepassword";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from users");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("id")+" "
                          +rs.getString("name"));
        }
        
        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}