package chatting.main;

/**
 * 服务器启动
 * 
 * @author Administrator
 *
 */
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterServer().start();
		new SMSServer().start();
	}

}
