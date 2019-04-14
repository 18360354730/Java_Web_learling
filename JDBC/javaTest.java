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
        //1.������������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.������ݿ�����
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from users");
        //4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
        while(rs.next()){
            System.out.println(rs.getString("id")+" "
                          +rs.getString("name"));
        }
        
        //�ر���Դ
        rs.close();
        st.close();
        conn.close();
    }
}