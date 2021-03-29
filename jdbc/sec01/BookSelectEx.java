package jdbc.sec01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookSelectEx {

	public static void main(String[] args) {
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
			
			String sql ="select*from book order by bookNo";
			
			// ������ ����� �� ��� �޾ƿ�
			// select �����̹Ƿ� executeQuery() �޼ҵ� ���
			// ����� ResultSet ��ü�� ��ȯ
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("���� ���� ��ȸ");
			System.out.println("������ȣ \t");
			
			
			// executeQuery()  ���� ����� �޾ƿ� ResultSet���� ������ ����
			// ResultSet�� next() �޼ҵ帣 �̿��ؼ�
			// ���� Ŀ���� �������� �̵��ذ��� �� ���� �����͸� ���̵��� ��
			// next() �޼ҵ� : Ŀ���� �̵��ϸ鼭 ���� �� ����
			// ���� ���� ������ true ��ȯ�ϰ�, ������ false ��ȯ
			// ��� ���� ���������� �ݺ����� ���
			// ������ ���� : ������ Ÿ�Կ� ���� getXXX() �޼ҵ� ���
			// ���ڿ� : getString()
			// ���� : getInt()
			// ��¥ : getDate()
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
			System.out.println("���� �߻�");
			e.printStackTrace();
		}

	}

}
