package springboot.webSpringboot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DriverBase extends selectDriver{
	public WebDriver driver;
	public selectDriver selectDriver;
	public DriverBase(String browser) {
		selectDriver=new selectDriver();
		this.driver=selectDriver.driverName(browser);
	}
	
	/**
	 * 实例getBy类，获取element.properties配置文件内容
	 * @param elementKey
	 * @return By类型
	 */
	public By setEle(String elementKey) {
		return new getBy().setBy(elementKey);
	}
	
	/**
	 * 实例getBy类，获取input.properties配置文件内容
	 * @param inputKey
	 * @return String类型
	 */
	public String setInput(String inputKey) {
		return new getBy().setInput(inputKey);
	}
	
	/**
	 * 封装findElement(By by)
	 */
	public WebElement findElement(String elementKey) {
		return driver.findElement(setEle(elementKey));
	}
	
	/**
	 * 封装findElements(By by)
	 */
	public List<WebElement> findElements(String elementKey) {
		return driver.findElements(setEle(elementKey));
	}
	
	/**
	 * 点击
	 * @param elementKey 参数为输入element.properties配置文件key值
	 */
	public void click(String elementKey) {
		findElement(elementKey).click();
	}
	
	/**
	 * 输入
	 * @param elementKey 请输入element.properties配置文件key值
	 * @param inputKey 请输入inputs.properties配置文件key值
	 */
	public void sendKey(String elementKey,String inputKey) {
		findElement(elementKey).sendKeys(setInput(inputKey));
	}
	
	/**
	 * 清除输入框内容
	 * @param elementKey 参数为输入element.properties配置文件key值
	 */
	public void clear(String elementKey) {
		findElement(elementKey).clear();
	}
	
	/**
	 * 获取元素文本信息
	 * @param elementKey
	 * @return String类型
	 */
	public String getText(String elementKey) {
		return findElement(elementKey).getText();
	}
	
	/**
     * 获得页面的标题
     */
    public String getTitle() {
        return driver.getTitle();
    }
	
    /**
	 * 封装强制等待时间,单位ms
	 * @param time 强制等待时间，单位毫秒ms       
	 */
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 封装判断元素是否被选中isSelected
	 */
	public boolean isSelected(String elementKey) {
			return findElement(elementKey).isSelected();
	}
	
	/**
	 * 判断元素是否显示
	 * @param 输入参数值
	 */
	public boolean isDisplayed(String elementKey) {
		return findElement(elementKey).isDisplayed();
	}
	
	/**
	 * 判断元素是否显示
	 * @param 输入参数值
	 */
	public void isDisplayed(String elementKey,String string) {
		Assert.assertEquals(true, isDisplayed(elementKey),string);
	}

	
	/**
	 * 判断元素是否显示
	 */
	public boolean isEnabled(String elementKey) {
		return findElement(elementKey).isEnabled();
	}
	
	/**
	 * 返回
	 */
	public void back() {
		driver.navigate().back();
	}
	
	/**
     * 刷新页面
     */
    public void refresh() {
        driver.navigate().refresh();
    }
    
    /**
	 * 打开网址
	 */
	public void get(String url) {
		driver.get(setInput(url));
	}
	
    /**
	 * 获取当前url
	 */
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * 获取当前窗口
	 */
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}
	
	/**
	 * 获取当前系统窗口list
	 */
	public List<String> getWindowsHandles() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(winHandels);
		return handles;
	}
	
	/**
	 * 切换windows窗口
	 */
	public void switchWindows(String name) {
		driver.switchTo().window(name);
	}
	
	/**
	 * 切换alert窗口
	 */
	public Alert switchAlert() {
		return driver.switchTo().alert();
	}
	
	/**
	 * 模态框切换
	 */
	public void switchToMode() {
		driver.switchTo().activeElement();
	}
	
	/**
	 * 鼠标悬停actionMoveElement
	 */
	public void action(String elementKey) {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(elementKey)).perform();
	}
	
	/**
	 * 鼠标左键单击actionMoveElement
	 */
	public void actionCilck(String elementKey,int i) {
		Actions action = new Actions(driver);
		action.click(findElements(elementKey).get(i)).perform();
	}
	
	/**
	 * 获取cookcie
	 * @return
	 */
	public Set<Cookie> getCookie() {
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies;
	}
	
	/**
	 * 删除cookie
	 */
	public void deleteCookie() {
		driver.manage().deleteAllCookies();
	}
	
	/**
	 * 设置cookie
	 */
	public void setCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}
	
	/**
	 * 放大窗口
	 */
	public void maxwindow() {
		driver.manage().window().maximize();
	}
	
	/**
	 * 拖拽浏览器滚动条,直到该元素位置
	 */
	public void javascript(String elementKey) {
	  JavascriptExecutor je = (JavascriptExecutor) driver;
	  je.executeScript("arguments[0].scrollIntoView(true);",findElement(elementKey));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
