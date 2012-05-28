import static org.junit.Assert.*;

import org.junit.Test;


public class SimplifyPathTest {

	@Test
	public void testSimplifyPath() {
		SimplifyPath path=new SimplifyPath();
		assertEquals(path.simplifyPath("/home/../fail//"), "/home/fail");
	}

}
