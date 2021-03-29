package jdbc.sec01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookSelectEx {

	public static void main(String[] args) {
		// DB 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "YSJUSER2";
			String pwd = "1234";
			
			Connection con = DriverManager.getConnection(url, user, pwd);
			
			// 객체가 생성되면 DB 연결 성공
			if(con != null) {
				System.out.println("DB 연결 성공");
			}
			/*  DB 연결 과정 종료 */
			
			/* 쿼리 진행 */
			
			// select 문 사용해서 도서 정보 조회
			// 쿼리문 전송을 위한 Statement 객체 생성
			// Connecction 인터페이스의 createStatement() 메소들 사용해서 객체 생성
			Statement stmt = con.createStatement();
			
			/*연결완료*/
			// insert 구문 실행
			
			// 쿼리 전송을 위한 Statement 객체 생성
			
			//select 쿼리문 작성
			
			String sql ="select*from book order by bookNo";
			
			// 쿼리문 실행된 후 결과 받아옴
			// select 구문이므로 executeQuery() 메소드 사용
			// 결과는 ResultSet 객체로 반환
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("도서 정보 조회");
			System.out.println("도서번호 \t");
			
			
			// executeQuery()  실행 결과로 받아온 ResultSet에서 데이터 추출
			// ResultSet의 next() 메소드르 이용해서
			// 논리적 커서를 다음으로 이동해가며 각 열의 데이터를 바이딩해 옴
			// next() 메소드 : 커서를 이동하면서 다음 행 지정
			// 다음 행이 있으면 true 반환하고, 없으면 false 반환
			// 모든 행을 가져오려면 반복문을 사용
			// 데이터 추출 : 데이터 타입에 맞춰 getXXX() 메소드 사용
			// 문자열 : getString()
			// 정수 : getInt()
			// 날짜 : getDate()
			while(rs.next()) {
				String bookNo =rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice =rs.getInt(4);
				Date bookDate =rs.getDate(5);
				int bookStock =rs.getInt(6);
				String pubNo =rs.getString(7);
				
				System.out.format("%-10s\t %-30s\t %-10s %6d %13s \t%3d %10s",
						bookNo,bookName,bookAuthor,bookPrice,bookDate,bookStock,pubNo);
				
				System.out.println();// 
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}

	}

}
