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
		sendKey("username", inputKey);
	}
	
	/**
	 * 获取密码输入框Element,输入密码操作
	 */
	public void setPassword(String inputKey) {
		sendKey("password", inputKey);
	}
	
	/**
	 * 获取用户名输入框Element,清空用户名输入框操作
	 */
	public void clearUsername() {
		clear("username");
	}
	
	/**
	 * 获取密码输入框Element,清空密码输入框操作
	 */
	public void clearPassword() {
		clear("password");
	}

	
	/**
	 * 获取【登录】按钮Element，点击【登录】按钮操作
	 */
	public void clickLogin() {
		click("buttonLog");
	}
	
	/**
	 * 获取【记住账户】按钮Element，点击【记住账户】按钮操作
	 */
	public void clickRememberUser() {
		if (isSelected("jusername")) {
			click("jusername");
			if (!isSelected("jusername")) {
				click("jusername");
				if (isSelected("jusername")) {
					
				}else {
					System.err.println("点击未选中【记住账户】按钮后，不应该不是选中状态");
				}
				
			}else {
				System.err.println("点击已选中【记住账户】按钮后，不应该是选中状态");
			}
		}else {
			System.err.println("【记住账户】按钮默认选中状态，不应该不是选中状态");
		}
		
	}
	
	/**
	 * 获取【记住密码】按钮Element，点击【记住密码】按钮操作
	 */
	public void clickRememberPass() {
		if (isSelected("jpassword")) {
			click("jpassword");
			if (!isSelected("jpassword")) {
				click("jpassword");
				if (isSelected("jpassword")) {
					
				}else {
					System.err.println("点击未选中【记住密码】按钮后，不应该不是选中状态");
				}
			}else {
				System.err.println("点击已选中【记住密码】按钮后，不应该是选中状态");
			}
		}else {
			System.err.println("【记住密码】按钮默认选中状态，不应该不是选中状态");
		}
	}
	
	/**
	 * 获取【忘记密码】按钮Element，点击【忘记密码】按钮操作
	 */
	public void clickForgetPass() {
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
		Assert.assertEquals("ydcyxlys211",getText("assertUser"),"登陆失败" );
	}
	
	
	
}
