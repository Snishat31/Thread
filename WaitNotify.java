
package Thread;


class Customer
{
	int amount=10000;
	
	
	synchronized void withdraw(int amount)
	{
		System.out.println("Going to Withdraw." + amount);
		
		if(this.amount<amount)
		{
			System.out.println("Less balance, waiting for deposit.");
			try
			{
				wait();
			}
			catch(Exception e)
			{
				//no body
			}
		}
		this.amount-=amount;
		System.out.println("Withdraw completed. balance amount is "+ this.amount);
	}
	
	synchronized void deposit(int amount)
	{
		System.out.println("Going to Deposit.");
		
		this.amount+=amount;
		
		System.out.println("Deposit Completed with balance "+this.amount);
		notify();
	
	}
}



public class WaitNotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Customer c=new Customer();
		
		new Thread()
		{
			public void run()
			{
				c.withdraw(5000);
				c.withdraw(4000);
				c.withdraw(10000);
				
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				c.deposit(20000);
			}
		}.start();
	}

}
