package preparation;

public class TestThread extends Thread {

	private static int threadCount=0;
	private int countDown=5;
	
	public TestThread(){
		super("#"+ ++threadCount);
		start();
		System.out.println(currentThread().getName());
	}
	
	public void run(){
		while(true){
			System.out.println(getName()+": " +countDown);
			if(--countDown==0)
				return;
			yield();
		}
		
	}
	
	public static void main(String[] args){
		for(int i=0; i<5; i++){
			new TestThread();
		}
	}
}
