package holy.zhaole.common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJSDriverUtils {
	static {
		Logger logger = Logger.getLogger("com.gargoylesoftware.htmlunit");
		logger.setLevel(Level.OFF);
	}
	private static PhantomJSDriver driver = null;
	private static final String PJ_DRIVER = "C:\\Users\\Public\\work\\javaSpace\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe";

	public static PhantomJSDriver openPhantomJs() {
		DesiredCapabilities dcaps = new DesiredCapabilities();
		dcaps.setCapability("takesScreenshot", true);
		dcaps.setCapability("cssSelectorsEnabled", true);
		dcaps.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 "
				+ "(KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");
		dcaps.setCapability("phantomjs.page.settings.loadImages", false);
		dcaps.setJavascriptEnabled(true);
		dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PJ_DRIVER);
		driver = new PhantomJSDriver(dcaps);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		return driver;
	}
}
