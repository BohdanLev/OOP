import java.io.File;
import java.util.Scanner;

public class PathMover
{
 StringBuilder path;

 public PathMover()
 {
	  path = new StringBuilder(System.getProperty("user.dir"));
	  path.append("\\");
	  
 }

 private int index()
 {
	 for(int i = path.length()-2;i >= 0;i--)
	 {
		 if(path.charAt(i) == '\\')
			 return i;
	 }
	 return path.length()-1;
 }
 
 private void dir()
 {
  File files = new File(path.toString());
  
  for(File list:  files.listFiles())
  {
   if(list.isFile())
   {
    System.out.println("File: " + list.getName());
   }
   else
    System.out.println("Directory: " + list.getName());
  }
 }

 private void cd()
 {
	 Scanner in = new Scanner(System.in);
	 String input;
	 while(true)
	 {
		 System.out.println("$ " + path + "\t\n");
		 dir();
		 input = in.nextLine();
		 if(input.substring(0,3).equals("cd "))
		 {
			 if(input.substring(3,5).equals(".."))
			 {
				 path = new StringBuilder(path.substring(0, index()+1));
			 }
			 else
			 {
				 System.out.println(input.substring(3,input.length()));
				 path.append(input.substring(3,input.length()));
				 path.append("\\");
			 }
			 
		 }
		 else
		 {
			 path.append(input);
			 break;
		 }
		 System.out.println("$ " + path + "\t\n");
	 }
 }

 public String directory()
 {
	 cd();
	 return path.toString();
 }

}
