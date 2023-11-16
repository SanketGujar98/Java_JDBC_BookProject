package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import books.Book;

public class Crud {
	
	public static boolean delete(int id)
	{
		boolean delete_book=false;
		Connection connection=DatabaseConnection.connecttoDb();
		String query="select * from book where id=?;";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result=ps.executeQuery();
			if(result.next())
			{
				System.out.println("ID Exists");
				String deletequery="delete from book where id=?;";
				PreparedStatement ps2=connection.prepareStatement(deletequery);
				ps2.setInt(1, id);
				ps2.executeUpdate();
				delete_book=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delete_book;
	}
	
	public static boolean update(int id)
	{
		boolean book_update=false;
		Connection connection=DatabaseConnection.connecttoDb();
		String query="select * from book where id=?;";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result=ps.executeQuery();
			if(result.next())
			{
				System.out.println("ID Exists.");
				System.out.println("Data Associated.");
				System.out.println("ID :- "+result.getInt(1));
				System.out.println("Book Name :- "+result.getString(2));
				System.out.println("Book Price :- "+result.getFloat(3));
				System.out.println("Author Name :- "+result.getString(4));
				
				Scanner sc=new Scanner(System.in); 
				System.out.println("-----Enter New Data-----");
				System.out.println("Enter New Book Name :- ");
				String bookname=sc.next();
				System.out.println("Enter Book Price :- ");
				float price=sc.nextFloat();
				System.out.println("Enter Author Name :- ");
				String author=sc.next();
				
				String updatequery="update book set bookname=?,price=?,author=? where id=?;";
	            PreparedStatement ps2=connection.prepareStatement(updatequery);	
	            ps2.setString(1,bookname);
	            ps2.setFloat(2, price);
	            ps2.setString(3, author);
	            ps2.setInt(4, id);
	            ps2.executeUpdate();
	            book_update=true;
			}
		} catch (SQLException e) {e.printStackTrace();}
		return book_update;
	}
	
	public static boolean add(Book book)
	{
	    boolean book_inserted=false;
	    Connection connection=DatabaseConnection.connecttoDb();
	    String query="insert into book(bookname,price,author) values (?,?,?);";
	    try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1,book.getBookname());
			ps.setFloat(2, book.getPrice());
			ps.setString(3, book.getAuthor());
			ps.executeUpdate();
			book_inserted=true;
		} 
	    catch (SQLException e) {e.printStackTrace();}
	    return book_inserted;
	}
	
	
	public static void show()
	{
		Connection connection=DatabaseConnection.connecttoDb();
		String query="select * from book;";
        try {
			Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(query);
            while(result.next())
            {
            	int id=result.getInt(1);
            	String bookname=result.getString(2);
                float price=result.getFloat(3);
            	String author=result.getString(4);
            	System.out.println("ID :- "+id);
            	System.out.println("Book Name :- "+bookname);
            	System.out.println("Book Price :- "+price);
            	System.out.println("Author :- "+author);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
