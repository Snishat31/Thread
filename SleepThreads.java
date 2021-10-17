package Thread;

public class SleepThreads extends Thread{
	
	public void run(){
		for(int i=1;i<5;i++){
			try{                       //this exception handling is to avoid clashing of many threads at ones
				Thread.sleep(3000); //3000=3sec
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		System.out.println(Thread.currentThread().getName()+"  :"+i);	
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SleepThreads t1=new SleepThreads();
		t1.setName("Java");
		t1.setPriority(MAX_PRIORITY);
		
		SleepThreads t2=new SleepThreads();
		t2.setName("c#");
		
		SleepThreads t3=new SleepThreads();
		t3.setName("C++");
		t3.setPriority(MIN_PRIORITY);
		
		SleepThreads t4=new SleepThreads();
		t4.setName("Python");
		t4.setPriority(NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println(t1.getStackTrace());
		System.out.println(t2.getStackTrace());
		System.out.println(t3.getStackTrace());
		System.out.println(t4.getStackTrace());
		
	}

}
