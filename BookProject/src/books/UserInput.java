package books;

import java.util.Scanner;

import database.Crud;

public class UserInput {

	public static void main(String[] args) {
		System.out.println("------WELCOME------");
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1. Show All Books");
			System.out.println("2. Add Books");
			System.out.println("3. Update Book");
			System.out.println("4. Delete Book");
			System.out.println("5. Exit From Project");
			System.out.println("Enter Your Choice ");
			
			int choice=sc.nextInt();
			
			if(choice==1)
			{
				System.out.println("----Show All Books----");
				Crud.show();
			}
			else if(choice==2)
			{
				System.out.println("----Add Books----");
				System.out.println("Enter Book Name :- ");
				String bookname=sc.next();
				System.out.println("Enter Book Price :- ");
				float price=sc.nextFloat();
				System.out.println("Enter Auhtor Name :- ");
				String author=sc.next();
				Book book=new Book(bookname, price, author);
				boolean inserted_book=Crud.add(book);
				if(inserted_book) {
					System.out.println("Book Added Sucessfully.");
				}
				else
				{
					System.out.println("Book Not Added.");
				}
			}
			else if(choice==3)
			{
				System.out.println("----Update Books----");
				System.out.println("Enter Id You Want To Update :- ");
				int id=sc.nextInt();
				boolean updated_book=Crud.update(id);
				if(updated_book)
				{
					System.out.println("Book Updated Sucessfully");
				}
				else
				{
					System.out.println("Book Not Uploaded");
				}
			    
				
			}
			else if(choice==4)
			{
				System.out.println("----Delete Books----");
				System.out.println("Enter Id You Want To Delete :- ");
				int id=sc.nextInt();
				boolean deleted_book=Crud.delete(id);
				if(deleted_book)
				{
					System.out.println("Book Deleted Sucessfully.");
				}
				else
				{
					System.out.println("Book Not Deleted.");
				}
			}
			else if(choice==5)
			{
				break;
			}
			else
			{
				System.out.println("Please Enter Proper Choice...");
			}
			
			
			
		}
	}

}
