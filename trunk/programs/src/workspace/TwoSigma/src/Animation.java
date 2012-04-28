import java.util.ArrayList;
import java.util.Arrays;


public class Animation {

	private static final double epsilon = 0.000001;
	
	class Particle{
		private char direction;
		private double location;
		private double speed;
		private int chamberSize;
		
		Particle(char direction, double initLocation, double speed, int chamberSize){
			this.direction=direction;
			this.location=initLocation;
		}
		
		void Move(){
			if(direction=='L'){
				location-=speed;
			}else{
				location+=speed;
			}
		}
		
		int getNearestKeyPosition(){
			if(-location>epsilon || (location-chamberSize)>epsilon)
				return Integer.MIN_VALUE;
			double roundDown = Math.floor(location);
			double roundUp = Math.ceil(location);
			if((location-roundDown)-(roundUp-location)>=epsilon)
				return (int)roundUp;
			else
				return (int)roundDown;
		}
	}
	
	class Chamber{
		int size;
		ArrayList<Particle> particles;
		char[] hasAtPosition;
		boolean isEmpty=true;
		
		Chamber(int size){
			this.size = size;
			this.particles = null;
			this.hasAtPosition = new char[size+1];
			Arrays.fill(hasAtPosition, '.');
			isEmpty=false;
		}
		
		void setParticles(ArrayList<Particle> ps){
			this.particles = ps;
		}
		
		int getSize(){
			return size;
		}
		
		void changeState(){
			for(Particle p: particles){
				p.Move();
			}
		}
		
		String getState(){
			Arrays.fill(hasAtPosition, '.');
			isEmpty=true;
			for(Particle p: particles){
				int pos = p.getNearestKeyPosition();
				if(pos!=Integer.MIN_VALUE){
					hasAtPosition[pos]='X';
					isEmpty=false;
				}
			}
			return String.valueOf(hasAtPosition);
		}
		
		boolean isEmpty(){
			return isEmpty;
		}
		
	}
	

	
	
	public String[] animation(double speed, String init){
		
		Chamber chamber = new Chamber(init.length()-1);
		
		ArrayList<Particle> particles = new ArrayList<Particle>();
		for(int i=0; i<init.length(); i++){
			if(init.charAt(i)!='.'){
				Particle newParticle = new Particle(init.charAt(i), i*1.0, speed, chamber.getSize());
				particles.add(newParticle);
			}
		}
		chamber.setParticles(particles);
		
		ArrayList<String> results=new ArrayList<String>();
		results.add(chamber.getState());
		while(!chamber.isEmpty()){
			chamber.changeState();
			results.add(chamber.getState());
		}
		
		return (String[]) results.toArray();
	}
	
}
