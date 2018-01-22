package chatting.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.util.Constant;

/**
 * 服务器非登录注册服务监听及处理, 数据接收socket，均采用5600端口
 * 
 * @author 紫风铃
 *
 */
public class SMSServer extends Thread {
	/** 创建端口 */
	ServerSocket server = null;
	/** 端口号 */
	int PORT = Constant.getServerSMSPort();
	Socket socket = null;
	UserDaoInter uDao = new UserDao();

	public SMSServer() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 信息处理
	 */
	public void run() {
		while (true) {
			try {
				socket = server.accept();// 每个请求交给一个线程去处理
				ServerThread th = new ServerThread(socket);
				th.start();
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 内部类，创建进程处理短信
	 * 
	 * @author Administrator
	 *
	 */
	class ServerThread extends Thread {
		Socket socket = null;

		public ServerThread(Socket sk) {
			this.socket = sk;
		}

		public void run() {
			/** 接收的SMS */
		}
	}
}
