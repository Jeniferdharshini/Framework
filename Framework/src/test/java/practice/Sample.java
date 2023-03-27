package practice;

import org.testng.annotations.Test;

public class Sample {
	
	@Test(groups="SmokeTest")
	public void createContact() {
    	System.out.println("contact created");
	//	int[] array= {1,3,5};
		//System.out.println(array[6]);
	}
	
//	@Test(dependsOnMethods = "createContact")
	@Test(invocationCount = 3)
	public void modifyContact() {
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods="createContact")
	public void deleteContact() {
		System.out.println("delete contact");
	}

}
