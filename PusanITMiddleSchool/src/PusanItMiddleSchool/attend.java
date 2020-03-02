package PusanItMiddleSchool;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class attend extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attend frame = new attend();
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
	public attend() {
		
		
		String[] sabsent = new String[5];
		
		setTitle("출석관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null); //화면 중앙
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton inputbutton = new JButton("\uD559\uC0DD\uB4F1\uB85D");
		inputbutton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		inputbutton.setBackground(Color.LIGHT_GRAY);
		inputbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new attend_enroll().setVisible(true);
			}
		});
		inputbutton.setBounds(1075, 603, 97, 23);
		inputbutton.setText("출석등록");
		contentPane.add(inputbutton);
		
		JButton StudentTable = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		StudentTable.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		StudentTable.setBackground(Color.WHITE);
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
		RecodeTable.setBackground(Color.WHITE);
		RecodeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new recode().setVisible(true);
			}
		});
		RecodeTable.setBounds(153, 25, 129, 34);
		contentPane.add(RecodeTable);
		
		JButton button_1 = new JButton("\uCD9C\uC11D\uAD00\uB9AC");
		button_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(294, 25, 129, 34);
		contentPane.add(button_1);
		
		JButton btnNewButton_2 = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(1066, 25, 106, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("찾기");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(644, 23, 70, 34);
		contentPane.add(lblNewLabel);
		
		String[][] data = SQLPusanItMiddleSchool.getSAbsent();	//DB 데이터 연동
		String[] headers = { "학번", "이름", "학반", "날짜", "출석관리"}; 
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		
		JTable table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		table.setRowHeight(30); // 테이블 높이
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setLocation(38,128);
		scrollPane.setSize(550, 449);
		
		contentPane.add(scrollPane);
		
		
		JTextField textField = new JTextField();
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
		
		JPanel panel = new JPanel();
		panel.setBounds(629, 128, 506, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(111, 148, 95, 59);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uD559\uBC88");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(111, 79, 95, 59);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(111, 225, 95, 59);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(111, 294, 95, 59);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel sindex1 = new JLabel();
		sindex1.setHorizontalAlignment(SwingConstants.CENTER);
		sindex1.setFont(new Font("굴림", Font.PLAIN, 14));
		sindex1.setBounds(249, 79, 95, 59);
		panel.add(sindex1);
		
		JLabel sname1 = new JLabel();
		sname1.setHorizontalAlignment(SwingConstants.CENTER);
		sname1.setFont(new Font("굴림", Font.PLAIN, 14));
		sname1.setBounds(249, 148, 95, 59);
		panel.add(sname1);
		
		JLabel sbirth = new JLabel();
		sbirth.setHorizontalAlignment(SwingConstants.CENTER);
		sbirth.setFont(new Font("굴림", Font.PLAIN, 14));
		sbirth.setBounds(251, 225, 95, 59);
		panel.add(sbirth);
		
		JLabel snote = new JLabel();
		snote.setHorizontalAlignment(SwingConstants.CENTER);
		snote.setFont(new Font("굴림", Font.PLAIN, 14));
		snote.setBounds(251, 294, 95, 59);
		panel.add(snote);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 1184, 81);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\\uD504\uB85C\uC81D\uD2B8\\PusanITMiddleSchool\\img\\\uCEA1\uCC98.PNG"));
		lblNewLabel_2.setBounds(4, 581, 278, 70);
		contentPane.add(lblNewLabel_2);
		
		table.addMouseListener(new MouseAdapter() { //클릭시 빈칸에 데이터 들어가도록 만들기
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  int row = table.getSelectedRow(); // 선택된 행 값을 인트로 반환
				  int col = table.getSelectedColumn(); // 선택된 열 값을 인트로 변환
				  sabsent[0] = new String((String) table.getModel().getValueAt(row, 0)); //학번
				  sabsent[1] = new String((String) table.getModel().getValueAt(row, 1)); //이름
				  
				  String[] absentlist = SQLPusanItMiddleSchool.OutputSAbsent(sabsent[0],sabsent[1]); 
				  //학번이름으로 검색하고 필요한 학생정보 리스트로 얻어오기
				  				  
				  sindex1.setText(absentlist[0]);
				  sname1.setText(absentlist[1]);
				  sbirth.setText(absentlist[2]);
				  snote.setText(absentlist[3]);
				  // 정보 변경하기
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String[][] data = SQLPusanItMiddleSchool.getSAbsent();	//DB 데이터 연동				
				model.setRowCount(0); //테이블 데이터 모두 삭제
				//String[][] data = Customer.getCustomers();
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
			}
		});
	}
}
