package jdbc.sec02;

import java.util.Scanner;

public class BookUpdatePreEx {

	public static void main(String[] args) {
		//DB ����
		
		
		// ������ ���� ���� �Է�
		//����� ���� ���� �Է�
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
		// sql �� �ۼ� : update ����

	}

}
