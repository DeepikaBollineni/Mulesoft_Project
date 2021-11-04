package Musoft.main;
import Musoft.data.*;
import java.util.*;
import java.sql.*;
public class Main {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int choice;
		Check chk = new Check();
		CreateData cd = new CreateData();
		Operation op = new Operation();
		boolean loop=true;
		Connection k = null;
		while(loop)
		{
			System.out.println("1.Check Connection");
			System.out.println("2.Create New DataBase");
			System.out.println("3.Create New table");
			System.out.println("4.Upload Data");
			System.out.println("5.Get all data from table");
			System.out.println("6.Get movies data using actors name");
			System.out.println("7.Exit");
			System.out.println("");
			System.out.println("Enter the choice : ");
			choice = scan.nextInt();
			switch(choice){  
			//Case statements  
			case 1: String s;
					scan.nextLine();
					System.out.println("Enter the database name: ");
					String db;
					db=scan.nextLine();
					s="jdbc:sqlite:D://sqlite/"+db;
					k=chk.test(s);
					break;
					
			case 2:	scan.nextLine();
					System.out.println("Enter the database name: ");
					String Database;
					Database=scan.nextLine();
					k=cd.createDatabase(Database);
					break;
					
			case 3: cd.createTable(k);
					break;
					
			case 4: String movie, actor, actress, year, director;
					scan.nextLine();
					System.out.println("Enter the moive: ");
		    		movie=scan.nextLine();
		    		System.out.println("Enter the actor: ");
		    		actor=scan.nextLine();
		    		System.out.println("Enter the actress: ");
		    		actress=scan.nextLine();
		    		System.out.println("Enter the year: ");
		    		year=scan.nextLine();
		    		System.out.println("Enter the director: ");
		    		director=scan.nextLine();
		    		op.Upload(k, movie, actor, actress, year, director);
					break;
					
			case 5: op.getAll(k);
					break;  
			case 6: System.out.println("Enter actors name: ");
					scan.nextLine();
					String name;
					name=scan.nextLine();
					op.getMovie(k, name);
					break;  
			case 7: loop=false;
					System.out.println("Closing......");
					break;  
			//Default case statement  
			default:System.out.println("Enter a valid number from 1 to 7");  
			}
		}
	}
}
