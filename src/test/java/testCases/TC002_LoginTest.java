package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

	
	   @Test(groups={"Sanity","Master"})
	   public void verify_login()
	    {
		       logger.info("****** starting TC002_LoginTest*******");
		
		        try
		        {
		        //HomePage
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				Thread.sleep(5000);
				
				//LoginPage
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(p.getProperty("email"));
				lp.setPassword(p.getProperty("password"));
				lp.ClickLogin();
				Thread.sleep(5000);
				
				//MyAccount
				MyAccountPage macc=new MyAccountPage(driver);
		        boolean	targetPage=	macc.IsMyAccountPageExists();
		        Thread.sleep(5000);
		        
		      // Assert.assertEquals(targetPage, true, "Login Failed");
		       Assert.assertTrue(targetPage); 
		        }
		        catch(Exception e)
		        {
		        	//Assert.fail();
		        }
		       logger.info("****** Finished TC002_LoginTest*******");
		  		
		
	}
	
	
}
