import java.util.Scanner;
public class FirstLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean debug = false;
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
			else if(args[i].equals("-d") || args[i].equals("debug"))
			{
				debug = true;
				System.out.println("Програма запущена в режимі debug.\n");
			}
		}
			int wrongCommand = 0;
			String command = null;
			String inputString = null;
			char keySymbol = ' ';
			String keyString = null;
			Scanner in = new Scanner(System.in);
			System.out.print("Введіть команду:\r");
			command = in.nextLine();
			StringBuilder result = null;
			for(;;System.out.print("Введіть команду:\r"),command = in.nextLine())
			{
				if(command.length()-1 >= 1)
				switch(command.charAt(1))
				{
					case'w': 
					{
						wrongCommand = 0;
						System.out.println("Введіть текст:\n");
						inputString = in.nextLine();
						System.out.println("Введіть ключовий символ: \n");
						keySymbol = in.nextLine().charAt(0);
						System.out.println("Введіть ключовий рядок: \n");
						keyString = in.nextLine();
						result = null;
						EditString.result = null;
						break;
					}
					case'i':
					{
						wrongCommand = 0;
						System.out.print("Введені дані: \n"
								+ "Текст: " + inputString + "\n"
								+ "Ключовий симовл: " + keySymbol + "\n"
								+ "Ключовий рядок: " + keyString + "\n");
						if(result != null)
							System.out.print("Результат: " + result + "\n");
						break;
					}
					case's':
					{
						wrongCommand = 0;
						result = EditString.start(inputString, keySymbol, keyString,debug);
						break;
					}
					case'r':
					{
						wrongCommand = 0;
						if(result != null)
						System.out.println("Результат: " + result);
						break;
					}
					case'e':
					{
						System.out.println("Завершення роботи програми..");
						return;
					}
					default:
					{
						System.out.println("Команду введено невірно.\n");
						wrongCommand++;
						if(wrongCommand == 3)
						{
							System.out.println("Запустіть програму з параметром -h для отримання допомоги.");
							return;
						}						
					}
				}
			}		
	}
}

