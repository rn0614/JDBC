package jdbc.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookInsertPreEx {

	public static void main(String[] args) {
		//DB 연결 확인
		Connection con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		if(con!= null) {
			System.out.println("DB 연결 성공!");
		}
		

		
		/* DB 연결 완료 */
		
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
		
		// insert 쿼리문 수행
		// sql 문작성
		// preparedDatatement 사용
		// 열의 값 자리에 '?'로 지정 - 바인딩 변수
		try {
			String sql ="insert into book values (?,?,?,?,?,?,?)";
			
			// 쿼리문 전송을 위한 PreparedStatement 객체 생성
			pstmt =con.prepareStatement(sql);
			
			// 바인딩 변수의 순서는 ? 의 순서와 일치해야 함.
			// 데이터 타입에 맞춰 저장되어야 하기 때문
			// 시작번호는 1부터
			// 바인딩 변수에 값을 저장하기 위해서는 setXXX() 메소드 사용
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookName);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);
			
			// insert, update, delete 문에서는 executeUpdate() 메소드 사용
			pstmt.executeUpdate();
			
			System.out.println("도서 정보 등록 성공!");
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnect.close(con, pstmt);
		}
	}
}
