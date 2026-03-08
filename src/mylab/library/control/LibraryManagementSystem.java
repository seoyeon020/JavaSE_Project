package mylab.library.control;

import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		//도서관 객체 생성 
		Library library = new Library("중앙 도서관");
		
		//샘플 도서 추가 
		addSampleBooks(library);
		
		//도서관 정보 출력
		System.out.println("===== " + library.getName() + " =====");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
		
		testFindBook(library);
		testCheckOut(library);
		
		System.out.println("\n도서관 현재 상태:");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
		
		testReturn(library);
		
		System.out.println("\n도서관 현재 상태:");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
		
		displayAvailableBooks(library);
		
	}
	
	//샘플 도서 목록을 도서관에 추가하는 메서드
	public static void addSampleBooks(Library library) {
		library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}
	
	
	//제목과 저자로 도서를 검색하는 기능을 테스트하는 메서드
	public static void testFindBook(Library library) {
		System.out.println("\n===== 도서 검색 테스트 =====");
		System.out.println("제목으로 검색 결과:");
		System.out.println(library.findBookByTitle("자바의 정석"));
		
		System.out.println("\n저자로 검색 결과:");
		List<Book> byAuthor = library.findBookByAuthor("Robert C. Martin");
		for (Book b : byAuthor) System.out.println(b);
	}
	
	//도서 대출 기능을 테스트하는 메서드
	public static void testCheckOut(Library library) {
		System.out.println("\n===== 도서 대출 테스트 =====");
		String isbn = "978-89-01-14077-4";
		if (library.checkOutBook(isbn)) {
			System.out.println("도서 대출 성공!");
			System.out.println("대출된 도서 정보:\n" + library.findBookByISBN(isbn));
		}
	}
	
	//도서 반납 기능을 테스트하는 메서드 
	public static void testReturn(Library library) {
		System.out.println("\n===== 도서 반납 테스트 =====");
		String isbn = "978-89-01-14077-4";
		if (library.returnBook(isbn)) {
			System.out.println("도서 반납 성공!");
			System.out.println("반납된 도서 정보:\n" + library.findBookByISBN(isbn));
		}
		
	}
	
	//대출 가능한 도서 목록을 출력하는 메서드 
	public static void displayAvailableBooks(Library library) {
		System.out.println("\n===== 대출 가능한 도서 목록 =====");
		for (Book b : library.getAvailableBooks()) {
			System.out.println(b);
			System.out.println("----------------------");
		}
	}

}
