package PusanItMiddleSchool;
// 학생의 시험 성적을 입력하기 위한 창입니다.

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class recode_enroll extends JFrame {

	private JPanel contentPane;
	private JTextField S_Index_Field_ex;
	private JTextField S_Name_Field_ex;
	private JTextField Korean_Field_ex;
	private JTextField English_Field_ex;
	private JTextField Math_Field_ex;
	private JTextField Society_Field_ex;
	private JTextField Science_Field_ex;
	private JButton ExamRegister_Button;
	private JTextField S_testd_ex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recode_enroll frame = new recode_enroll();
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
	public recode_enroll() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 451, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Student_Index_ex = new JLabel("\uD559 \uC0DD \uBC88 \uD638");
		Student_Index_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Index_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Student_Index_ex.setBounds(74, 70, 90, 30);
		panel.add(Student_Index_ex);
		
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

		// 학생 이름을 입력하는 칸입니다.
		S_Index_Field_ex = new JTextField();
		S_Index_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		S_Index_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 10) { //엔터 입력하기
					try {
					String[] slist = SQLPusanItMiddleSchool.Outputsindex(S_Index_Field_ex.getText());
					System.out.println(slist[0]+" "+slist[1]);

					if(S_Index_Field_ex.getText().equals(slist[0])) {
						System.out.println("있습니다.");
						jlindex.setForeground(new Color(15,157,88));
						jlindex.setText("있습니다.");
						S_Name_Field_ex.setText(slist[1]);
						S_testd_ex.requestFocus();
					}
					}
					catch(NullPointerException e1){
						jlindex.setForeground(new Color(219,68,55));
						jlindex.setText("없습니다.");
						S_Name_Field_ex.setText(" ");
					}
				}					
				
			}
		});
		S_Index_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		S_Index_Field_ex.setColumns(10);
		S_Index_Field_ex.setBounds(176, 70, 161, 30);
		panel.add(S_Index_Field_ex);

		JLabel Student_Name_ex = new JLabel("\uD559 \uC0DD \uC774 \uB984");
		Student_Name_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Name_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Student_Name_ex.setBounds(74, 110, 90, 30);
		panel.add(Student_Name_ex);

		// 학생 번호를 입력하는 칸입니다.
		S_Name_Field_ex = new JTextField();
		S_Name_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		S_Name_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 10) { //엔터 입력하기
					try {
					String[] slist = SQLPusanItMiddleSchool.OutputSname(S_Name_Field_ex.getText());
					System.out.println(slist[0]+" "+slist[1]);
					if(S_Name_Field_ex.getText().equals(slist[1])) {
						System.out.println("있습니다.");
						jlindex.setForeground(new Color(15,157,88));
						jlindex.setText("있습니다.");
						S_Index_Field_ex.setText(slist[0]);
						S_testd_ex.requestFocus();}
					}
					catch(NullPointerException e1){
						jlindex.setForeground(new Color(219,68,55));
						jlindex.setText("없습니다.");
						S_Index_Field_ex.setText(" ");
					}
				}					
				
			}
		});
		S_Name_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		S_Name_Field_ex.setColumns(10);
		S_Name_Field_ex.setBounds(176, 110, 161, 30);
		panel.add(S_Name_Field_ex);
	
		JLabel Student_testd_ex = new JLabel("\uC2DC \uD5D8 \uC885 \uB958");
		Student_testd_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Student_testd_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Student_testd_ex.setBounds(74, 150, 90, 30);
		panel.add(Student_testd_ex);
		
		S_testd_ex = new JTextField();
		S_testd_ex.setHorizontalAlignment(SwingConstants.CENTER);
		S_testd_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		S_testd_ex.setColumns(10);
		S_testd_ex.setBounds(176, 150, 161, 30);
		S_testd_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //엔터 입력하기
					Korean_Field_ex.requestFocus();
				}						
			}
		});
		panel.add(S_testd_ex);
		
		
		JLabel Exam_List = new JLabel("\uACFC \uBAA9");
		Exam_List.setForeground(new Color(255, 255, 255));
		Exam_List.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_List.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Exam_List.setBounds(12, 190, 161, 30);
		panel.add(Exam_List);

		JLabel Exam_Score = new JLabel("\uC810 \uC218");
		Exam_Score.setForeground(new Color(255, 255, 255));
		Exam_Score.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_Score.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Exam_Score.setBounds(243, 190, 161, 30);
		panel.add(Exam_Score);
		
		JLabel Exam_Korean = new JLabel("\uAD6D \uC5B4");
		Exam_Korean.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_Korean.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Exam_Korean.setBounds(12, 230, 161, 30);
		panel.add(Exam_Korean);
		
		Korean_Field_ex = new JTextField();
		Korean_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Korean_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //엔터 입력하기
					English_Field_ex.requestFocus();
				}						
			}
		});
		Korean_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Korean_Field_ex.setColumns(10);
		Korean_Field_ex.setBounds(243, 235, 161, 25);
		panel.add(Korean_Field_ex);
		
		JLabel Exam_English = new JLabel("\uC218 \uD559");
		Exam_English.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_English.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Exam_English.setBounds(12, 260, 161, 30);
		panel.add(Exam_English);
		
		English_Field_ex = new JTextField();
		English_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		English_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //엔터 입력하기
					Math_Field_ex.requestFocus();
				}						
			}
		});
		English_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		English_Field_ex.setColumns(10);
		English_Field_ex.setBounds(243, 265, 161, 25);
		panel.add(English_Field_ex);
		
		JLabel Exam_Math = new JLabel("\uC601 \uC5B4");
		Exam_Math.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_Math.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Exam_Math.setBounds(12, 290, 161, 30);
		panel.add(Exam_Math);
		
		Math_Field_ex = new JTextField();
		Math_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Math_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //엔터 입력하기
					Society_Field_ex.requestFocus();
				}						
			}
		});
		Math_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Math_Field_ex.setColumns(10);
		Math_Field_ex.setBounds(243, 295, 161, 25);
		panel.add(Math_Field_ex);
		
		JLabel Exam_Society = new JLabel("\uACFC \uD559");
		Exam_Society.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_Society.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Exam_Society.setBounds(12, 320, 161, 30);
		panel.add(Exam_Society);
		
		Society_Field_ex = new JTextField();
		Society_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Society_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //엔터 입력하기
					Science_Field_ex.requestFocus();
				}						
			}
		});
		Society_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Society_Field_ex.setColumns(10);
		Society_Field_ex.setBounds(243, 325, 161, 25);
		panel.add(Society_Field_ex);
		
		JLabel Exam_Science = new JLabel("\uC0AC \uD68C");
		Exam_Science.setHorizontalAlignment(SwingConstants.CENTER);
		Exam_Science.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Exam_Science.setBounds(12, 350, 161, 30);
		panel.add(Exam_Science);
		
		Science_Field_ex = new JTextField();
		Science_Field_ex.setHorizontalAlignment(SwingConstants.CENTER);
		Science_Field_ex.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) { //엔터 입력하기
					Science_Field_ex.requestFocus();
				}						
			}
		});
		
		Science_Field_ex.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Science_Field_ex.setColumns(10);
		Science_Field_ex.setBounds(243, 355, 161, 25);
		panel.add(Science_Field_ex);
		
		ExamRegister_Button = new JButton("\uB4F1 \uB85D");
		
		// '등록' 버튼을 누르면 "등록되었습니다." 메시지가 뜹니다.
		
		ExamRegister_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S_INDEX = S_Index_Field_ex.getText();
				String S_NAME = S_Name_Field_ex.getText();
				String S_RNOTE = S_testd_ex.getText();
				String S_KOREAN = Korean_Field_ex.getText();
				String S_MATH = Math_Field_ex.getText();
				String S_ENGLISH = English_Field_ex.getText();
				String S_SCIENCE = Science_Field_ex.getText();
				String S_SOCIETY = Society_Field_ex.getText();	
				
				if (S_INDEX.trim().isEmpty() || S_NAME.trim().isEmpty()
						|| S_RNOTE.trim().isEmpty() || S_KOREAN.trim().isEmpty()
						|| S_MATH.trim().isEmpty() || S_ENGLISH.trim().isEmpty()
						|| S_SCIENCE.trim().isEmpty() || S_SOCIETY.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "입력란 빈칸 존재");}
				else {
				JOptionPane.showMessageDialog(null, "등록되었습니다.");
				SQLPusanItMiddleSchool.Input_Recode(S_INDEX, S_NAME,S_KOREAN, S_MATH, S_ENGLISH, S_SCIENCE, S_SOCIETY,S_RNOTE);
				}
				// SQLPusanItMiddleSchool과 연동.
				// 출결관리 창 작성 후 "등록"을 누르면 MySQL의 tbl_s_recode에 등록된다.

			}
		});
		ExamRegister_Button.setFont(new Font("나눔고딕", Font.BOLD, 15));
		ExamRegister_Button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ExamRegister_Button.setBackground(new Color(204, 204, 204));
		ExamRegister_Button.setBounds(176, 408, 60, 30);
		panel.add(ExamRegister_Button);
		
		JLabel Student_Register = new JLabel("\uC131 \uC801 \uB4F1 \uB85D");
		Student_Register.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Register.setForeground(Color.WHITE);
		Student_Register.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		Student_Register.setBounds(0, 0, 435, 51);
		panel.add(Student_Register);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 1, 435, 50);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(Color.WHITE);
		panel_1_1.setBackground(new Color(30, 144, 255));
		panel_1_1.setBounds(0, 190, 435, 30);
		panel.add(panel_1_1);
	
	// + 성공적으로 등록되면 "등록되었습니다" 팝업 메시지가 뜨도록 한다.
}
}