package chatting.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 参数配置
 * 
 * @author Administrator
 *
 */
public final class Constant {
	/** MySQL数据库连接 */
	public static String MYSQL_URL = "jdbc:mysql://localhost:3306/mobile_message";
	/** MySQL用户 */
	public static String MYSQL_USER = "root";
	/** MySQL用户密码 */
	public static String MYSQL_PASSWORD = "123456";
	/** 客户端普通短信接收端口 */
	public static int CLIENT_MESSAGE_PORT = 5700;
	/** 服务器普通短信收发端口 */
	public static int SERVER_MESSAGE_PORT = 5600;
	/** 服务器注册登录端口 */
	public static int LOGIN_PORT = 5650;

	static {
		Properties p = new Properties();
		// com/jsyunsi/mobile_manager/config/
		InputStream in = Constant.class.getClassLoader().getResourceAsStream("mobile.properties");
		try {
			p.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MYSQL_URL = p.getProperty("mysqlUrl");
		MYSQL_USER = p.getProperty("mysqlUser");
		MYSQL_PASSWORD = p.getProperty("mysqlPasswd");
		CLIENT_MESSAGE_PORT = Integer.parseInt(p.getProperty("clientSMSPort"));
		SERVER_MESSAGE_PORT = Integer.parseInt(p.getProperty("serverSMSPort"));
		LOGIN_PORT = Integer.parseInt(p.getProperty("registerPort"));
	}

	private Constant() {
	}

}
