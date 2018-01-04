package com.jsyunsi.mobile_manager.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	/** 创建端口 */
	ServerSocket server = null;
	/** 端口号 */
	int PORT = 5600;
	/** IP地址 */
	String IP = "127.0.0.1";
	/** SMS */
	String sms = null;
	Socket socket = null;
	BufferedReader rdr = null;
	PrintWriter wtr = null;
	String line = null;

	public Server() {
		try {
			server = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			System.out.println("Listenning...");
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

	public static void main(String[] args) {
		Server s = new Server();
		s.start();
	}

	class ServerThread extends Thread {
		Socket sk = null;

		public ServerThread(Socket sk) {
			this.sk = sk;
		}

		public void run() {
			try {
				wtr = new PrintWriter(sk.getOutputStream());
				rdr = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				line = rdr.readLine();
				System.out.println("从客户端来的信息：" + line);
				// 特别，下面这句得加上 “\n”,
				wtr.println("你好，服务器已经收到您的信息！'" + line + "'\n");
				wtr.flush();
				System.out.println("已经返回给客户端！");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					sk.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}