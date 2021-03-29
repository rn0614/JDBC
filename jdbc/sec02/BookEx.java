package jdbc.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class BookEx {

	
	
	public static void main(String[] args) {
		// 2021년 이후 발행된 도서만 출력
		// 저자 이름에 '길동'이 들어가는 도서 검색
		// 가격이 30,000 이상인 도서 검색
		// 총 도서 권수 출력
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
			con = DBConnect.getConnection();
			
			System.out.println("도서 정보 조회 ");
			
			//sql 문 작성
			String sql ="select*from book where bookDate like'2021%' order by bookNo";
			String sql1 ="select*from book where bookAuthor like'%길동%' order by bookNo";
			String sql2 ="select*from book where bookPrice>=30000 order by bookNo";
			String sql3 ="select count(*) from book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select 구문에서는 executeQuery 메소드 사용
			
			
			//ResultSet의 next() 메소드 사용해서 한행씩 데이터 출력
			// 반복문 사용
			// next() : 다음행이 있으면 true 
			while(rs.next()) {
				String bookNo =rs.getString(1);
				String bookName = rs.getString(2);
				String bookAuthor = rs.getString(3);
				int bookPrice =rs.getInt(4);
				Date bookDate =rs.getDate(5);
				int bookStock =rs.getInt(6);
				String pubNo =rs.getString(7);
				
				System.out.format("%-10s\t %-25s\t %-10s %6d %13s \t%3d %10s",
						bookNo,bookName,bookAuthor,bookPrice,bookDate,bookStock,pubNo);
				
				System.out.println();
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnect.close(con, pstmt, rs);
		}
		

	}

}
