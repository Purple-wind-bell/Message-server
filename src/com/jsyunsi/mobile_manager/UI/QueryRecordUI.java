package com.jsyunsi.mobile_manager.UI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QueryRecordUI extends JFrame {

	public void queryrecord() {
		Container c = this.getContentPane();

		c.setLayout(new GridLayout(4, 1));

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		JButton jb1 = new JButton("查询交易记录");
		JButton jb2 = new JButton("查询短信记录");
		JButton jb3 = new JButton("    发送短信     ");
		JButton jb4 = new JButton("        退出          ");

		c.add(jp1);
		c.add(jp2);
		c.add(jp3);
		c.add(jp4);

		jp1.add(jb1);
		jp2.add(jb2);
		jp3.add(jb3);
		jp4.add(jb4);

		this.setVisible(true);
		this.setTitle("查询系统");
		this.setSize(400, 200);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(QueryRecordUI.EXIT_ON_CLOSE);
		this.setResizable(false);

		// 按钮1 查询交易记录
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new QueryTransactionUI().querytransaction();
			}
		});

		// 按钮2 查询短信记录
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String options[] = { "查看发送的短信", "查看收到的短信" };
				int i = JOptionPane.showOptionDialog(QueryRecordUI.this, "选择查看发送/接收的短信：", "查看短信",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "查看发送的短信");
				if (i != JOptionPane.CLOSED_OPTION) {
					switch (i) {
					case 0:
						new QuerySMSSendRecordUI().querysms();
						break;
					case 1:
						new QuerySMSReceiveRecordUI().querysms();
						break;
					default:
						break;
					}
				}
			}
		});

		// 按钮3 进入发送短信界面
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new SendMessageUI().sendmessage();
			}
		});

		// 按钮4 退出当前界面
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

	}

}
