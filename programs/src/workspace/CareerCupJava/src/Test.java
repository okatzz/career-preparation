import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
	
	private Lock lock = new ReentrantLock();
	
	public int testReturn(){
		lock.lock();
			try {
				return 0;
			}finally{
				lock.unlock();
			}
		
	}
	
	private void throwException() throws BaseException {
		throw new BaseException();
	}

	/**
	 * @param args
	 * @throws BaseException 
	 */
	public static void main(String[] args) throws Exception {
		
		List arrayList = new ArrayList<Integer>();
		System.out.println(arrayList.getClass());
		
		arrayList = new LinkedList<Integer>();
		System.err.println(arrayList instanceof LinkedList);
		
		try{
			Exception e = new BaseException();
			throw e;
		}catch(InheritedException ie){
			System.out.println(ie.getClass());
		}finally{
		
		System.out.println("===============");
		}
	}

}

class BaseException extends Exception {
	
}

class InheritedException extends BaseException{
	
}
