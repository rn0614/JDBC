package jdbc.sec01;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.Statement;

public class BookInsert {

	public static void main(String[] args) {
		//등록할 도서 정보 입
		
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
			
			/*DB 연결 완료*/
			// 쿼리 전송을 위한 Statement 객체 생성
			Statement stmt = con.createStatement();
			
			//insert 구문 실행
			
			//insert 쿼리문 작성
			String sql = "insert into book values('10012','자바','김자바',10000,'2021-01-01',5,'2')";
			//실행
			int result =stmt.executeUpdate(sql);
			
			// 쿼리문 실행 (영향을 받은 행의 수 반환) result= 영향 받은 행의 수
			if(result>0)
				System.out.println("도서 정보 등록 성공");
		
			System.out.println();
			
			stmt.close();
			con.close();
		
		} catch (Exception e) {
			System.out.println("오류발생");
			e.printStackTrace();
		}

	}

}