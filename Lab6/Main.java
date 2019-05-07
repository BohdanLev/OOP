import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		String input;
		ListArray test = null;
		ListArray numOfTests = null;
		int SIZE = 0;
		int timeEnd = 0;
		double threadTime = 0;
		double noThreadTime = 0;
		while(true)
		{
			System.out.print("$ ");
			input = in.nextLine();
			switch(input)
			{
				case"Create":
				{
					test = new ListArray();
					System.out.print("Enter size of input data");
					SIZE = Integer.parseInt(in.nextLine());
					System.out.println("Enter max seconds");
					timeEnd = 1000 * Integer.parseInt(in.nextLine());
					break;
				}
				case"Initialize":
				{
					if(test == null)
					{
						System.out.println("Firstly create container");
						break;
					}
					initialize(test,SIZE);
					break;
				}
				case"Test":
				{
					numOfTests = new ListArray();
					System.out.println("Max-\t find max length\n"
							+ "Min-\t find min length\n"
							+ "Words-\t find number of words which start by one random character\n"
							+ "Exit - enter");
					System.out.println("Choose tests:");
					String chosen;
					while(true)
					{
						chosen = in.nextLine();
						if(chosen.equals(""))
							break;
						else
							numOfTests.add(chosen);
					}
					break;
				}
				case"Start":
				{
					if(numOfTests == null)
					{
						System.out.println("Choose tests before starting");
						break;
					}
					Min min = null;
					MaxTest max = null;
					Words words = null;
					double time = System.currentTimeMillis();
					for(String i : numOfTests)
					{
						if(i.equals("Max"))
						{
							max = new MaxTest(SIZE,test,timeEnd);
						}
						else if (i.equals("Min"))
						{
							min = new Min(SIZE,test,timeEnd);
						}
						else if(i.equals("Words"))
						{
							words = new Words(SIZE,test,timeEnd);
						}
					}				
					if(min != null)
						min.thread.join();
					if(max != null)
						max.thread.join();
					if(words != null)
						words.thread.join();
					threadTime = (System.currentTimeMillis() - time) / 1000;
					break;
				}
				case"Result":
				{
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("| Thread | | NoThread | NoThread:Thread |");
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("| " + threadTime + " |" + " | " + noThreadTime + " | " + noThreadTime / threadTime + " |");
					System.out.println("-----------------------------------------------------------------------------------");
					break;
				}
				case"NoThread":
				{
					noThreadTime = System.currentTimeMillis();
					for(String i: numOfTests)
					{
						if(i.equals("Max"))
						{
							max(test,SIZE);
						}
						else if (i.equals("Min"))
						{
							min(test,SIZE);
						}
						else if(i.equals("Words"))
						{
							words(test,SIZE);
						}
					}
					noThreadTime = (System.currentTimeMillis() - noThreadTime) / 1000;
					break;
				}
				case"Exit":
				{
					return;
				}
			}
		}
	}

	public static void max(ListArray test,int SIZE) 
	{
		int max = 0;
		Thread thread = Thread.currentThread();
		for(int i = 0;i < SIZE;i++)
		{
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(max  < test.at(i).length())
				max = test.at(i).length();
		}
		System.out.println(max);
	}
	
	public static void min(ListArray test,int SIZE) 
	{
		int min = 9999;
		Thread thread = Thread.currentThread();
		for(int i = 0;i < SIZE;i++)
		{
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(min  > test.at(i).length())
				min = test.at(i).length();
		}
		System.out.println(min);
	}
	
	public static void words(ListArray test,int SIZE) 
	{
		int numOfWords = 0;
		Random rand = new Random();
		char letter = (char)(rand.nextInt(26) + 'a');
		Thread thread = Thread.currentThread();
		
		for(int i = 0;i < SIZE;i++)
		{
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(test.at(i).startsWith(Character.toString(letter).toLowerCase()) || test.at(i).startsWith(Character.toString(letter).toUpperCase()))
			{
				numOfWords++;
			}			
		}
		System.out.println("Words starts with " + letter + " - " + numOfWords);
	}

	public static void initialize(ListArray test,int SIZE) 
	{
		for(int i = 0;i < SIZE;i++)
		{
			StringBuilder word = new StringBuilder();
			for(int j = 0;j < 1 + Math.random() * 100;j++)
			{
				word.append((char)(65+Math.random()*25));
			}
			test.add(word.toString());
		}
	}

}
