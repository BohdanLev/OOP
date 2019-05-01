public class EditString
{
	static StringBuilder result = null;
	static boolean pasted = false;
	static StringBuilder start(String inputString,char keySymbol,String keyString,boolean debug)
	{
		result = new StringBuilder();
		for(int i = 0;i < inputString.length();i++)
		{
			result.append(inputString.charAt(i));
			if(debug && (inputString.charAt(i) == ' ' || i == inputString.length()-1))
				System.out.println(result);
			if((i+1 < inputString.length() && inputString.charAt(i+1) == ' ') || i == inputString.length()-1)
			{
				if(inputString.charAt(i) == keySymbol)
				{
					result.append(keyString);
					pasted = true;
				}
			}
		}
		if(!pasted)
		{
			System.out.println("Ключового символу в стрічці немає");
			result = null;
			return null;
		}
		return result;
	}
}
