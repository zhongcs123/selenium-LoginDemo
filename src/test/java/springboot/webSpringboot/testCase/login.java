package springboot.webSpringboot.testCase;

import org.testng.annotations.Test;

import springboot.webSpringboot.page.loginPage;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class login {
	public loginPage login;

	@Test(priority = 1) // 错误账户登录
	public void FalseULogin() {
		login.setUsername("FalseUsername");// 输入错误用户名
		login.setPassword("TruePassword");// 输入密码
		login.clickLogin();// 点击登录
		login.userNothingness();//断言
		login.sleep(2000);//强制等待2秒
	}

	@Test(priority = 2) // 正确账户，错误密码登录
	public void FalsePLogin() {
		login.clearUsername();//清空用户名输入框
		login.clearPassword();//清空密码输入框
		login.setUsername("TrueUsername");// 输入用户名
		login.setPassword("FalsePassword");// 输入错误密码
		login.clickLogin();// 点击登录
		login.passwordNothingness();//断言
		login.sleep(2000);//强制等待2秒
	}

	@Test(priority = 3) // 账户为空，输入密码，点击登录
	public void FalseUNullLogin() {
		login.clearUsername();//清空用户名输入框
		login.clearPassword();//清空密码输入框
		login.setPassword("TruePassword");// 输入密码
		login.clickLogin();// 点击登录
		login.UPNoll();//断言
		login.sleep(2000);//强制等待2秒
	}

	@Test(priority = 4) // 输入账户，密码为空，点击登录
	public void FalsePNullLogin() {
		login.clearUsername();//清空用户名输入框
		login.clearPassword();//清空密码输入框
		login.setUsername("TrueUsername");// 输入用户名
		login.clickLogin();// 点击登录
		login.UPNoll();//断言
		login.sleep(2000);//强制等待2秒
	}

	@Test(priority = 5) // 记住账户、记住密码按钮可正常点击
	public void JUPclick() {
		login.clickRememberUser();//点击记住账户
		login.clickRememberPass();//点击记住密码
		login.sleep(2000);//强制等待2秒
	}

	@Test(priority = 6) // 点击忘记密码，跳转找回密码页面,判断正常跳转关闭该页面，切换登录页面；
	public void LoginFindPasswordPage() {
		String handle=login.getWindowHandle();//获取当前句柄
		login.clickForgetPass();//点击忘记密码
		List<String> handles=login.getWindowsHandles();//遍历所有句柄
		for (String h : handles) {
			if (h.equals(handle)) {
				continue;
			} else {
				login.switchWindows(h);//切换句柄：忘记密码页面
//				System.out.println("忘记密码页句柄：" + h);
			}
		}
		Assert.assertEquals("找回密码", login.getTitle(), "产品登录页面：点击【忘记密码】没正常跳转找回密码页面");
		login.driver.close();
		login.switchWindows(handle);//切换句柄：登录页面
		login.sleep(2000);//强制等待2秒
		
	}

	@Test(priority = 7) // 正常登录；
	public void logingTrue() {
		login.clearUsername();//清空用户名输入框
		login.clearPassword();//清空密码输入框
		login.setUsername("TrueUsername");// 输入用户名
		login.setPassword("TruePassword");// 输入密码
		login.clickLogin();// 点击登录
		login.assertUser();//断言是否正常登录
		
	}

	@BeforeClass
	public void beforeClass() {
		login = new loginPage("chrome");// 选择浏览器
		login.get("loginUrl");// 打开网址
		login.maxwindow();// 放大窗口
		login.sleep(3000);// 等待3秒
	}

	@AfterClass
	public void afterClass() {
		login.driver.close();// 关闭浏览器
	}

}
