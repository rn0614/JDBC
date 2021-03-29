package jdbc.sec01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookInsertInputEx {

	public static void main(String[] args) {
		//db도서정보 입력
				Scanner sc = new Scanner(System.in);
				// 도서번호 ~ 출판사 번호 입력해서 변수에 저장
				
				System.out.println("도서 정보 등록");
				System.out.print("도서번호 입력 : ");
				String bookNo=sc.nextLine();
				
				System.out.print("도서명 입력 : ");
				String bookName=sc.nextLine();
			
				System.out.print("저자 입력 : ");
				String bookAuthor=sc.nextLine();
				
				System.out.print("도서가격 입력 : ");
				int bookPrice=sc.nextInt();
				
				sc.nextLine();
				
				System.out.print("발행일 입력 : ");
				String bookDate=sc.nextLine();
				
				System.out.print("재고 입력 : ");
				int bookStock=sc.nextInt();
				
				sc.nextLine();
				
				System.out.print("출판사 번호 입력 : ");
				String pubNo=sc.nextLine();
		
		
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
			//String sql = String.format("insert in book(열 리스트) values(서식 지정자)", 변수 리스트);
			
			String sql =String.format("insert into book(bookNo, bookName,bookAuthor,bookPrice,bookDate,bookStock,pubNo)"
					+ "values('%s','%s','%s','%d','%s','%d','%s')",
					bookNo, bookName,bookAuthor,bookPrice,bookDate,bookStock,pubNo);
			
			// 쿼리문 실행된 후 결과 받아옴
			// select 구문이므로 executeQuery() 메소드 사용
			// 결과는 ResultSet 객체로 반환
			int result =stmt.executeUpdate(sql);
			if(result>0) System.out.println("도서 정보 등록 성곤");
			
		
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}

	}

}
