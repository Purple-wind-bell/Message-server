package chatting.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import chatting.dao.UserDao;
import chatting.daoInter.UserDaoInter;
import chatting.services.SMSHandle;
import chatting.util.Constant;
import chatting.util.FormatUtil;
import chatting.vo.FormatSMS;

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
			String insms = null;
			FormatSMS outFormatSMS = null;
			try {
				bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pWriter = new PrintWriter(socket.getOutputStream());
				while (insms == null) {
					insms = bReader.readLine();
				}
				// System.out.println("服务器接收信息：" + insms.toString());
				// 格式化信息
				FormatSMS inFormatSMS = FormatUtil.toFormatSMS(insms);
				if (inFormatSMS.getCmd().equals("CMD001") || inFormatSMS.getCmd().equals("CMD002")) {// 仅处理登录注册注销短信
					// System.out.println(inFormatSMS.toString());
					outFormatSMS = new SMSHandle().process(inFormatSMS);// 进行短信处理，获得返回短信
					pWriter.println(FormatUtil.toStringSMS(outFormatSMS));// 发送回复短信
					pWriter.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
