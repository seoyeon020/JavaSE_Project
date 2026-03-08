package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name; //도서관 이름
	private List<Book> books; //도서 목록
	
	//도서관 이름을 초기화하고 빈 도서 목록을 생성
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	
	public String getName() {
		return name;
	}
	
	//도서 추가 메서드 
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}
	
	//제목으로 도서 검색하는 메서드 
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) return book;
		}
		return null;
	}
	
	//저자로 도서 검색하는 메서드
	public List<Book> findBookByAuthor(String author){
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equals(author)) result.add(book);
		}
		return result;
	}
	
	//isbn으로 도서 검색하는 메서드
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) return book;
		}
		return null;
	}
	
	//isbn으로 도서를 대출하는 메서드
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book != null) {
			return book.checkOut();
		}
		return false;
	}
	
	//isbn으로 도서를  반납하는 메서드
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book != null) {
			book.returnBook();
			return true;
		}
		return false;
	}
	
	//대출 가능한 도서 목록을 반환하는 메서드
	public List<Book> getAvailableBooks() {
		List<Book> available = new ArrayList<Book>();
		for (Book book : books) {
			if (book.isAvailable()) available.add(book);
		}
		return available;
	}
	
	//전체 도서 목록
	public List<Book> getAllBooks() {
		return books;
	}
	
	//도서 수량 관련 정보 반환하는 메서드
	public int getTotalBooks() {
		return books.size();
	}
	
	//대출 가능한 도서 수 
	public int getAvailableBooksCount() {
		return getAvailableBooks().size();
	}
	
	//대출중인 도서 수 
	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}

}
