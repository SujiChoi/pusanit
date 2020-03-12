package PusanItMiddleSchool;
// 학생 출결을 등록하기 위한 창입니다.

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class attend_enroll extends JFrame {

	private JPanel contentPane;
	private JTextField S_Index_att;
	private JTextField S_Name_att;
	private JTextField S_Date_att;
	JLabel Student_Name_att; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attend_enroll frame = new attend_enroll();
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
	public attend_enroll() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 451, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 434, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Student_Index_att = new JLabel("\uD559 \uC0DD \uBC88 \uD638");
		Student_Index_att.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Index_att.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Student_Index_att.setBounds(74, 70, 90, 30);
		panel.add(Student_Index_att);
		
		JLabel jlindex = new JLabel("");
		jlindex.setHorizontalAlignment(SwingConstants.CENTER);
		jlindex.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jlindex.setBounds(330, 70, 90, 30);
		panel.add(jlindex);
		
		JLabel jlname = new JLabel("");
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		jlname.setBounds(330, 110, 90, 30);
		panel.add(jlname);

		S_Index_att = new JTextField(); // 학생 이름을 입력하는 칸입니다.
		S_Index_att.setHorizontalAlignment(SwingConstants.CENTER);
		S_Index_att.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 10) { //엔터 입력하기
					try {
					String[] slist = SQLPusanItMiddleSchool.Outputsindex(S_Index_att.getText());
					if(S_Index_att.getText().equals(slist[0])) {
						System.out.println("있습니다.");
						jlindex.setForeground(new Color(15,157,88));
						jlindex.setText("있습니다.");
						S_Name_att.setText(slist[1]);
						S_Date_att.requestFocus();}
					}
					catch(NullPointerException e1){
						jlindex.setForeground(new Color(219,68,55));
						jlindex.setText("없습니다.");
						S_Name_att.setText(" ");
					}
				}					
				
			}
		});
		
		S_Index_att.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		S_Index_att.setColumns(10);
		S_Index_att.setBounds(176, 70, 161, 30);
		panel.add(S_Index_att);

		Student_Name_att = new JLabel("\uD559 \uC0DD \uC774 \uB984");
		Student_Name_att.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Name_att.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Student_Name_att.setBounds(74, 110, 90, 30);
		panel.add(Student_Name_att);

		S_Name_att = new JTextField();
		S_Name_att.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 10) { //엔터 입력하기
					try {
					String[] slist = SQLPusanItMiddleSchool.OutputSname(S_Name_att.getText());
					System.out.println(slist[0]+" "+slist[1]);
					if(S_Name_att.getText().equals(slist[1])) {
						System.out.println("있습니다.");
						jlindex.setForeground(new Color(15,157,88));
						jlindex.setText("있습니다.");
						S_Index_att.setText(slist[0]);
						S_Date_att.requestFocus();}
					}
					catch(NullPointerException e1){
						jlindex.setForeground(new Color(219,68,55));
						jlindex.setText("없습니다.");
						S_Index_att.setText(" ");
					}
				}					
				
			}
		});
		S_Name_att.setHorizontalAlignment(SwingConstants.CENTER);
		S_Name_att.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		S_Name_att.setColumns(10);
		S_Name_att.setBounds(176, 110, 161, 30);
		panel.add(S_Name_att);
		

		JLabel Student_Date_ex = new JLabel("\uB0A0 \uC9DC");
		Student_Date_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Date_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Student_Date_ex.setBounds(74, 150, 90, 30);
		panel.add(Student_Date_ex);
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());
		
		S_Date_att = new JTextField(format_time1);
		S_Date_att.setHorizontalAlignment(SwingConstants.CENTER);
		S_Date_att.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		S_Date_att.setColumns(10);
		S_Date_att.setBounds(176, 150, 161, 30);
		panel.add(S_Date_att);
		// 학반은 임의로 넣은 것입니다 (1학년 A반부터 3학년 C반까지)

		JLabel Attend_Register2 = new JLabel("\uCD9C \uACB0 \uC0AC \uD56D");
		Attend_Register2.setHorizontalAlignment(SwingConstants.CENTER);
		Attend_Register2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Attend_Register2.setBounds(12, 241, 411, 30);
		panel.add(Attend_Register2);

		// 학생의 출결 사항을 선택하는 창입니다.
		String[] combo_att = { "출석", "지각", "결석" };
		JComboBox Result_Select = new JComboBox(combo_att);
		Result_Select.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Result_Select.setBorder(new EmptyBorder(0, 0, 0, 0));
		Result_Select.setBackground(new Color(255, 255, 255));
		Result_Select.setAlignmentX(0.0f);
		Result_Select.setBounds(112, 281, 211, 30);
		panel.add(Result_Select);

		// 출결관리 등록 버튼입니다.
		JButton AttendRegister_Button = new JButton("\uB4F1 \uB85D");
		
		// '등록' 버튼을 누르면 "등록되었습니다." 메시지가 뜹니다.
		
		AttendRegister_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S_Index_attTxt = S_Index_att.getText();
				String S_Name_attTxt = S_Name_att.getText();
				String S_Date_attTxt = S_Date_att.getText();
				String S_Result_attTxt = Result_Select.getSelectedItem().toString();
				
				if (S_Index_attTxt.trim().isEmpty() || S_Name_attTxt.trim().isEmpty()
						|| S_Date_attTxt.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "입력란 빈칸 존재");}
				else {
				JOptionPane.showMessageDialog(null, "등록되었습니다.");
				SQLPusanItMiddleSchool.Input_absent(S_Index_attTxt, S_Date_attTxt, S_Result_attTxt);
				}
				// SQLPusanItMiddleSchool과 연동.
				// 출결관리 창 작성 후 "등록"을 누르면 MySQL의 tbl_s_absent에 등록된다.

			}
		});
		AttendRegister_Button.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		AttendRegister_Button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		AttendRegister_Button.setBackground(new Color(204, 204, 204));
		AttendRegister_Button.setBounds(189, 408, 60, 30);
		panel.add(AttendRegister_Button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 435, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Student_Register = new JLabel("\uCD9C \uACB0 \uAD00 \uB9AC");
		Student_Register.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Register.setForeground(Color.WHITE);
		Student_Register.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Student_Register.setBounds(0, 0, 435, 51);
		panel_1.add(Student_Register);
	}
}