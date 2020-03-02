package PusanItMiddleSchool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class datamodify extends JFrame {

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
					datamodify frame = new datamodify(index, name);
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
	public datamodify(String index, String name) {
		setBounds(100, 100, 406, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC218\uC815 \uC815\uBCF4 \uC785\uB825");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 19));
		lblNewLabel.setBounds(0, 31, 390, 54);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(111, 97, 185, 41);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.setBounds(149, 172, 97, 23);
		contentPane.add(btnNewButton);
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
