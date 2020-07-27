package PusanItMiddleSchool;

// »õ·Î¿î ÇÐ»ýÀ» µî·ÏÇÏ´Â Ã¢ÀÔ´Ï´Ù.

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class student_enroll extends JFrame {

	private JPanel contentPane;
	private JTextField S_Name_Field;
	private JTextField S_Birth_Field;
	private JTextField S_Phone_Field;
	private JTextField S_etc_Field;
	private JTextField S_Index_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_enroll frame = new student_enroll();
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
	public student_enroll() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 451, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 435, 461);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Student_Register = new JLabel("\uD559 \uC0DD \uB4F1 \uB85D");
		Student_Register.setForeground(new Color(255, 255, 255));
		Student_Register.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		Student_Register.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Register.setBounds(0, 0, 435, 51);
		panel.add(Student_Register);
		
		JLabel Student_Index_ = new JLabel("\uD559 \uC0DD \uBC88 \uD638");
		Student_Index_.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Index_.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_Index_.setBounds(74, 80, 90, 30);
		panel.add(Student_Index_);
		
		S_Index_Field = new JTextField();
		S_Index_Field.setHorizontalAlignment(SwingConstants.CENTER);
		S_Index_Field.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_Index_Field.setColumns(10);
		S_Index_Field.setBounds(176, 80, 161, 30);
		panel.add(S_Index_Field);

		JLabel Student_Name = new JLabel("\uC774 \uB984");
		Student_Name.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Name.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_Name.setBounds(74, 124, 90, 30);
		panel.add(Student_Name);

		S_Name_Field = new JTextField();
		S_Name_Field.setHorizontalAlignment(SwingConstants.CENTER);
		S_Name_Field.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_Name_Field.setColumns(10);
		S_Name_Field.setBounds(176, 124, 161, 30);
		panel.add(S_Name_Field);

		JLabel Student_Gender = new JLabel("\uC131 \uBCC4");
		Student_Gender.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Gender.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_Gender.setBounds(74, 168, 90, 30);
		panel.add(Student_Gender);

		String[] combo_gender = { "³²ÀÚ", "¿©ÀÚ" };
		JComboBox S_Gender_Box = new JComboBox(combo_gender);
		S_Gender_Box.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_Gender_Box.setBorder(new EmptyBorder(0, 0, 0, 0));
		S_Gender_Box.setBackground(Color.WHITE);
		S_Gender_Box.setAlignmentX(0.0f);
		S_Gender_Box.setBounds(176, 168, 161, 30);
		panel.add(S_Gender_Box);

		JLabel Student_Class = new JLabel("\uD559 \uBC18");
		Student_Class.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Class.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_Class.setBounds(74, 212, 90, 30);
		panel.add(Student_Class);

		// ÇÐ¹ÝÀº ÀÓÀÇ·Î 1ÇÐ³â AºÎÅÍ 3ÇÐ³â C±îÁö ÀÛ¼º
		String[] combo_class = { "1A", "1B", "1C", "2A", "2B", "2C", "3A", "3B", "3C" };
		JComboBox S_Class_Box = new JComboBox(combo_class);
		S_Class_Box.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_Class_Box.setBorder(new EmptyBorder(0, 0, 0, 0));
		S_Class_Box.setBackground(Color.WHITE);
		S_Class_Box.setAlignmentX(0.0f);
		S_Class_Box.setBounds(176, 212, 161, 30);
		panel.add(S_Class_Box);

		JLabel Student_Birth = new JLabel("\uC0DD \uB144 \uC6D4 \uC77C");
		Student_Birth.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Birth.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_Birth.setBounds(74, 256, 90, 30);
		panel.add(Student_Birth);

		S_Birth_Field = new JTextField();
		S_Birth_Field.setHorizontalAlignment(SwingConstants.CENTER);
		S_Birth_Field.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_Birth_Field.setColumns(10);
		S_Birth_Field.setBounds(176, 256, 161, 30);
		panel.add(S_Birth_Field);

		JLabel Student_Phone = new JLabel("\uC5F0 \uB77D \uCC98");
		Student_Phone.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Phone.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_Phone.setBounds(74, 296, 90, 30);
		panel.add(Student_Phone);

		S_Phone_Field = new JTextField();
		S_Phone_Field.setForeground(Color.BLACK);
		S_Phone_Field.setHorizontalAlignment(SwingConstants.CENTER);
		S_Phone_Field.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_Phone_Field.setColumns(10);
		S_Phone_Field.setBounds(176, 296, 161, 30);
		panel.add(S_Phone_Field);

		JLabel Student_etc = new JLabel("µî·Ï ¿©ºÎ");
		Student_etc.setHorizontalAlignment(SwingConstants.CENTER);
		Student_etc.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		Student_etc.setBounds(74, 340, 90, 30);
		panel.add(Student_etc);

		S_etc_Field = new JTextField("µî·Ï");
		S_etc_Field.setHorizontalAlignment(SwingConstants.CENTER);
		S_etc_Field.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		S_etc_Field.setColumns(10);
		S_etc_Field.setBounds(176, 340, 161, 30);
		panel.add(S_etc_Field);

		// [ µî·Ï ] ¹öÆ°
		JButton Student_Register_Button = new JButton("\uB4F1 \uB85D");
		
		
		Student_Register_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String S_Index_Txt = S_Index_Field.getText();
				String S_Name_Txt = S_Name_Field.getText();
				String S_Gender_Txt = S_Gender_Box.getSelectedItem().toString();
				String S_Class_Txt = S_Class_Box.getSelectedItem().toString();
				String S_Birth_Txt = S_Birth_Field.getText();
				String S_Phone_Txt = S_Phone_Field.getText();
				String S_etc_Txt = S_etc_Field.getText();
				
				if (S_Name_Txt.trim().isEmpty() || S_Birth_Txt.trim().isEmpty()
						|| S_Index_Txt.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ÀÔ·Â¶õ ºóÄ­ Á¸Àç");}
				
				else {
				JOptionPane.showMessageDialog(null, "µî·ÏµÇ¾ú½À´Ï´Ù.");
				SQLPusanItMiddleSchool.Input_Student(S_Index_Txt, S_Name_Txt, S_Gender_Txt, S_Class_Txt, S_Birth_Txt, S_Phone_Txt, S_etc_Txt);
				}
				
			}
		});
		// SQLPusanItMiddleSchool°ú ¿¬µ¿.
		// ÇÐ»ýµî·Ï Ã¢ ÀÛ¼º ÈÄ "µî·Ï"À» ´©¸£¸é MySQLÀÇ tbl_student¿¡ µî·ÏµÈ´Ù.
		
		Student_Register_Button.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		Student_Register_Button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Student_Register_Button.setBackground(new Color(204, 204, 204));
		Student_Register_Button.setBounds(176, 408, 60, 30);
		panel.add(Student_Register_Button);
		
		Student_Register_Button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Student_Register_Button.setBackground(new Color(204, 204, 204));
		Student_Register_Button.setBounds(176, 408, 60, 30);
		panel.add(Student_Register_Button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 435, 50);
		panel.add(panel_1);
	}
}