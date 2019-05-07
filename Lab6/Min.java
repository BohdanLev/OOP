
public class Min implements Runnable
{
	int SIZE;
	ListArray container;
	int min = 9999;
	double time = 0;
	int timeEnd = 0;
	public Thread thread;
	public Min(int SIZE,ListArray container,int timeEnd)
	{
		this.SIZE = SIZE;
		this.container = container;
		this.timeEnd = timeEnd;
		thread  = new Thread(this,"Min");
		thread.start();
	}
		
	@Override
	public void run() {
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
			
			if(min > container.at(i).length())
			{
				min = container.at(i).length();
			}
			
		}
		System.out.println("MIN - " + min);
		time = System.currentTimeMillis() - time;
	}
	
}