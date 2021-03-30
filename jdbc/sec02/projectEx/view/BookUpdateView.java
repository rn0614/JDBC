package jdbc.sec02.projectEx.view;

import java.util.Scanner;

import jdbc.sec02.projectEx.controller.Controller;
import jdbc.sec02.projectEx.model.BookDTO;

public class BookUpdateView {
	Controller controller = Controller.getInstance();
	
	public void update() {
	
	Scanner sc= new Scanner(System.in);
	
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
	
	controller.update(new BookDTO(bookNo, bookName, bookAuthor,
			bookPrice, bookDate, bookStock, pubNo));
	
	sc.close();
	}
}
