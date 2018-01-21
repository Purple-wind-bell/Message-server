package chatting.UI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendMessageUI extends JFrame {

	void sendmessage() {
		Container c = this.getContentPane();

		c.setLayout(new FlowLayout());

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();

		JLabel jl1 = new JLabel("收件人：");
		final JTextField jtf1 = new JTextField(25);

		JLabel jl2 = new JLabel(
				"内容：                                                                                                 ");

		JTextArea jta1 = new JTextArea(25, 30);

		JLabel jl3 = new JLabel("编辑信息：");
		final JTextField jtf2 = new JTextField(23);

		JButton jb1 = new JButton("发送");
		JButton jb2 = new JButton("退出");

		c.add(jp1);
		c.add(jp2);
		c.add(jp3);
		c.add(jp4);
		c.add(jp5);

		jp1.add(jl1);
		jp1.add(jtf1);

		jp2.add(jl2);

		jp3.add(jta1);

		jp4.add(jl3);
		jp4.add(jtf2);

		jp5.add(jb1);
		jp5.add(jb2);

		this.setVisible(true);
		this.setTitle("短信");
		this.setSize(400, 620);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(SendMessageUI.EXIT_ON_CLOSE);
		this.setResizable(false);

		// 输入的手机号控制为11位
		jtf1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				String s = jtf1.getText();
				if (s.length() >= 11) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// 编辑的短信内容控制为140位
		jtf2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				String s = jtf2.getText();
				if (s.length() >= 140) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JOptionPane.showMessageDialog(null, "成功发送！", "提示", JOptionPane.PLAIN_MESSAGE);

				JOptionPane.showMessageDialog(null, "发送失败！", "提示", JOptionPane.ERROR_MESSAGE);
			}
		});

		// 退出
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

}
