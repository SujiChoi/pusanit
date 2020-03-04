package PusanItMiddleSchool;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class student_modify extends JFrame {

	private JPanel contentPane;
	private static String index = null;
	private static String name = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_modify frame = new student_modify(index,name);
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
	public student_modify(String index, String name) {
		setBounds(100, 100, 354, 249);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD559\uC0DD \uC815\uBCF4 \uC218\uC815");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("���� ����", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 21, 338, 54);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setBounds(81, 85, 185, 41);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.setFont(new Font("���� ����", Font.PLAIN, 12));
		btnNewButton.setBounds(124, 152, 97, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 21, 338, 54);
		contentPane.add(panel);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//label.setText(field.getText());
				System.out.println(index+" "+name+" ");
				SQLPusanItMiddleSchool.update(index, name, textArea.getText());
				dispose();
			}
			
		});
	}
}