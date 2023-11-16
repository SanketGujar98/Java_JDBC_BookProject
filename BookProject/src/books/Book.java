package books;

public class Book {

	
	String bookname;
	float price;
	String author;
	public Book(String bookname, float price, String author) {
		
		this.bookname = bookname;
		this.price = price;
		this.author = author;
	}
	public String getBookname() {
		return bookname;
	}
	public float getPrice() {
		return price;
	}
	public String getAuthor() {
		return author;
	}
	
	
	
	
}
