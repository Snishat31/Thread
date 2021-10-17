package Thread;

class Math{
	int fresult=1; 
	int aresult=0;
	
	void fact(int n){
		System.out.println("Welcome to factorial block ");
		
		synchronized(this)
		{
			for(int i=n;i>0;i--)
			{
				fresult=fresult*i;
				try
				{
					Thread.sleep(2000);
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				
			}
			System.out.println("Factorial of "+n+" is "+fresult);
			fresult=1;
		}
	}
	
	void add (int a, int b)
	{
		System.out.println("Welcome to addition block ");
		
		synchronized(this)
		{
			aresult=a+b;
			try
			{
				Thread.sleep(2000);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			System.out.println("Sum of " +a+", "+b+" are "+aresult);
		}
	}
}

class MyThread1 extends Thread//factorial
{
	Math m;
	MyThread1(Math m)
	{
		this.m=m;
	}
	public void run()
	{
		System.out.println("In my Thread1 run method");
		m.fact(4);
	}
}

class MyThread2 extends Thread//addition
{
	Math m;
	MyThread2(Math m)
	{
		this.m=m;
	}
	public void run()
	{
		System.out.println("In my Thread2 run method");
		m.add(4, 5);
	}
}


class MyThread3 extends Thread//factorial
{
	Math m;
	MyThread3(Math m)
	{
		this.m=m;
	}
	public void run()
	{
		System.out.println("In my Thread3 run method");
		m.fact(6);
	}
}



class MyThread4 extends Thread//addition
{
	Math m;
	MyThread4(Math m)
	{
		this.m=m;
	}
	public void run()
	{
		System.out.println("In my Thread4 run method");
		m.add(10,20);
	}
	
}



public class SynchronizedExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Math obj = new Math();
		
		MyThread1 t1=new MyThread1(obj);
		MyThread3 t2=new MyThread3(obj);
		MyThread2 t3=new MyThread2(obj);
		MyThread4 t4=new MyThread4(obj);
		
		t2.start();
		t4.start();
		t1.start();
		t3.start();
	}

}
