package jdbc.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookDeletePreEx {

	public static void main(String[] args) {
		// DB 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		// 삭제할 도서 번호 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 정보 삭제 번호 입력 : ");
		String bookNo =sc.nextLine();
		
		
		try {
			con=DBConnect.getConnection();
			
			// sql문 작성 - 쿼리 수행
			String sql ="delete from book where bookNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,bookNo);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnect.close(con, pstmt);
		}
	}
}
