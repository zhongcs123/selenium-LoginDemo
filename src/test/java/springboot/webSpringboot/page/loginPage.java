package springboot.webSpringboot.page;

import org.testng.Assert;

import springboot.webSpringboot.util.DriverBase;

public class loginPage extends DriverBase{

	public loginPage(String browser) {
		super(browser);
	}
	
	/**
	 * 获取用户名输入框Element,输入用户名操作
	 */
	public void setUsername(String inputKey) {
		isDisplayed("username", "登录页面，用户名输入框元素不存在");
		sendKey("username", inputKey);
	}
	
	/**
	 * 获取密码输入框Element,输入密码操作
	 */
	public void setPassword(String inputKey) {
		isDisplayed("password", "登录页面，密码输入框元素不存在");
		sendKey("password", inputKey);
	}
	
	/**
	 * 获取用户名输入框Element,清空用户名输入框操作
	 */
	public void clearUsername() {
		isDisplayed("username", "登录页面，用户名输入框元素不存在");
		clear("username");
	}
	
	/**
	 * 获取密码输入框Element,清空密码输入框操作
	 */
	public void clearPassword() {
		isDisplayed("password", "登录页面，密码输入框元素不存在");
		clear("password");
	}

	
	/**
	 * 获取【登录】按钮Element，点击【登录】按钮操作
	 */
	public void clickLogin() {
		isDisplayed("buttonLog", "登录页面，【登录】按钮元素不存在");
		click("buttonLog");
	}
	
	/**
	 * 获取【记住账户】按钮Element，点击【记住账户】按钮操作
	 */
	public void clickRememberUser() {
		isDisplayed("jusername", "登录页面，【记住账户】按钮元素不存在");
		click("jusername");
	}
	
	/**
	 * 获取【记住密码】按钮Element，点击【记住密码】按钮操作
	 */
	public void clickRememberPass() {
		isDisplayed("jpassword", "登录页面，【记住密码】按钮元素不存在");
		click("jpassword");
	}
	
	/**
	 * 获取【忘记密码】按钮Element，点击【忘记密码】按钮操作
	 */
	public void clickForgetPass() {
		isDisplayed("forget", "登录页面，【忘记密码】按钮元素不存在");
		click("forget");
	}
	
	/**
	 * 获取用户不存在文本Element，断言
	 */
	public void userNothingness() {
		Assert.assertEquals("用户不存在", getText("userNothingness"),"“用户不存在”文本元素不存在");
	}
	
	/**
	 * 获取“密码错误”文本Element，断言
	 */
	public void passwordNothingness() {
		Assert.assertEquals("密码错误", getText("passwordNothingness"),"“密码错误”文本元素不存在");
	}
	
	/**
	 * 获取“用户名、密码不能为空”文本Element，断言
	 */
	public void UPNoll() {
		Assert.assertEquals("用户名、密码不能为空", getText("UPNoll"),"用户名、密码不能为空 文本元素不存在");
	}
	
	/**
	 * 断言，获取正常登陆后账户展示
	 */
	public void assertUser() {
		isDisplayed("assertUser", "登录失败");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
