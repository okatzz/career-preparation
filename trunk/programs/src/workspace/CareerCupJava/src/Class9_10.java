import java.lang.Comparable;
import java.util.ArrayList;
import java.util.HashMap;

public class Class9_10 {

	 ArrayList<Box> maxHeightStack(Box[] boxes, HashMap<Box, ArrayList<Box>> maxAboveStackCache){
		 
		 ArrayList<Box> maxStack=new ArrayList<Box>();
		 int maxHeight=0;
		 
		 if(boxes == null || boxes.length==0)
			 return maxStack;
		 
		 for(Box box:boxes){
			 ArrayList<Box> aboveStack;
			 if(maxAboveStackCache.containsKey(box)){
				 aboveStack=maxAboveStackCache.get(box);
			 }
			 else{
				 ArrayList<Box> list=new ArrayList<Box>();
				 for(Box b:boxes){
					 if(b.canBeAbove(box)){
						 list.add(b);
					 }
				 }
				 aboveStack=maxHeightStack((Box[])list.toArray(), maxAboveStackCache);
				 maxAboveStackCache.put(box, aboveStack);
			 }
			 int aboveHeight=getStackHeight(aboveStack);
			 if(aboveHeight+box.height>maxHeight){
				 maxHeight=aboveHeight+box.height;
				 maxStack.clear();
				 maxStack.addAll(aboveStack);
				 maxStack.add(box);
			 }
		 }
		 
		 return maxStack;
	 }
	 
	 int getStackHeight(ArrayList<Box> stack){
		 return 0;
	 }
	
}

class Box{
	int height;
	int width;
	int depth;
	
	boolean canBeAbove(Box bottom){
		return (bottom.depth>depth && bottom.width>width && bottom.height>height);
	}
	
}
