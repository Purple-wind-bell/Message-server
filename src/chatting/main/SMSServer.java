package chatting.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.services.SMSHandle;
import chatting.services.SendMessage;
import chatting.util.Constant;
import chatting.util.FormatUtil;

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
			String insms = null;
			FormatSMS outFormatSMS = null;
			try {
				BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (insms == null) {
					insms = bReader.readLine();
				}
				// 格式化信息
				FormatSMS inFormatSMS = FormatUtil.toFormatSMS(insms);
				if (inFormatSMS.getCmd().equals("CMD003")) {// 仅处理普通短信
					outFormatSMS = new SMSHandle().process(inFormatSMS);// 进行短信处理，获得返回短信
//					System.out.println(outFormatSMS.toString());
					new SendMessage(outFormatSMS).send();// 发送回复短信
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
