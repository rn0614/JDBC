package jdbc.sec01;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		
		
		try {
			//OracleDriver 클래스의 객체 생성 : 런타임시 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//연결주소, 사용자 계정, 패스워드 문자열로 설정
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user ="YSJUSER2";
			String pwd ="1234";
			
			//DB 연결하기 위한 객체
			//DriverManager를 통해 Connection 객체 생성
			//getConnection() 메소드 호출하고 개체 받아옴.
			//매개변수 : url, user, pwd
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			//객체가 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB 연결성공");
			}
			
		
		} catch (Exception e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}

	}

}
