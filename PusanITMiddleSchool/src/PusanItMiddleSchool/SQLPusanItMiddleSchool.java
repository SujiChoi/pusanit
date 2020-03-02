

package PusanItMiddleSchool;

import java.sql.*;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JOptionPane;

public class SQLPusanItMiddleSchool {

	public static void main(String[] args) {
		//creat_Student_Table();
		//creat_Teacher_Table();
		creat_Recode_Table();
		//creat_SAbsent_Table();
		//Input_Student("최수지","여","A1","20000101","서울시 강남구","없음");
		//Input_Teacher("강사1","여","pusanit001","pusanit","20100101","01012345678");
		//Input_Recode("1","최수지","60","70","80","90","100");
		//Input_SAbsent("2","하지원","20200224","결석");  // 나중에 학번하고 이름 매칭 후 등록하고 테이블 만들기 때문에
	}
	
	public static void creat_Student_Table() {
		try {
			Connection conn = getConnection(); // 학생관리
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_STUDENT("
					+"S_INDEX int NOT NULL AUTO_INCREMENT,"  // 아이디는 나중에 수정 (오늘날짜 + 뭐?)
					+"S_NAME varChar(255)," 
					+"S_GENDER varChar(255),"
					+"S_CLASS varChar(255),"
					+"S_BIRTH varChar(255),"
					+"S_PHONE varChar(255),"
					+"S_NOTE varChar(255)," //특이사항
					+"PRIMARY KEY(S_INDEX))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	
	public static void creat_Teacher_Table() { //선생관리
		try {
			Connection conn = getConnection(); 
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_TEACHER("
					+"T_INDEX int NOT NULL AUTO_INCREMENT," //선생인덱스 1,2,3
					+"T_NAME varChar(255)," //이름
					+"T_GENDER varChar(255)," //성별		
					+"T_ID varChar(255)," //아이디
					+"T_PASSWORD varChar(255)," //비밀번호					
					+"T_BIRTH varChar(255)," //생년월일
					+"T_PHONE varChar(255)," //번호			
					+"PRIMARY KEY(T_INDEX))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	public static void creat_Recode_Table() { //성적관리
		try {
			Connection conn = getConnection(); 
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_RECODE("
					+"S_INDEX varChar(255)," //학색인덱스
					+"S_NAME varChar(255)," //학생이름
					+"S_TESTDATE varChar(255)," //시험날짜
					+"S_KOREAN varChar(255)," //국어
					+"S_MATH varChar(255)," //수학
					+"S_ENGLISH varChar(255)," //영어
					+"S_SCIENCE varChar(255)," //과학
					+"S_SOCIETY varChar(255)," //사회
					+"KEY(S_INDEX))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	
	public static void creat_SAbsent_Table() { //결석관리
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+"TBL_S_ABSENT("
					+"S_INDEX varChar(255),"
					+"A_DATE varChar(255)," //absent_date
					+"A_RESULT varChar(255)," //absent_결과
					+"KEY(S_INDEX))");
			create.execute();
			System.out.println("저장했습니다.");
		}
		catch(Exception e){}
	}
	
	
	public static String[][] getStudents() {
		try {
			Connection conn = getConnection(); // DB 연결
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM tbl_student");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
					results.getString("S_INDEX"),
					results.getString("S_NAME"),
					results.getString("S_GENDER"),
					results.getString("S_CLASS"),
					results.getString("S_BIRTH"),
					results.getString("S_PHONE"),	
					results.getString("S_NOTE")
				});
			}
			System.out.println("저장했습니다.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[][] getRecode() {
		try {
			Connection conn = getConnection(); // DB 연결
			PreparedStatement statement = conn.prepareStatement(
					"SELECT S.S_INDEX, S.S_NAME, R.S_TESTDATE,R.S_KOREAN, R.S_MATH,R.S_ENGLISH,R.S_SCIENCE,R.S_SOCIETY "
					+"FROM pusanttmiddleschooldb.tbl_student S ,pusanttmiddleschooldb.tbl_recode R where S.S_INDEX = R.S_INDEX");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
					results.getString("S_INDEX"),
					results.getString("S_NAME"),
					results.getString("S_TESTDATE"),
					results.getString("S_KOREAN"),
					results.getString("S_MATH"),
					results.getString("S_ENGLISH"),
					results.getString("S_SCIENCE"),	
					results.getString("S_SOCIETY")
				});
			}
			System.out.println("저장했습니다.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String[][] getSAbsent() {
		try {
			Connection conn = getConnection(); // DB 연결
			PreparedStatement statement = conn.prepareStatement(
					"SELECT S.S_INDEX,S.S_NAME,S.S_CLASS,A.A_DATE,A.A_RESULT from pusanttmiddleschooldb.tbl_student S ,pusanttmiddleschooldb.tbl_s_absent A where S.S_INDEX = A.S_INDEX"
					);
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
					results.getString("S_INDEX"),
					results.getString("S_NAME"),
					results.getString("S_CLASS"),
					results.getString("A_DATE"),
					results.getString("A_RESULT"),
				});
			}
			System.out.println("저장했습니다.");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void Input_Student(String S_NAME,String S_GENDER,String S_CLASS,String S_BIRTH,String S_PHONE,String S_NOTE) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create1 = conn.prepareStatement(
					"insert into tbl_student(S_NAME,S_GENDER,S_CLASS,S_BIRTH,S_PHONE,S_NOTE)"
					+ "values('"+S_NAME+"','"+S_GENDER+"','"+S_CLASS+"','"+S_BIRTH+"','"+S_PHONE+"','"+S_NOTE+"')"
					);
			create1.execute();
			System.out.println("학생 정보가 저장했습니다.");		
			}
		catch(Exception e){}
	}

	public static void Input_SAbsent(String S_INDEX,String S_NAME,String A_DATE,String A_RESULT) {
		try {
			
			String sindex= S_INDEX; //선택시 불러오기
			String sname = S_NAME;
			
			//if (A,A);
			
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"insert into tbl_s_absent(S_INDEX,A_DATE,A_RESULT)"
					+ "values('"+S_INDEX+"','"+A_DATE+"','"+A_RESULT+"')"
					);
			create.execute();
			System.out.println("출결관리 정보가 저장했습니다.");
		}
		catch(Exception e){}
	}
	
	public static void Input_Recode(String S_INDEX,String S_NAME,String S_TESTDATE,String S_KOREAN,String S_MATH,
			String S_ENGLISH,String S_SCIENCE,String S_SOCIETY) {
		try {
			
			String sindex= S_INDEX; //선택시 불러오기
			String sname = S_NAME;
			
			//if (A,A);
			
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"insert into tbl_recode(S_INDEX,S_NAME,S_TESTDATE,S_KOREAN,S_MATH,S_ENGLISH,S_SCIENCE,S_SOCIETY)"
					+ "values('"+S_INDEX+"','"+S_NAME+"','"+S_TESTDATE+"','"+S_KOREAN+"','"+S_MATH+"','"+S_ENGLISH+"','"+S_SCIENCE+"','"+S_SOCIETY+"')"
					);
			create.execute();
			System.out.println("성적 정보가 저장했습니다.");
		}
		catch(Exception e){}
	}
	
	public static void Input_Teacher(String T_NAME,String T_GENDER,String T_ID,
			String T_PASSWORD,String T_BIRTH,String T_PHONE) {
		try {
			
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"insert into tbl_teacher(T_NAME,T_GENDER,T_ID,T_PASSWORD,T_BIRTH,T_PHONE)"
					+ "values('"+T_NAME+"','"+T_GENDER+"','"+T_ID+"','"+T_PASSWORD+"','"+T_BIRTH+"','"+T_PHONE+"')"
					);
			create.execute();
			System.out.println("선생님 정보를 저장했습니다.");
		}
		catch(Exception e){}
	}
	
	
	public static String[] OutputSAbsent(String sindex, String sname){
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM pusanttmiddleschooldb.tbl_student S,pusanttmiddleschooldb.tbl_s_absent A where S.S_INDEX=? && A.S_INDEX=?"
					);
			statement.setString(1, sindex);
			statement.setString(2, sindex);
			ResultSet results = statement.executeQuery();
			String[] sbsentlist = new String[4];
			
			if(results.next()) { //결과값이 있으면 로그인이 됨
				sbsentlist[0]=results.getString("S_INDEX");
				sbsentlist[1]=results.getString("S_NAME");
				sbsentlist[2]=results.getString("S_BIRTH");
				sbsentlist[3]=results.getString("S_NOTE");
			//원래 있던창 끄기
		}
			System.out.println("검색되었습니다.");
			
			return sbsentlist;
					} //리스트를 어레이로 바꾸는데 arr형식으로
			
			catch(Exception e){
				System.out.println("검색실패");return null;}
	}
	
	public static String[] OutputSname(String s_name) {
		try {
			Connection conn = getConnection();
			PreparedStatement sname = conn.prepareStatement(
					"SELECT * FROM pusanttmiddleschooldb.tbl_student where S_NAME = ?");
			sname.setString(1, s_name);
			ResultSet results = sname.executeQuery();
			results.next();
			String[] slist = new String[2];
			slist[0] = results.getString("S_INDEX");
			slist[1] = results.getString("S_NAME");
			return slist;
		}
		
		catch(Exception e){return null;}
	}
	
	public static String[] Outputsindex(String s_index) {
		try {
			Connection conn = getConnection();
			PreparedStatement sname = conn.prepareStatement(
					"SELECT * FROM pusanttmiddleschooldb.tbl_student where S_INDEX = ?");
			sname.setString(1, s_index);
			ResultSet results = sname.executeQuery();
			results.next();
			String[] slist = new String[2];
			slist[0] = results.getString("S_INDEX");
			slist[1] = results.getString("S_NAME");
			return slist;
		}
		
		catch(Exception e){return null;}
	}
	
	public static String OutputTID(String t_id) {
		try {
			Connection conn = getConnection();
			System.out.println("BB");
			PreparedStatement sname = conn.prepareStatement(
					"SELECT * FROM pusanttmiddleschooldb.tbl_teacher where T_ID = '"+t_id+"'");
			//sname.setString(1, t_id);
			ResultSet results = sname.executeQuery();
			results.next();
			String slist = results.getString("T_ID");
			return slist;
		}
		
		catch(Exception e){return null;}
	}
	
	public static boolean ModifyStudentTable(String strpid,String strpname,String strgender, String strclass, String strpbirth,String strpphone,String strnote) {
		// 학번 , 이름, 성별, 학반, 생년월일, 연락처, 기타
		try {
			String[] modiplist = {strpname,strgender,strclass,strpbirth,strpphone,strnote,strpid};
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create1 = conn.prepareStatement(
					"UPDATE pusanttmiddleschooldb.tbl_student SET S_NAME=?,S_GENDER=?,S_CLASS=?,S_BIRTH=?,S_PHONE=?,S_NOTE=? WHERE S_INDEX=?"
					);
			for(int i =0;i<7;i++) {
				create1.setString(i+1, modiplist[i]);
			}
			create1.execute();
			
			JOptionPane.showMessageDialog(null, "학생정보가 수정이 완료 되었습니다.");
			return true;
		}
		catch(Exception e){return true;}
	}
	public static boolean login(String hid, String hpw) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM tbl_teacher where T_ID =? and T_PASSWORD =?" //물음표값을  setString으로 넣어준다.
					);
			statement.setString(1, hid);
			statement.setString(2, hpw);
			System.out.println("BB");
			ResultSet results = statement.executeQuery();
			if(results.next()) { //결과값이 있으면 로그인이 됨
				System.out.println("CC");
				return true;
				//원래 있던창 끄기
			}else {
				System.out.println("DD");
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 한번 확인해 주세요.");
				return false;
			}
		}
		catch(Exception e){return false;}
	}
	public static void Input_Student
	(String S_INDEX, String S_NAME, String S_GENDER, String S_CLASS, String S_BIRTH,
			String S_PHONE, String S_NOTE) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create1 = conn
					.prepareStatement(
							"insert into tbl_student(S_INDEX, S_NAME, S_GENDER, S_CLASS, S_BIRTH, S_PHONE, S_NOTE)"
							+ "values ('" + S_INDEX + "','" + S_NAME + "','" + S_GENDER + "','" + S_CLASS + "','"
							+ S_BIRTH + "','" + S_PHONE + "','" + S_NOTE + "')"
							);
			create1.execute();
			System.out.println("학생 정보가 저장되었습니다.");
		} catch (Exception e) {
		}
	}
	
	public static void Input_Teacher
	(String T_INDEX, String T_NAME, String T_GENDER, String T_ID, String T_PASSWORD,
			String T_BIRTH, String T_PHONE) {
		try {
			Connection conn = getConnection(); // db 연결 conn객체
			PreparedStatement create1 = conn
					.prepareStatement(
							"insert into tbl_teacher(T_INDEX, T_NAME, T_GENDER, T_ID, T_PASSWORD, T_BIRTH, T_PHONE)"
							+ "values ('" + T_INDEX + "','" + T_NAME + "','" + T_GENDER + "','" + T_ID + "','"
							+ T_PASSWORD + "','" + T_BIRTH + "','" + T_PHONE + "')"
							);
			create1.execute();
			System.out.println("선생님의 정보가 저장되었습니다.");
		} catch (Exception e) {
		}
	}
	
	public static void Input_absent(String S_INDEX, String A_DATE, String A_RESULT) {
	try {
		Connection conn = getConnection(); // db 연결 conn객체
		PreparedStatement create = conn.prepareStatement(
				"insert into tbl_s_absent (S_INDEX,A_DATE, A_RESULT)"
				+ "values('" + S_INDEX + "','" + A_DATE + "','" + A_RESULT + "')"
				);
		create.execute();
		System.out.println("출결관리 정보가 저장되었습니다.");
	}
	catch(Exception e){}
	}
	
	public static void Input_recode
	(String S_INDEX, String S_KOREAN, String S_MATH, String S_ENGLISH, String S_SCIENCE, String S_SOCIETY) {
	try {
		Connection conn = getConnection(); // db 연결 conn객체
		PreparedStatement create = conn.prepareStatement(
				"insert into tbl_recode (S_INDEX, S_KOREAN, S_MATH, S_ENGLISH, S_SCIENCE, String S_SOCIETY)"
				+ "values('" + S_INDEX + "','" + S_KOREAN + "','" + S_MATH + "','" + S_ENGLISH + "','" + S_SCIENCE + "','" + S_SOCIETY + "')"	 
				);
		create.execute();
		System.out.println("성적 정보가 저장되었습니다.");
	}
	catch(Exception e){}
	}
	
	public static Connection getConnection() {
		String drive = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/pusanttmiddleschooldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "1234";
		System.out.println("AA");
		try {
			Class.forName(drive);
			System.out.println("AA");
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 완료");
			return conn;
			
		}catch(Exception e){
			System.out.println("연결 문제");
			return null;
		}
	}
}
