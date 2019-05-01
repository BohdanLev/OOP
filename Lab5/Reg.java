import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Reg implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static boolean isNameSurname(String nameSurname)
	{
		String regex = "[A-Z][a-z]+";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(nameSurname);
  
		return matcher.matches();
   }

	public static boolean isAge(int age)
	{
		String regex = "[1-9][0-9]?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(Integer.toString(age));
		return matcher.matches();
	}
 
 public static boolean isHour(int hour)
 {
	  String regex = "^[0-9]|1[0-9]|2[0-3]$";
	  Pattern pattern = Pattern.compile(regex); 
	  Matcher matcher = pattern.matcher(Integer.toString(hour));
	  return matcher.matches();
 }
 
 public static boolean isMinSec(int minsec)
 {
	  String regex = "[0-9]|[1-5][0-9]";
	  Pattern pattern = Pattern.compile(regex); 
	  Matcher matcher = pattern.matcher(Integer.toString(minsec));
	  
	 return matcher.matches();
 }
 
 public static boolean isDay(int day)
 {
	  String regex =  "[1-9]|[1-2][0-9]|3[0-1]";
	  Pattern pattern = Pattern.compile(regex); 
	  Matcher matcher = pattern.matcher(Integer.toString(day));

	  return matcher.matches();
 }
 public static boolean isYear(int year)
 {
	  String regex =  "[0-9][0-9][0-9][0-9]";
	  Pattern pattern = Pattern.compile(regex); 
	  Matcher matcher = pattern.matcher(Integer.toString(year));

	  return matcher.matches();
 }
 public static boolean isMonth(int month)
 {
	 String regex = "[1-9]|1[0-2]";
	 Pattern pattern = Pattern.compile(regex);
	 Matcher matcher = pattern.matcher(Integer.toString(month));
	 
	 return matcher.matches();
 }
    
 public static boolean isPlace(String place)
 {
	  String regex = "[A-Z][a-z]+";
	  Pattern pattern = Pattern.compile(regex);
	  Matcher matcher = pattern.matcher(place);
	  
	  return matcher.matches();
}
}
