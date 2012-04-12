import java.util.HashMap;
import java.util.ArrayList;

public class Class9_2 {
	
	HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
	
	public boolean getPath(int x, int y, ArrayList<Point> path){
		Point point = new Point(x, y);
		if(cache.containsKey(point))
			return cache.get(point);
		if(x==0 && y==0){
			path.add(point);
			return true;
		}
		boolean success=false;
		if(x-1>=0 && isFree(x-1, y))
			success = getPath(x-1, y, path);
		if(!success && y-1>=0 && isFree(x, y-1))
			success = getPath(x, y-1, path);
		if(success)
			cache.put(point, true);
		return success;
	}
	
}

class Point{
	int x;
	int y;
	Point(int xx, int yy){
		x=xx;
		y=yy;
	}
}
