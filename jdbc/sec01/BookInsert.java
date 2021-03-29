package jdbc.sec01;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.Statement;

public class BookInsert {

	public static void main(String[] args) {
		//����� ���� ���� ��
		
		try {
			//OracleDriver Ŭ������ ��ü ���� : ��Ÿ�ӽ� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//�����ּ�, ����� ����, �н����� ���ڿ��� ����
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user ="YSJUSER2";
			String pwd ="1234";
			
			//DB �����ϱ� ���� ��ü
			//DriverManager�� ���� Connection ��ü ����
			//getConnection() �޼ҵ� ȣ���ϰ� ��ü �޾ƿ�.
			//�Ű����� : url, user, pwd
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			//��ü�� �����Ǹ� DB ���� ����
			if(con != null) {
				System.out.println("DB ���Ἲ��");
			}
			
			/*DB ���� �Ϸ�*/
			// ���� ������ ���� Statement ��ü ����
			Statement stmt = con.createStatement();
			
			//insert ���� ����
			
			//insert ������ �ۼ�
			String sql = "insert into book values('10012','�ڹ�','���ڹ�',10000,'2021-01-01',5,'2')";
			//����
			int result =stmt.executeUpdate(sql);
			
			// ������ ���� (������ ���� ���� �� ��ȯ) result= ���� ���� ���� ��
			if(result>0)
				System.out.println("���� ���� ��� ����");
		
			System.out.println();
			
			stmt.close();
			con.close();
		
		} catch (Exception e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}

	}

}