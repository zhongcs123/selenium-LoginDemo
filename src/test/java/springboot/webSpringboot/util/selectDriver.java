package springboot.webSpringboot.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class selectDriver {
	/**
	 * 选择浏览器类型的类
	 * 封装driver
	 * System.setProperty("webdriver.chrome.driver", ".\\浏览器驱动\\chromedriver.exe");
	 * 返回new ChromeDriver();
	 */
	public WebDriver driverName(String browser) {
			//equalsIgnoreCase代表不区分大小写
	        //判断浏览器的类型是"firefox"或者"chrome"又或者是"IE"
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
			return new ChromeDriver();
		}else {
			System.setProperty("webdriver.ie.driver", ".\\browserDriver\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
	}
}

