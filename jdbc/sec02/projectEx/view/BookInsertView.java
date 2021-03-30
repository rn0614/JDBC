package jdbc.sec02.projectEx.view;

import java.util.Scanner;

import jdbc.sec02.projectEx.controller.Controller;
import jdbc.sec02.projectEx.model.BookDTO;


public class BookInsertView {
	// Controller Ŭ������ �̱����̹Ƿ� getInstance() ȣ���ؼ� �ν��Ͻ� ����
		Controller controller = Controller.getInstance();
		Scanner sc = new Scanner(System.in);
		
		// ������ �Է�
		public void insert() {
			System.out.println("���� ���� ���");
			
			System.out.print("������ȣ �Է� : ");
			String bookNo = sc.nextLine();
			
			System.out.print("������ �Է� : ");
			String bookName = sc.nextLine();
			
			System.out.print("���� �Է� : ");
			String bookAuthor = sc.nextLine();
			
			System.out.print("�������� �Է� : ");
			int bookPrice = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("������ �Է� : ");
			String bookDate = sc.nextLine();
			
			System.out.print("��� �Է� : ");
			int bookStock = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("���ǻ� ��ȣ �Է� : ");
			String pubNo = sc.nextLine();	
			
			System.out.println("***************************");
			
			//Vector�� ����
			/*Vector v = new Vector<String>();
			v.add(bookNo);
			v.add(bookName);
			v.add(bookAuthor);
			v.add(bookPrice);
			v.add(bookDate);
			v.add(bookStock);*/
			
			//Controller���� �Է� ���� ������ ����
			controller.insert(new BookDTO(bookNo, bookName, bookAuthor,
					bookPrice, bookDate, bookStock, pubNo)); //��Ʈ�ѷ� Ŭ������ insert() ���� �� �������
			sc.close();
			
		}

}








