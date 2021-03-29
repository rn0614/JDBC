package jdbc.sec01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookInsertInputEx {

	public static void main(String[] args) {
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
		
		
		// DB ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "YSJUSER2";
			String pwd = "1234";
			
			Connection con = DriverManager.getConnection(url, user, pwd);
			
			// ��ü�� �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���� ����");
			}
			/*  DB ���� ���� ���� */
			
			/* ���� ���� */
			
			// select �� ����ؼ� ���� ���� ��ȸ
			// ������ ������ ���� Statement ��ü ����
			// Connecction �������̽��� createStatement() �޼ҵ� ����ؼ� ��ü ����
			Statement stmt = con.createStatement();
			
			/*����Ϸ�*/
			// insert ���� ����
			
			// ���� ������ ���� Statement ��ü ����
			
			//select ������ �ۼ�
			//String sql = String.format("insert in book(�� ����Ʈ) values(���� ������)", ���� ����Ʈ);
			
			String sql =String.format("insert into book(bookNo, bookName,bookAuthor,bookPrice,bookDate,bookStock,pubNo)"
					+ "values('%s','%s','%s','%d','%s','%d','%s')",
					bookNo, bookName,bookAuthor,bookPrice,bookDate,bookStock,pubNo);
			
			// ������ ����� �� ��� �޾ƿ�
			// select �����̹Ƿ� executeQuery() �޼ҵ� ���
			// ����� ResultSet ��ü�� ��ȯ
			int result =stmt.executeUpdate(sql);
			if(result>0) System.out.println("���� ���� ��� ����");
			
		
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("���� �߻�");
			e.printStackTrace();
		}

	}

}
