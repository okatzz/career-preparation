/*
 * Given a two dimensional graph with points on it, find a line which passes the most number of points.
 */

import java.util.*;

public class class7_6 {
	
	public Line findBestLine(GraphPoint[] points){
		
		HashMap<Line, Integer> map=new HashMap<Line, Integer>();
		int maxCount=0;
		Line bestLine=null;
		for(int i=0; i<points.length; i++){
			for(int j=i+1; j<points.length; j++){
				Line line=new Line(points[i], points[j]);
				Integer count=map.get(line);
				if(count==null){
					count=0;
				}
				if(++count>maxCount){
						maxCount=count;
						bestLine=line;
				}
				map.put(line, count);
			}
		}
		return bestLine;
	}

}

class Line{
	static final double epsilon = 0.0001;
	double slope;
	double intercept;
	boolean vertical=false;
	
	public Line(GraphPoint p1, GraphPoint p2){
		if(Math.abs(p1.x-p2.x)<epsilon){
			vertical=true;
			intercept=p1.x;
		}else{
			vertical=false;
			slope = (p1.y-p2.y)/(p1.x-p2.x);
			intercept=p1.y-slope*p1.x;
		}
	}
	
	@Override
	public boolean equals(Object obj){
		Line line=(Line)obj;
		if(this.vertical==line.vertical && Math.abs(this.slope-line.slope)<epsilon && Math.abs(this.intercept-line.intercept)<epsilon)
			return true;
		return false;
	}
	
	@Override
	public int hashCode(){
		int sl=(int)this.slope*1000;
		int in=(int)this.intercept*1000;
		return sl|in;
	}
	
}

class GraphPoint{
	public double x;
	public double y;
	public GraphPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
}