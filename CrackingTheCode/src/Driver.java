import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Driver {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> content = new ArrayList<String>();
	private static LinkedList<ArrayList<String>> questions = new LinkedList<ArrayList<String>>();
	
	public static void main(String[] args) {
		
		boolean isRunning = true;
		int response = -1;

		try
		{
			while (isRunning)
			{
				displayOptions();
				
				if (input.hasNextInt())
				{
					response = input.nextInt();
					switch (response)
					{
					case 1: //Generate Menu 
						System.out.println("You entered " + response + "!");
						generateMenu();
						break;
					case 2: //Enter Menu
						System.out.println("You entered " + response + "!");
						printMenu();
						break;
					case 3: //Quit
						isRunning = false;
						System.out.println("GoodBye!");
						break;
					default: //Error
						System.out.println("You entered " + response + ", which is an incorrect entry!");
						break;
					}
					System.out.println();
				}
					
				else
				{
					input.nextLine();
					System.out.println("Incorrect entry!");
				}
				
				
			}
		}
		catch (Exception ex)
		{
			
		}
		finally
		{
			input.close();
		}
	}
	
	public static void displayOptions()
	{
		System.out.println("Please select an option:");
		System.out.println("[1] Generate Menu");
		System.out.println("[2] Enter Menu");
		System.out.println("[3] Exit");
	}

	public static void generateMenu()
	{
		String fileName = "";
		String tempLine = "";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		int currentArrayIndex = -1;
		
		try 
		{
			input.nextLine();
			System.out.print("Enter the file name: ");
			fileName = input.nextLine();
			
			if (!(new File(fileName)).exists())
			{
				System.out.println("File Doesn't Exist!");
				System.out.println("Generating new file " + fileName);		
				File missingFile = new File(fileName);
				missingFile.createNewFile();
			}
			else
				System.out.println("File Found! Loading...");
			
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			
			while ((tempLine = bufferedReader.readLine()) != null)
			{
				content.add(tempLine);
			}
			
			for (int i = 0; i < content.size(); i++)
			{
				if (Character.isDigit(content.get(i).charAt(0)))			
					currentArrayIndex++;

				questions.get(currentArrayIndex).add(content.get(i));
			}
			
		}
		catch (Exception ex)
		{
			
		}
		finally
		{
			
		}
	}
	
	public static void printMenu()
	{
		System.out.println("");
	}
}
