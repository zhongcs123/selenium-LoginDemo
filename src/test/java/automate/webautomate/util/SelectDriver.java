package automate.webautomate.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;

public class SelectDriver {
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
		}if (browser.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.firefox.marionette", "\\browserDriver\\geckodriver.exe");
            return (WebDriver) new FirefoxFilter();
        }else {
			System.setProperty("webdriver.ie.driver", ".\\browserDriver\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
	}
}

