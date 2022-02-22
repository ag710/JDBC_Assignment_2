package com.knoldus;
import java.sql.*;
public class JDBC_Connection {
    final static String className = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost:3306/Shopping";
    final static String uname = "root";
    final static String pass= "";

    public static Connection getDbConnection() throws Exception{
        PreparedStatement stmt = null;
        Class.forName(className);
        Connection connect = DriverManager.getConnection(url,uname,pass);
        return connect;
    }
}
