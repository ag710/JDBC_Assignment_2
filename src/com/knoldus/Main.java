package com.knoldus;
import java.sql.*;
public class Main {
    static Connection connection = null;
    static PreparedStatement stmt = null;
    static ResultSet rs;

    public void dbConnect() throws Exception{
        connection = JDBC_Connection.getDbConnection();
    }

    //Question 1.
    public void inputProducts(int pid, double price, String name) throws Exception{
        String query = "Insert the values for the products table (id,price,prod_name)";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1,pid);
        stmt.setDouble(2,price);
        stmt.setString(3,name);
        int cnt = stmt.executeUpdate();
        System.out.println(cnt + " rows Effected");

    }
    public void inputCartData(int pid, int qty) throws Exception {
        String query = "Insert the values into carts table (pid,qty)";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, pid);
        stmt.setInt(2, qty);

        int cnt = stmt.executeUpdate();
        System.out.println(cnt + " rows changed");
    }

    //Question 2
    public void printData(int pid) throws Exception{
        String query = "SELECT * FROM products WHERE products.pid =" +pid;
        stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println(rs.getDouble(2) + " " + rs.getString(3));
        }
        else{
            System.out.println("Empty");
        }

    }

    //Question 3
    public void avgPrice() throws Exception{
        String query = "SELECT pid ,AVG(price) AS 'Avg Price' FROM products GROUP BY pid";
        stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1) + "  " + rs.getDouble(2));
        }
    }


    public static void main(String[] args) throws Exception{
        Main obj = new Main();
        obj.dbConnect();
        obj.inputProducts(24,55,"Product_Apoorv");
        obj.inputCartData(3,4);
        obj.printData(10);
        obj.avgPrice();
        stmt.close();
        connection.close();
    }
}
