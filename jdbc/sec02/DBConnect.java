package jdbc.sec02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	//�̱��� ���� �̿� : ��ü �Ѱ��� ����
	private static Connection con;
	
	// Connection ��ü �����ؼ� ��ȯ�ϴ� �޼ҵ�
	public static Connection getConnection() {
		//���� ���� ���ڿ� ����
		//�����ּ�, ����� ����, �н����� ���ڿ��� ����
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user ="YSJUSER2";
		String pwd ="1234";
		
		//connection ��ü ����
		try {
			con =DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
			e.printStackTrace();
		}
		return con;
		
		
	}
	//�ڿ� ��ȯ �޼ҵ�
	//��ȯ�Ǵ� �ڿ��� ���� �ٸ��� �޼ҵ� �����ε�
	//Connection, PreparedStatement, ResultSet �ڿ� 3�� ��ȯ close() �޼ҵ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
	
		try {
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			
			if(con != null) {
				con.close();
				con = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//��ȯ�Ǵ� �ڿ��� ���� �ٸ��� �޼ҵ� �����ε�
	//Connection, PreparedStatement, ResultSet �ڿ� 3�� ��ȯ close() �޼ҵ�
	public static void close(Connection con, PreparedStatement pstmt) {
		
		try {	
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
				
			if(con != null) {
				con.close();
				con = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
}
