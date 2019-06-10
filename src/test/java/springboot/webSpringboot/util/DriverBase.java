package springboot.webSpringboot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	 * 显示等待，等待10秒，元素出现则操作，元素在10秒内没出现则报异常；对单个元素指定一个等待条件操作等待（推荐使用）
	 * @param elementKey
	 */
	public void WebDriverWait(String elementKey) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(setEle(elementKey)));//等待元素10秒是否出现，超时则抛出异常
	}
	
	/**
	 * 隐式等待，等待10秒，有元素则执行，超时报异常；
	 * 隐式等待，相当于设置全局的等待，在定位元素时，对所有元素设置超时时间。隐式等待是等页面加载，而不是元素加载！！！（隐式等待就是针对页面的，显式等待是针对元素的。）
	 */
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	 * 封装findElement(By by)
	 */
	public WebElement findElement(String elementKey) {
		WebDriverWait(elementKey);
		return driver.findElement(setEle(elementKey));
	}
	
	/**
	 * 封装findElements(By by)
	 */
	public List<WebElement> findElements(String elementKey) {
		return driver.findElements(setEle(elementKey));
	}
	
	/**
	 * 判断页面元素是否有效，再【点击】操作
	 * @param elementKey 参数为输入element.properties配置文件key值
	 */
	public void click(String elementKey) {
		Assert.assertEquals(true, findElement(elementKey).isEnabled());
		findElement(elementKey).click();
	}
	
	/**
	 * 判断页面元素是否有效，再【输入】操作
	 * @param elementKey 请输入element.properties配置文件key值
	 * @param inputKey 请输入inputs.properties配置文件key值
	 */
	public void sendKey(String elementKey,String inputKey) {
		Assert.assertEquals(true, findElement(elementKey).isEnabled());
		findElement(elementKey).sendKeys(setInput(inputKey));	
	}
	
	/**
	 * 判断页面元素是否有效，再【清除输入框】内容操作
	 * @param elementKey 参数为输入element.properties配置文件key值
	 */
	public void clear(String elementKey) {
		Assert.assertEquals(true, findElement(elementKey).isEnabled());
		findElement(elementKey).clear();
	}
	
	/**
	 * 【获取元素文本信息】操作
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
	 * 封装判断元素是否被选中isSelected
	 */
	public boolean isSelected(String elementKey) {
			return findElement(elementKey).isSelected();
	}
	
	/**
	 * 判断元素是否显示在页面上
	 * @param 输入参数值
	 */
	public boolean isDisplayed(String elementKey) {
		return findElement(elementKey).isDisplayed();
	}

	
	/**
	 * 判断元素按钮是否有效
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
