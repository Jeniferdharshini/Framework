package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
		@Test(dataProvider="dataProviderMethod")
		public void bookTickets(String source, String destination) {
			System.out.println("Book the tickets "+source+" to "+destination);
			
		}
	@DataProvider
	public Object[][] dataProviderMethod(){
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="USA";
		objarr[0][1]="Madurai";
		
		objarr[1][0]="india";
		objarr[1][1]="Goa";
		
		objarr[2][0]="Goa";
		objarr[2][1]="Bangalore";

		return objarr;
		
		
	}


}
