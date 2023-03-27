package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
public void createContact() {
	System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
	//Assert.assertEquals(true, true);
	Assert.assertEquals(false, true);

	System.out.println("step4");
	System.out.println("step5");

}
	@Test
	public void modifyContact() {
		System.out.println("step6");
		System.out.println("step7");
	
	}
}
