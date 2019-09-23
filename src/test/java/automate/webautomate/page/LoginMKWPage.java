package automate.webautomate.page;

import org.testng.Assert;

import automate.webautomate.util.DriverBase;

public class LoginMKWPage extends DriverBase{

	public LoginMKWPage(String browser) {
		super(browser);
	}
	
	/**
	 * 获取用户名输入框Element,输入用户名操作
	 */
	public void setUsername(String inputKey) {
		sendKey("username", inputKey);
	}
	
	/**
	 * 获取密码输入框Element,输入密码操作
	 */
	public void setPassword(String inputKey) {
		sendKey("password", inputKey);
	}

	/**
	 * 获取【登录】按钮Element，点击【登录】按钮操作
	 */
	public void clickLogin() {
		click("buttonLog");
		sleep(4000);
	}
	
	/**
	 * 获取账号，做断言
	 */
	public void assertLogin() {
		action("assertUser");//鼠标悬停
		sleep(2000);
		Assert.assertEquals("君子坦蛋蛋zZZ", getText("myName"),"登陆失败");
		System.out.println("登录成功");
	}
}
