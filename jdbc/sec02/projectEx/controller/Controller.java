package jdbc.sec02.projectEx.controller;

import java.util.Vector;

import jdbc.sec02.projectEx.model.BookDAO;
import jdbc.sec02.projectEx.model.BookDTO;
import jdbc.sec02.projectEx.view.BookListView;
import jdbc.sec02.projectEx.view.ResultView;

public class Controller {
	// �̱��� (Singleton) Ŭ���� : �� �ϳ��� ��ü�� ����
	private static Controller instance = new Controller();

	// new �����ڷ� ������ ȣ���� �� ������ ����
	private Controller() {
	}

	// �ܺο��� ȣ���ؼ� ��ü ������ �� �ֵ���
	// �ڽ��� ��ü (instance) ��ȯ
	public static Controller getInstance() {
		return instance;
	}
	
	BookDAO dao = new BookDAO();
	
	// BookInsertView�κ��� ���� �����͸� BookDTO�� ����
	// -> BookDAO���� ������ ����
	public void insert(BookDTO newDto) {
		
		try {
			
			/*BookDTO dto = new BookDTO();
			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());*/
			
			// BookDAO���� �����ϰ� ����� �޾Ƽ�
			// ����� ���� ����ڿ��� �޽��� ����
			if(dao.insert(newDto)) { // DAO insert()���� ȣ���ϰ� ����� true���
				ResultView.succMsg("���� ������ ��ϵǾ����ϴ�");			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResultView.errorMsg("���� ���� ��� ����");
		} 
	}
	
	//BookListView���� ȣ��
	public void getAllBook() {
		try {
			//BookDAO���� ��û�ؼ� ����� ����
			Vector<BookDTO> dataSet = dao.getAllBook();
			
			if(dataSet.size() != 0) {
				BookListView.showAllBook(dataSet);
			} else {
				ResultView.succMsg("�˻� ��� �����ϴ�");
			}		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResultView.errorMsg("�˻��� ������ �ֽ��ϴ�.");
		}
		
		// ����� BookListView���� ����
	}
	
	public void update(BookDTO newDto) {	
		
		try {
			// BookDAO���� �����ϰ� ��� �޾Ƽ� �޽� ���
			if(dao.update(newDto)) {
				ResultView.succMsg("���� ������ �����Ͽ����ϴ�. ���� ���� ��ȸ���� Ȯ���ϼ���");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResultView.errorMsg("���� ���� ���� ����");
		}
	}
	
	public void delete(String bookNo) {
		// BookDAO���� ���޹��� bookNo ���ڿ��� �״�� �Ѱܵ� �ǰ�
		// dto.setBookNo(bookNo) �ؼ� dto �Ѱܵ� ��
		
		try {
			BookDTO dto = new BookDTO();
			dto.setBookNo(bookNo);
			
			if(dao.delete(dto)) {
				ResultView.succMsg(bookNo + " ������ �����Ͽ����ϴ�. ���� ���� ��ȸ���� Ȯ���ϼ���.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResultView.errorMsg("���� ���� ���� ����");
		}
	}
	
	
}

















