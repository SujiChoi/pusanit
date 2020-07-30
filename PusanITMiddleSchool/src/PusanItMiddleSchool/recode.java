package PusanItMiddleSchool;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;


public class recode extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recode frame = new recode();
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
	public recode() {
		
		setTitle("성적관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null); //화면 중앙
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] data = SQLPusanItMiddleSchool.getRecode();	//DB 데이터 연동
		String[] headers = { "학번", "이름","국어", "수학", "영어", "과학","사회","시험종류" }; 
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		
		JTable table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		table.setRowHeight(30); // 테이블 높이
		JScrollPane scrollPane = new JScrollPane(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				String[] headers = { "S_INDEX","S_NAME","S_KOREAN","S_MATH","S_ENGLISH","S_SCIENCE","S_SOCIETY","S_RNOTE"};
				//String sindex = new String((String) table.getModel().getValueAt(row, 0));
				if(row >= 0 && col >= 0) {
					//JOptionPane.showMessageDialog(null, row+","+col);
					if(col== 0|| col==1) {
						JOptionPane.showMessageDialog(null,"학생 정보는 수정 불가합니다.");
					}else {
					new recode_modify(row+1,headers[col]).setVisible(true);}
				}
			}
		});
		
		scrollPane.setLocation(5,128);
		scrollPane.setSize(1167, 449);
		
		contentPane.add(scrollPane);
		
		JButton inputbutton = new JButton("\uD559\uC0DD\uB4F1\uB85D");
		inputbutton.setBackground(Color.LIGHT_GRAY);
		inputbutton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		inputbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new recode_enroll().setVisible(true);
			}
		});
		inputbutton.setBounds(1075, 603, 97, 23);
		inputbutton.setText("성적등록");
		contentPane.add(inputbutton);
		
		JButton StudentTable = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		StudentTable.setBackground(Color.WHITE);
		StudentTable.setForeground(Color.BLACK);
		StudentTable.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		StudentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new student().setVisible(true);
			}
		});
		StudentTable.setBounds(12, 25, 129, 34);
		contentPane.add(StudentTable);
		
		JButton RecodeTable = new JButton("\uC131\uC801\uAD00\uB9AC");
		RecodeTable.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		RecodeTable.setBackground(Color.ORANGE);
		RecodeTable.setBounds(153, 25, 129, 34);
		contentPane.add(RecodeTable);
		
		JButton SabsentTable = new JButton("\uCD9C\uC11D\uAD00\uB9AC");
		SabsentTable.setBackground(Color.WHITE);
		SabsentTable.setForeground(Color.BLACK);
		SabsentTable.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		SabsentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new attend().setVisible(true);
			}
		});
		SabsentTable.setBounds(294, 25, 129, 34);
		contentPane.add(SabsentTable);
		
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
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_2.setBounds(1066, 25, 106, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("찾기");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(644, 23, 70, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 1184, 81);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		URL imageURL = getClass().getResource("main1.png");
		lblNewLabel_2.setIcon(new ImageIcon(imageURL));
		lblNewLabel_2.setBounds(4, 581, 278, 70);
		contentPane.add(lblNewLabel_2);
		
		//테이블 그리기
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String[][] data = SQLPusanItMiddleSchool.getRecode();	//DB 데이터 연동				
				model.setRowCount(0); //테이블 데이터 모두 삭제
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
			}
		});
	}
}
