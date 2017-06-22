package com.example;

import com.example.dao.HelloDAO;
import com.example.vo.Hello;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.example.mybatis.MyBatisConnectionFactory;

public class Main {
        
        static final String DB_NAME = "mavenspring";
        static final String TABLE_NAME = "info";
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost/";
        
        //  Database credentials
        static final String USER = "root";
        static final String PASS = "";

	public static void main(String args[]){
            
            createDB(DB_NAME);
            createTable(TABLE_NAME, DB_NAME);
            addToDB();
            
            
        }
        
        public void init() {
            String[] args = {};
            Main main = new Main();
            main.main(args);
        }
        
        public static void addToDB() {
            HelloDAO helloDAO = new HelloDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            
            Hello hello = new Hello();
            hello.setId(1);
            hello.setName("Hello World");
            helloDAO.insert(hello);
        }
        
        public static void createTable(String name, String dbName){
            String url = "jdbc:mysql://localhost/" + dbName;
            Connection conn = null;
            Statement stmt = null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, USER, PASS);
                stmt = conn.createStatement();
                
                String sql = "CREATE TABLE IF NOT EXISTS " + name +
                        "(id int NOT NULL, " +
                        " name VARCHAR(255) not null, " +
                        " primary key (id)) ";
                stmt.executeUpdate(sql);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                try {
                    if(stmt!=null)
                        stmt.close();
                } catch(SQLException e) {
               
                }
                try {
                    if(conn!=null)
                        conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
        }
        
        public static String createDB(String name){
            Connection conn = null;
            Statement stmt = null;
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                
                String sql = "CREATE DATABASE IF NOT EXISTS " + name;
                stmt.executeUpdate(sql);
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                try {
                    if(stmt!=null)
                        stmt.close();
                } catch(SQLException e) {
               
                }
                try {
                    if(conn!=null)
                        conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            return name;
        }
}
