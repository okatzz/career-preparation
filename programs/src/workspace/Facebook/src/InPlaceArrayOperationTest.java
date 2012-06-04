import static org.junit.Assert.*;
import org.junit.Test;


public class InPlaceArrayOperationTest {

	@Test
	public void testinPlaceMerge(){
		int[] a=new int[]{0, 0};
		int[] b=new int[]{1};
		assertArrayEquals(new int[]{0, 1}, new InPlaceArrayOperation().inplaceMerge(a, b));
	}
	
	@Test
	public void testinPlaceRemoveDuplicates(){
		int[] a=new int[]{1, 1, 1, 2, 2, 3, 4, 4};
		assertArrayEquals(new int[]{1, 2, 3, 4, 0, 0, 0, 0}, new InPlaceArrayOperation().inplaceRemoveDuplicates(a));
	}
}
