package chatting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接及释放的工具类
 * 
 * @author 紫风铃
 *
 */
public class DBUtil {

	private DBUtil() {
	}

	/**
	 * 获得数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Constant.MYSQL_URL, Constant.MYSQL_USER, Constant.MYSQL_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 释放数据库连接
	 * 
	 * @param connection
	 *            数据库连接
	 */
	public static void releaseConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("释放失败");
		}
	}

}
