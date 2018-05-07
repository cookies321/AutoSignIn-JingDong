package holy.zhaole.controller;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import holy.zhaole.common.PhantomJSDriverUtils;


/**
 * 
 * @Description: TODO
 * @author 赵乐
 * @date 2017年12月29日 上午8:32:46
 */
public class SignIn {
	
	private static PhantomJSDriver driver = null;
	
	/**
	 * 
	 * @Description TODO
	 * @author 赵乐
	 * @date 2017年12月29日 上午8:34:45
	 * @action signJingDong
	 * @param @param userName
	 * @param @param password
	 * @return void
	 */
	public static void signJingDong(String userName,String password){	
		try {
			//获取Driver对象
			driver = PhantomJSDriverUtils.openPhantomJs();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			//获取京东登录页面
			String url = "https://passport.jd.com/new/login.aspx";
			driver.get(url);
			//点击切换账户登录
			By link = By.cssSelector("div.login-tab.login-tab-r");
			
			WebElement linkElement = driver.findElement(link);
			linkElement.click();
			Thread.sleep(3000);
			
	        //获取输入框的id,并在输入框中输入用户名  
	        WebElement loginInput = driver.findElement(By.id("loginname"));  
	        System.out.println(loginInput.getAttribute("placeholder"));
	        loginInput.sendKeys(userName);  
	          
	        //获取输入框的id，并在输入框中输入密码  
	        WebElement pwdInput = driver.findElement(By.id("nloginpwd"));  
	        pwdInput.sendKeys(password);
	        
	        //获取登陆按钮的className，并点击  
	        WebElement loginBtn = driver.findElement(By.id("loginsubmit"));  
	        loginBtn.click();	        
	        Thread.sleep(3000);
			
			//获取签到页面
			driver.get("https://vip.jd.com/home.html");
			WebElement signedEle = null;
			int flag = 0;
			//签到页面的布局会因账号不同而不同，目前只找到这两种
			try {
				signedEle = driver.findElement(By.cssSelector("div#signIn"));
			} catch (Exception e) {
				flag = 1;
			}
			if(signedEle==null || flag == 1){
				signedEle = driver.findElement(By.cssSelector("div.sign-in.signed"));
			}
			signedEle.click();
			System.out.println("签到成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.quit();
			e.printStackTrace();
		}
		driver.quit();
	}
}
