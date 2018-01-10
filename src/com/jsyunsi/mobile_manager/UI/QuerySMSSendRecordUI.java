package com.jsyunsi.mobile_manager.UI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.jsyunsi.mobile_manager.services.QueryRecordService;
import com.jsyunsi.mobile_manager.servicesInter.QueryRecordInter;

/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class QuerySMSSendRecordUI extends JFrame {
	private String sourceAddress;
	private JTextArea jta1 = new JTextArea(28, 80);
	private QueryRecordInter queryRecord = new QueryRecordService();
	private JTextField jtf1 = new JTextField(25);

	void querysms() {
		Container c = this.getContentPane();
		// 流布局
		c.setLayout(new FlowLayout());
		// 三个面板
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		// 输入手机号
		JLabel jl1 = new JLabel("手机号：");
		// 显示查询内容
		JLabel jl2 = new JLabel(
				"已发短信：                                                                                        ");
		// 在文本框上添加滚动条
		JScrollPane jsp = new JScrollPane(jta1);
		// 设置矩形大小.参数依次为(矩形左上角横坐标x,矩形左上角纵坐标y，矩形长度，矩形宽度)
		jsp.setBounds(13, 10, 650, 340);
		// 默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// 按钮
		JButton jb1 = new JButton("查询");
		JButton jb2 = new JButton("返回");

		c.add(jp1);
		c.add(jp4);
		c.add(jp2);
		c.add(jp3);
		// 面板1 是输入手机号
		jp1.add(jl1);
		jp1.add(jtf1);
		// 面板2 是显示查询内容,把滚动条添加到容器里面
		jp2.add(jsp);
		// 面板3 是两个按钮
		jp3.add(jb1);
		jp3.add(jb2);

		jp4.add(jl2);

		this.setVisible(true);
		this.setTitle("查询已发短信记录");
		this.setSize(1000, 620);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(QuerySMSSendRecordUI.EXIT_ON_CLOSE);
		// this.setResizable(false);

		// 输入的手机号控制为11位
		jtf1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				String s = jtf1.getText().toString().trim();
				if (s.length() >= 11) {
					e.consume();
				}
				sourceAddress = s;
			}
		});

		// 查询记录
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String record = queryRecord.SMSHistoryQueryBySender(sourceAddress);
				jta1.setText(record.toString());
			}
		});

		// 点击返回按钮 返回查询系统界面
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

}
