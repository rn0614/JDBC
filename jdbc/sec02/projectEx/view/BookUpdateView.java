package jdbc.sec02.projectEx.view;

import java.util.Scanner;

import jdbc.sec02.projectEx.controller.Controller;
import jdbc.sec02.projectEx.model.BookDTO;

public class BookUpdateView {
	Controller controller = Controller.getInstance();
	
	public void update() {
	
	Scanner sc= new Scanner(System.in);
	
	System.out.print("도서번호 입력 : ");
	String bookNo=sc.nextLine();

	System.out.print("도서명 입력 : ");
	String bookName=sc.nextLine();

	System.out.print("저자 입력 : ");
	String bookAuthor=sc.nextLine();
				
	System.out.print("도서가격 입력 : ");
	int bookPrice=sc.nextInt();
					
	sc.nextLine();
					
	System.out.print("발행일 입력 : ");
	String bookDate=sc.nextLine();
					
	System.out.print("재고 입력 : ");
	int bookStock=sc.nextInt();
					
	sc.nextLine();
	
	System.out.print("출판사 번호 입력 : ");
	String pubNo=sc.nextLine();
	
	controller.update(new BookDTO(bookNo, bookName, bookAuthor,
			bookPrice, bookDate, bookStock, pubNo));
	
	sc.close();
	}
}
