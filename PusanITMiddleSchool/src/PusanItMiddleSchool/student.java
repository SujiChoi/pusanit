package PusanItMiddleSchool;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;


public class student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student frame = new student();
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
	public student() {
		
		setTitle("�л�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null); //ȭ�� �߾�
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] data = SQLPusanItMiddleSchool.getStudents();	//DB ������ ����
		String[] headers = { "�й�", "�̸�", "����", "�й�", "�������", "����ó","��Ÿ(Ư�̻���)" }; 
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		
		JTable table = new JTable(model);
		table.setFont(new Font("���� ���", Font.PLAIN, 18));
		table.setRowHeight(30); // ���̺� ����
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setLocation(5,128);
		scrollPane.setSize(1167, 449);
		
		contentPane.add(scrollPane);
		
		JButton inputbutton = new JButton("\uD559\uC0DD\uB4F1\uB85D");
		inputbutton.setBackground(Color.LIGHT_GRAY);
		inputbutton.setFont(new Font("���� ���", Font.PLAIN, 14));
		inputbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new student_enroll().setVisible(true);
			}
		});
		inputbutton.setBounds(1075, 603, 97, 23);
		inputbutton.setText("�л����");
		contentPane.add(inputbutton);
		
		JButton StudentTable = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		StudentTable.setFont(new Font("���� ���", Font.PLAIN, 14));
		StudentTable.setBackground(Color.ORANGE);
		StudentTable.setBounds(12, 25, 129, 34);
		contentPane.add(StudentTable);
		
		JButton RecodeTable = new JButton("\uC131\uC801\uAD00\uB9AC");
		RecodeTable.setBackground(Color.WHITE);
		RecodeTable.setFont(new Font("���� ���", Font.PLAIN, 14));
		RecodeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new recode().setVisible(true);
			}
		});
		RecodeTable.setBounds(153, 25, 129, 34);
		contentPane.add(RecodeTable);
		
		
		JButton SAbsentTable = new JButton("\uCD9C\uC11D\uAD00\uB9AC");
		SAbsentTable.setBackground(Color.WHITE);
		SAbsentTable.setFont(new Font("���� ���", Font.PLAIN, 14));
		SAbsentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new attend().setVisible(true);
			}
		});
		SAbsentTable.setBounds(294, 25, 129, 34);
		contentPane.add(SAbsentTable);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String val = textField.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		textField.setBounds(726, 26, 294, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnNewButton_2.setBounds(1066, 25, 106, 34);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String[][] data = SQLPusanItMiddleSchool.getStudents();	//DB ������ ����				
				model.setRowCount(0); //���̺� ������ ��� ����
				//String[][] data = Customer.getCustomers();
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("ã��");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(644, 23, 70, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 1184, 81);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\\uD504\uB85C\uC81D\uD2B8\\PusanITMiddleSchool\\img\\\uCEA1\uCC98.PNG"));
		lblNewLabel_2.setBounds(5, 587, 278, 70);
		contentPane.add(lblNewLabel_2);
		
		table.addMouseListener(new MouseAdapter() { //Ŭ���� ��ĭ�� ������ ������ �����
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {}
					
					@Override
					public void keyReleased(KeyEvent e) {}
					
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == 10) {
							int row = table.getSelectedRow(); // ���õ� �� ���� ��Ʈ�� ��ȯ
							  int col = table.getSelectedColumn(); // ���õ� �� ���� ��Ʈ�� ��ȯ
							  String[] Slist = new String[7];
							  for (int i = 0; i < 7; i++) {
								  Slist[i] = new String((String) table.getModel().getValueAt(row, i ));  //�𵨿��� �� �ҷ����� 
							  }
							  System.out.println(e.getKeyCode());
							  SQLPusanItMiddleSchool.ModifyStudentTable(Slist[0],Slist[1],Slist[2],Slist[3],Slist[4],Slist[5],Slist[6]);
							  // �й� , �̸�, ����, �й�, �������, ����ó, ��Ÿ
						}
						
					}
				});
			}
		});
	}
}
