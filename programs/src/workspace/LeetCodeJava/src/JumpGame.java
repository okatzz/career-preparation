import java.util.Arrays;;

//http://www.mitbbs.com/article_t/JobHunting/32073485.html, http://www.mitbbs.com/article_t/JobHunting/32111181.html, http://www.mitbbs.com/article_t/JobHunting/32076261.html

public class JumpGame {

	public boolean canJump1(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] canJ=new int[A.length];
		Arrays.fill(canJ, -1);
		return canJump(0, A, canJ);
	}

	private boolean canJump(int idx, int[] A, int[] canJ){
		if(canJ[idx]==0)
			return false;
		if(canJ[idx]==1)
			return true;

		if(idx>=A.length-1)
			return true;
		for(int i=1; i<=A[idx]; i++){
			if(canJump(idx+i, A, canJ)){
				canJ[idx]=1;
				return true;
			}
		}
		canJ[idx]=0;
		return false;
	}

	public boolean canJump2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		boolean[] reachable=new boolean[A.length];
		Arrays.fill(reachable, false);
		reachable[0]=true;
		for(int i=0; i<A.length-1; i++){
			if(reachable[i]){
				for(int j=1; j<=A[i]; j++){
					if(i+j>=A.length-1)
						return true;
					reachable[i+j]=true;
				}
			}
		}
		return reachable[A.length-1];
	}

	public boolean canJump3(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int max=0, i=0;
		while(i<=max){
			max=(i+A[i])>max?(i+A[i]):max;
			if(max>=A.length-1)
				return true;

			i++;
		}
		return false;
	}


	public int minJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] minJumps=new int[A.length];
		Arrays.fill(minJumps, -1);
		return jump(0, A, minJumps);
	}

	private int jump(int idx, int[] A, int[] minJumps){
		if(idx>=A.length-1)
			return 0;

		if(minJumps[idx]!=-1)
			return minJumps[idx];

		int min=A.length;
		for(int i=1; i<=A[idx]; i++){
			int njump=jump(idx+i, A, minJumps);
			if(njump<min)
				min=njump;
		}
		minJumps[idx]=min+1;
		return min+1;
	}

	public int minJump2(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int nsteps=0;
		int prevMax=0, max=0;
		int i=0;
		while(prevMax<(A.length-1)){
			while(i<=prevMax){
				int end=i+A[i];
				if(end>max)
					max=end;
				i++;
			}
			if(max==prevMax){
				nsteps=Integer.MAX_VALUE;
				break;
			}
			prevMax=max;
			nsteps++;
		}
		return nsteps;
	}
}
