package controller;



import java.sql.*;

public class jdbcConn {
    public static  void main(String[] args) throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.61.129:3306/tomato?useUnicode=true&characterEncoding=utf8","root","123");
        conn.setAutoCommit(false);
        DatabaseMetaData meta=conn.getMetaData();

      ResultSet  rs = meta.getTables("tomato", null, null, new String[] { "TABLE" });
        while(rs.next()) {
            System.out.println(    rs.getString(3));
        }



    }
}
