package jdbc.sec02.projectEx.view;

import java.util.Scanner;

public class MainView {

	public static void main(String[] args) {
		// �޴� ���
				// ���õ� �޴��� ���� �ش� Ŭ������ �޼ҵ� ȣ��
				Scanner sc = new Scanner(System.in);
				int menuNum;
				
				System.out.println("***************************");
				System.out.println("\t���� ���� ���α׷�");
				System.out.println("***************************");
				
				System.out.println("\t���� �޴����� ����");
				System.out.println("***************************");
				System.out.println("1. ���� ���");
				System.out.println("2. ���� ���� ��ȸ");
				System.out.println("3. ���� ���� ����");
				System.out.println("4. ���� ���� ����");
				System.out.println("5. ����");
				System.out.println("***************************");
				
				System.out.print("�޴� ��ȣ �Է� : ");
				menuNum = sc.nextInt();
				
				switch(menuNum) {
					case 1:	
						BookInsertView bis = new BookInsertView();
						bis.insert();
						break;
					case 2:	
						BookListView bls = new BookListView();
						bls.getAllBook();
						break;
					case 3:	
						BookUpdateView buv = new BookUpdateView();
						buv.update();
						break;
					case 4:		
						BookDeleteView bdv = new BookDeleteView();
						bdv.delete();
						break;	
					case 5:
						break;	
					default:
						System.out.print("�߸� �Է��Ͽ����ϴ�.");
						
				}
				
				System.out.println("---------------------------------------");
				System.out.println("���� �մϴ�");				
				
				sc.close();
	}

}
