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
						+ "�������: ��������� ������, ��-108\n\n"
						+ "����: \n"
						+ "������ �����.\n"
						+ "ϳ��� ������� ����� ������, �� ���������� ������� ��������, �������� ���������� �����.\n"
						+ "������� ���������� ����� �� ���������.\n\n"
						+ "������� ����:\n"
						+ "������ �����: -w\n"
						+ "�������� �������� �����: -i\n"
						+ "��������� ���������: -s\n"
						+ "������� ���������: -r\n"
						+ "�����: -e"
						+ "\n");
			}
			else if(args[i].equals("-d") || args[i].equals("debug"))
			{
				debug = true;
				System.out.println("�������� �������� � ����� debug.\n");
			}
		}
			int wrongCommand = 0;
			String command = null;
			String inputString = null;
			char keySymbol = ' ';
			String keyString = null;
			Scanner in = new Scanner(System.in);
			System.out.print("������ �������:\r");
			command = in.nextLine();
			StringBuilder result = null;
			for(;;System.out.print("������ �������:\r"),command = in.nextLine())
			{
				if(command.length()-1 >= 1)
				switch(command.charAt(1))
				{
					case'w': 
					{
						wrongCommand = 0;
						System.out.println("������ �����:\n");
						inputString = in.nextLine();
						System.out.println("������ �������� ������: \n");
						keySymbol = in.nextLine().charAt(0);
						System.out.println("������ �������� �����: \n");
						keyString = in.nextLine();
						result = null;
						EditString.result = null;
						break;
					}
					case'i':
					{
						wrongCommand = 0;
						System.out.print("������ ���: \n"
								+ "�����: " + inputString + "\n"
								+ "�������� ������: " + keySymbol + "\n"
								+ "�������� �����: " + keyString + "\n");
						if(result != null)
							System.out.print("���������: " + result + "\n");
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
						System.out.println("���������: " + result);
						break;
					}
					case'e':
					{
						System.out.println("���������� ������ ��������..");
						return;
					}
					default:
					{
						System.out.println("������� ������� ������.\n");
						wrongCommand++;
						if(wrongCommand == 3)
						{
							System.out.println("�������� �������� � ���������� -h ��� ��������� ��������.");
							return;
						}						
					}
				}
			}		
	}
}

