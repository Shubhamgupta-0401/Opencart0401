package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
    
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
		
   @FindBy(xpath="//input[@name='agree']")	
	WebElement chkdPolicy;
	
   @FindBy(xpath=" //input[@value='Continue']")	
  	WebElement btnContinue;
  	
  	 
  	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConformation;
	
	public void setFirstName(String fname)
	{
	 txtFirstname.sendKeys(fname);	
	}
	
	public void setLastName(String lname)
	{
	 txtLastname.sendKeys(lname);	
	}
	
	public void setEmail(String email)
	{
	 txtEmail.sendKeys(email);	
	}
	
	public void setPassword(String pwd)
	{
	 txtPassword.sendKeys(pwd);	
	}
	
	public void setConfirmPassword(String pwd)
	{
	 txtConfirmPassword.sendKeys(pwd);	
	}
	
	public void setTelephone(String tel)
	{
	 txtTelephone.sendKeys(tel);	
	}
	
	
	
		
	public void setPrivatePolicy()
	{
	 chkdPolicy.click();
	}
	
	public void setclickContinue()
	{
	//sol1	
	 btnContinue.click();	
	//sol2 
	// btnContinue.submit();
	//sol3
	// btnContinue.sendKeys(Keys.RETURN);
	//sol4 
	// WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click(); 
	 	 
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConformation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
		
	}	
}

	
	
	
	
	
	

