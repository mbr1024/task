package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0_Util {
	private static ComboPooledDataSource ds = null;
	//在静态代码块中创建数据库连接池
	static{
		try{
			ds = new ComboPooledDataSource();//使用C3P0的默认配置来创建数据源
		}catch (Exception e) {
			
		}
	}
	
	//从数据源中获取数据库连接
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	//释放资源， 释放的资源包括Connection数据库连接对象，负责执行SQL命令的PreparedStatement对象，存储查询结果的ResultSet对象
	public static void release(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(rs!=null){
			try {
				//关闭存储查询结果的ResultSet对象
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstmt!=null){
			try {
				//关闭负责执行SQL命令的Statement对象
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				//将Connection连接对象还给数据库连接池
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//释放资源， 释放的资源包括Connection数据库连接对象，负责执行SQL命令的PreparedStatement对象
	public static void release(Connection conn,PreparedStatement pstmt){
		
		if(pstmt!=null){
			try {
				//关闭负责执行SQL命令的Statement对象
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				//将Connection连接对象还给数据库连接池
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}