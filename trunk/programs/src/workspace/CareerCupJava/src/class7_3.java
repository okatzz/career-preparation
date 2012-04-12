
public class class7_3 {

}

class Line{
	static final double epsilon=0.0000001;
	boolean vertical=false;
	double slope;
	double intercept;
	
	public Line(boolean v, double s, double i){
		this.vertical=v;
		slope=s;
		intercept=i;
	}
	
	public boolean intersect(Line other){
		if(vertical){
				return !other.vertical || Math.abs(intercept-other.intercept)<epsilon;
		}else{
			return other.vertical || Math.abs(slope-other.slope)>epsilon||Math.abs(intercept-other.intercept)<epsilon;
		}
	}
}
