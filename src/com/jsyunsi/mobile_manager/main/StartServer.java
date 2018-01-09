package com.jsyunsi.mobile_manager.main;

/**
 * 服务器启动
 * 
 * @author Administrator
 *
 */
public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterServer().start();
		System.out.println("启动注册服务器...");
		new SMSServer().start();
		System.out.println("启动消息服务器...");

		// 监听用户在线状态，不在线自动注销
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// UserDaoInter udao = new UserDao();
		// LoginRegisterService lrService = new LoginRegisterService();
		// ArrayList<User> userIDList = null;
		// int port = Constant.getClientSMSPort();// 客户端短信端口
		// User user = null;
		// while (true) {
		// userIDList = udao.getAllUser();
		// Iterator<User> iterator = userIDList.iterator();
		// while (iterator.hasNext()) {
		// user = iterator.next();
		// if (user.isOnlineStatus() || !Tools.isHostConnectable(user.getUserIP(),
		// port)) {// 无法连接客户端
		// lrService.logout(user.getUserID());
		// }
		// }
		// try {
		// new Thread();
		// Thread.sleep(50000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
		// }).start();
	}

}
