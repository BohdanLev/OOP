import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception 
	{
		for(int i = 0;i < args.length;i++)
		{
			if(args[i].equals("-h") || args[i].equals("-help"))
			{
				System.out.println(""
						+ "Виконав: Левицький Богдан, КН-108\n\n"
						+ "Мета: \n"
						+ "Ввести текст.\n"
						+ "Після кожного слова тексту, що закінчується заданим символом, вставити зазначений рядок.\n"
						+ "Вивести початковий текст та результат.\n\n"
						+ "Команди меню:\n"
						+ "Ввести текст: -w\n"
						+ "Перегляд введених даних: -i\n"
						+ "Виконання обчислень: -s\n"
						+ "Вивести результат: -r\n"
						+ "Вийти: -e"
						+ "\n");
			}
		}
			
			ListArray test = null;
			String command = null;
			Scanner in = new Scanner(System.in);
			System.out.print("Введіть команду:\r");
			command = in.nextLine();
			for(;;System.out.print("Введіть команду:\r"),command = in.nextLine())
			{
				if(command.length()-1 >= 1)
				switch(command.charAt(1))
				{
					case'1': 
					{
						test = new ListArray();
						System.out.println("Container have been created");
						break;
					}
					case'2':
					{
						System.out.println("How many elements would you like to add?");
						int num = in.nextInt();
						for(int i = 0;i < num;i++)
						{
							String input = in.nextLine();
							test.add(input);
						}
						break;
					}
					case'3':
					{
						test.clear();
						System.out.println("Container is clear");
						break;
					}
					case'4':
					{
						System.out.println("Container:  " + test.toString());
						break;
					}
					case'5':
					{
						
						break;
					}
					case'6':
					{
						byte choice = in.nextByte();
						for(;;System.out.print("Введіть команду:\r"),choice= in.nextByte())
						{
							switch(choice)
							{
								case 1: 
								{
									System.out.println("Enter element to add");
									test.add(in.next());
									break;
								}
								case 2:
								{
									System.out.println("Enter element to remove");
									test.remove(in.next());
									break;
								}
								case 3:
								{
									test.clear();
									System.out.println("Container is clear");
									break;
								}
								case 4:
								{
									System.out.println("Size: " + test.size());
									break;
								}
								case 5:
								{
									System.out.println("Capacity: " + test.capacity());
									break;
								}
								case 6:
								{
									System.out.println(test.contains(in.next()));
									break;
								}
								case 7:
								{
									break;
								}
								case 8:
								{
									System.out.print("Write path:  ");
									test.serialize(in.nextLine());
									break;
								}
								case 9:
								{
									System.out.println("Write Path:  ");
									test.deserialize(in.nextLine());
									break;
								}
								case 10:
								{
									System.out.println("Enter index");
									System.out.println(test.at(in.nextInt()));
									break;
								}
								case 11:
								{
									System.out.println("Enter string");
									System.out.println(test.indexOf(in.next()));
									break;
								}
								case 12:
								{
									for(String i:test)
									{
										System.out.println(i);
									}
									break;
								}
								case 13:
								{
									Iterator<String> it = test.iterator();
									while(it.hasNext())
									{
										System.out.println(it.next());
									}
									break;
								}
								case 14:
								{
									break;
								}
								default:
								{
									System.out.println("Wrong command");
									break;
								}
								
							}
						}
					}
					default:
					{
						System.out.println("Команду введено невірно.\n");					
					}
				}
			}		
	}
}