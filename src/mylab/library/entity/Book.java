package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	//기본 생성자 정의, 초기 생성 시 도서는 대출 가능 상태
	public Book() {
		this.isAvailable = true;
	}
	
	//모든 필드를 초기화 하는 생성자
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	//도서 대출 처리 메서드, 대출 가능한 경우 false로 변경하고 true를 반환
	public boolean checkOut() {
		if (isAvailable) {
			isAvailable = false;
			return true;
		}
		return false;
	}
	
	//도서 반납 처리 메서드, true로 변경 
	public void returnBook() {
		this.isAvailable = true;
	}
	
	@Override
	//도서 정보 문자열을 반환
	public String toString() {
		String status = isAvailable ? "가능" : "대출 중";
		return "책 제목: " + title + "  저자: " + author + "  ISBN: " + isbn + 
				"  출판년도: " + publishYear + "  대출 가능 여부: " + status;
	}
	


}
