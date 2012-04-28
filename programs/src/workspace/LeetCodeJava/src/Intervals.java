/*
 * http://www.mitbbs.com/article_t1/JobHunting/32079031_0_1.html
 * http://news.mitbbs.com/mitbbs_bbsdoc_div_article.php?board=JobHunting&gid=31922191
 * http://mitbbssg.com/bbsann2/life.faq/JobHunting/17/D12842543542i0/D12900953122U0/D12958312052E0/M.1284263000_2.v0/%CE%D2%BB%A8%C1%CB%D2%BB%B8%F6%D0%A1%CA%B1%B2%C5%B5%F7%CD%A8%B9%FD%D5%E2%B8%F6%B3%CC%D0%F2
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

class Interval{
	int start;
	int end;
	Interval(){
		start=Integer.MAX_VALUE;
		end=0;
	}
	Interval(int s, int e){
		start=s;
		end=e;
	}
}

class IntervalComparator implements Comparator<Interval>{
	public int compare(Interval ia, Interval ib){
		int diff=ia.start-ib.start;
		return diff!=0? diff: (ia.end-ib.end);
	}
}

public class Intervals {

	private LinkedList<Interval> intervals;
	
	public Intervals(){
		intervals=new LinkedList<Interval>();
	}
	
	public Intervals(ArrayList<Interval> list){
		intervals=new LinkedList<Interval>(list);
	}
	
	public ArrayList getIntervals(){
		return new ArrayList<Interval>(intervals);
	}
	
	public void insert(Interval newInterval){
		ListIterator<Interval> iterator = intervals.listIterator();
		Interval mergedInterval=new Interval(newInterval.start, newInterval.end);
		while(iterator.hasNext()){
			Interval temp=iterator.next();
			if(newInterval.start<=temp.end){
				mergedInterval.start=Math.min(temp.start, newInterval.start);
				iterator.previous();
				break;
			}
		}

		while(iterator.hasNext()){
			Interval temp = iterator.next();
			if(newInterval.end<temp.start){
				iterator.previous();
				break;
			};
			mergedInterval.end=Math.max(temp.end, newInterval.end);
			iterator.remove();
		}
		iterator.add(mergedInterval);
	}
	
	public void merge(){
		Collections.sort(intervals, new IntervalComparator());
		ListIterator<Interval> it = intervals.listIterator();
		while(it.hasNext()){
			Interval cur=it.next();
			if(it.hasNext()){
				Interval next = it.next();
				if(cur.end>=next.start){
					cur.end=Math.max(cur.end, next.end);
					it.remove();
				}
				it.previous();
			}
		}
	}
	
}
