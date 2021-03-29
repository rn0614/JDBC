package jdbc.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookDeletePreEx {

	public static void main(String[] args) {
		// DB ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		// ������ ���� ��ȣ �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� ���� ��ȣ �Է� : ");
		String bookNo =sc.nextLine();
		
		
		try {
			con=DBConnect.getConnection();
			
			// sql�� �ۼ� - ���� ����
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
