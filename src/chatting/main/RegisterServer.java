package chatting.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.util.Constant;
import chatting.vo.Message;

/**
 * 登录注册服务监听及处理, 数据接收socket，均采用5650端口
 * 
 * @author 紫风铃
 *
 */
public class RegisterServer extends Thread {
	/** 创建端口 */
	ServerSocket server = null;
	/** 端口号 */
	int PORT = Constant.getRegisterPort();
	Socket sk = null;
	UserDaoInter uDao = new UserDao();

	public RegisterServer() {
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
				sk = server.accept();// 每个请求交给一个线程去处理
				ServerThread th = new ServerThread(sk);
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
		BufferedReader bReader = null;
		PrintWriter pWriter = null;

		public ServerThread(Socket sk) {
			this.socket = sk;
		}

		public void run() {
			/** 接收的SMS */
			Message outFormatSMS = null;
		}
	}
}
