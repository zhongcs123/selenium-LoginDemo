package automate.webautomate.util;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.openqa.selenium.By;

public class GetBy {
	/**
	 * 获取配置文件，解决中文乱码
	 * @param element 配置文件名
	 * @param name	配置文件的key值
	 * @return
	 */
	public String setProperties(String properties,String key) {
			ResourceBundle bundle=ResourceBundle.getBundle(properties,Locale.CHINA);
			String string="";
				try {
					string=new String(bundle.getString(key).getBytes("ISO-8859-1"),"UTF-8");//解决中文乱码
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} 
			return string;
	}
	
	/**
	 * 获取element配置文件内容，并判断配置文件内容中的值
	 * @param key
	 * @return
	 */
		public By setBy(String key){
			String keyString=setProperties("element", key).split(">")[0];
			String vauleString=setProperties("element", key).split(">")[1];
			if (keyString.equalsIgnoreCase("id")) {
				return By.id(vauleString);
			}else if (keyString.equalsIgnoreCase("className")) {
				return By.className(vauleString);
			}else if (keyString.equalsIgnoreCase("cssSelector")) {
				return By.cssSelector(vauleString);
			}else if (keyString.equalsIgnoreCase("linkText")) {
				return By.linkText(vauleString);
			}else if (keyString.equalsIgnoreCase("name")) {
				return By.name(vauleString);
			}else if (keyString.equalsIgnoreCase("tagName")) {
				return By.tagName(vauleString);
			}else if(keyString.equalsIgnoreCase("xpath")) {
				return By.xpath(vauleString);
			}else {
				return By.partialLinkText(vauleString);
			}
		}
		
		/**
		 * 获取input配置文件内容
		 * @param inputKey
		 * @return
		 */
		public String setInput(String inputKey) {
			return this.setProperties("input", inputKey);
		}
}
