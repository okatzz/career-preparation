import java.util.Stack;


public class MyQueue <T>{
	
	Stack<T> s1;
	Stack<T> s2;
	
	public void enqueue(T obj){
		if(s1.empty()){
			while(!s2.empty()){
				s1.push(s2.pop());
			}
		}
		s1.push(obj);
	}
	
	public T dequeue(){
		if(!s1.empty()){
			while(!s1.empty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
