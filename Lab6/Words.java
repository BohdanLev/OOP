import java.util.Random;

public class Words implements Runnable
{
	int SIZE;
	ListArray container;
	int timeEnd;
	double time;
	int numOfWords = 0;
	Random rand = new Random();
	char letter = (char)(rand.nextInt(26) + 'a');
	Thread thread;
	public Words(int SIZE,ListArray container,int timeEnd)
	{
		this.SIZE = SIZE;
		this.container = container;
		this.timeEnd = timeEnd;
		thread = new Thread(this,"Words");
		thread.start();
	}
	
	@Override
	public void run() 
	{
		time = System.currentTimeMillis();
		for(int i = 0;i < SIZE;i++)
		{
			if(System.currentTimeMillis() - time > timeEnd)
				thread.interrupt();
			try 
			{
				thread.sleep(500);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			if(container.at(i).startsWith(Character.toString(letter)))
			{
				numOfWords++;
			}			
		}
		System.out.println("Number of words starts with " + letter + " " + numOfWords);
		time = System.currentTimeMillis() - time;
	}
}
