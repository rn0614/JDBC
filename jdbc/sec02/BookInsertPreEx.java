package jdbc.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookInsertPreEx {

	public static void main(String[] args) {
		//DB ���� Ȯ��
		Connection con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		if(con!= null) {
			System.out.println("DB ���� ����!");
		}
		

		
		/* DB ���� �Ϸ� */
		
		//db�������� �Է�
		Scanner sc = new Scanner(System.in);
		// ������ȣ ~ ���ǻ� ��ȣ �Է��ؼ� ������ ����
		
		System.out.println("���� ���� ���");
		System.out.print("������ȣ �Է� : ");
		String bookNo=sc.nextLine();
		
		System.out.print("������ �Է� : ");
		String bookName=sc.nextLine();
	
		System.out.print("���� �Է� : ");
		String bookAuthor=sc.nextLine();
		
		System.out.print("�������� �Է� : ");
		int bookPrice=sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("������ �Է� : ");
		String bookDate=sc.nextLine();
		
		System.out.print("��� �Է� : ");
		int bookStock=sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("���ǻ� ��ȣ �Է� : ");
		String pubNo=sc.nextLine();
		
		// insert ������ ����
		// sql ���ۼ�
		// preparedDatatement ���
		// ���� �� �ڸ��� '?'�� ���� - ���ε� ����
		try {
			String sql ="insert into book values (?,?,?,?,?,?,?)";
			
			// ������ ������ ���� PreparedStatement ��ü ����
			pstmt =con.prepareStatement(sql);
			
			// ���ε� ������ ������ ? �� ������ ��ġ�ؾ� ��.
			// ������ Ÿ�Կ� ���� ����Ǿ�� �ϱ� ����
			// ���۹�ȣ�� 1����
			// ���ε� ������ ���� �����ϱ� ���ؼ��� setXXX() �޼ҵ� ���
			pstmt.setString(1, bookNo);
			pstmt.setString(2, bookName);
			pstmt.setString(3, bookAuthor);
			pstmt.setInt(4, bookPrice);
			pstmt.setString(5, bookDate);
			pstmt.setInt(6, bookStock);
			pstmt.setString(7, pubNo);
			
			// insert, update, delete �������� executeUpdate() �޼ҵ� ���
			pstmt.executeUpdate();
			
			System.out.println("���� ���� ��� ����!");
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnect.close(con, pstmt);
		}
	}
}
