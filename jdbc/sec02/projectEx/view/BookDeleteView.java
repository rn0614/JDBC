package jdbc.sec02.projectEx.view;

import java.util.Scanner;

import jdbc.sec02.projectEx.controller.Controller;

public class BookDeleteView {
	Controller controller = Controller.getInstance();
	Scanner sc = new Scanner(System.in);
	
	public void delete() {
		
		System.out.print("���� ���� ���� ");
		
		// ��ü ���� ���
		BookListView bls = new BookListView();
		bls.getAllBook();
		
		
		System.out.print("������ ������ ������ȣ �Է� : ");
		String bookNo = sc.nextLine();
		
		
		controller.delete(bookNo);
	}
}
