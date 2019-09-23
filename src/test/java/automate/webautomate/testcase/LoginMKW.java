package automate.webautomate.testcase;

import org.testng.annotations.Test;

import automate.webautomate.page.LoginMKWPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginMKW {
	public  LoginMKWPage login;
  @Test
  public void trueLogin() {
	  login.setUsername("mTrueUsername");//输入正确账号
	  login.setPassword("mTruePassword");//输入正确密码
	  login.clickLogin();//点击登录
	  login.assertLogin();//断言登录是否成功
  }
  
  @BeforeClass
  public void beforeClass() {
	  login=new LoginMKWPage("chrome");
	  login.get("LoginMKWUrl");// 打开网址
	  login.maxwindow();// 放大窗口
  }

  @AfterClass
  public void afterClass() {
	  login.driver.close();//关闭浏览器
  }

}
