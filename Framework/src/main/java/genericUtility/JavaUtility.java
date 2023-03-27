package genericUtility;

import java.util.Random;

public class JavaUtility {

	public int getRanDomNum()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
		
	}

}
