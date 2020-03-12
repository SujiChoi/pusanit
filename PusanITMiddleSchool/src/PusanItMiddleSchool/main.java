package PusanItMiddleSchool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("부산 IT 학생 관리 프로그램 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbTitle = new JLabel("\uD559\uC0DD \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		lbTitle.setForeground(Color.BLACK);
		lbTitle.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(0, 10, 434, 39);
		panel.add(lbTitle);
		
		//아이디
		JLabel lbID = new JLabel("\uC544\uC774\uB514");
		lbID.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lbID.setBounds(67, 88, 83, 29);
		panel.add(lbID);

		textField_ID = new JTextField();
		textField_ID.setBounds(140, 92, 138, 25);
		panel.add(textField_ID);
		textField_ID.setColumns(10);
		
		//비밀번호123
		JLabel lbPassword = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lbPassword.setBounds(67, 127, 83, 29);
		panel.add(lbPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 131, 138, 25);
		panel.add(passwordField);
		
		// 로그인 버튼
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SQLPusanItMiddleSchool.login(textField_ID.getText(), passwordField.getText())) {
					dispose();
					new student().setVisible(true);
					}
				else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해 주세요.");
					}
			}
		});
		btnLogin.setBounds(296, 106, 97, 39);
		panel.add(btnLogin);
		
		//회원가입 버튼
		JButton btnSignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnSignup.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main_teacher_enroll().setVisible(true);
			}
		});
		btnSignup.setBounds(325, 222, 97, 29);
		panel.add(btnSignup);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\\uD504\uB85C\uC81D\uD2B8\\PusanITMiddleSchool\\img\\\uCEA1\uCC98.PNG"));
		lblNewLabel_2.setBounds(12, 181, 278, 70);
		panel.add(lblNewLabel_2);
	}
}
