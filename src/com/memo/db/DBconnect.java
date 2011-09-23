package com.memo.db;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBconnect {
	
	static FileInputStream fis = null ;
	static Properties pro =null;

	public static Connection getConnection() throws SQLException {
		
		String driver ="";
		String url = "";
		String id = "";
		String password = "";
		
		try {
			
			
			pro = new Properties();
			fis = new FileInputStream("C:\\javaworks\\javaBegin\\src\\jdbc.Properties");
			pro.load(fis);
			
			driver = pro.getProperty("dbdriver");
			url = pro.getProperty("dburl");
			id = pro.getProperty("dbID");
			password = pro.getProperty("dbPW");
			
			Class.forName(driver);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(url, id, password);
	}
}
