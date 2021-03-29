package jdbc.sec02;

import java.util.Scanner;

public class BookUpdatePreEx {

	public static void main(String[] args) {
		//DB 연결
		
		
		// 수정할 도서 정보 입력
		//등록할 도서 정보 입력
		Scanner sc = new Scanner(System.in);
		// 도서번호 ~ 출판사 번호 입력해서 변수에 저장
			
		System.out.println("도서 정보 등록");
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
		// sql 문 작성 : update 구문

	}

}
