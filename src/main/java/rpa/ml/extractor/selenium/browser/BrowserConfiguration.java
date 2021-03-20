package rpa.ml.extractor.selenium.browser;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import rpa.ml.extractor.selenium.constants.PageEnum;

public class BrowserConfiguration {

	public static final ChromeOptions getChromeOptions() {
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		chromePreferences.put("profile.default_content_settings.popups", 0);
		chromePreferences.put("download.default_directory", 0);

		//DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("enable-automation");
		options.addArguments("start-maximized");
		//options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setExperimentalOption("prefs", chromePreferences);

		//desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

		if (Boolean.parseBoolean((PageEnum.ROBOT_CONFIG_HEADLESS.getValue()))) {
			options.addArguments("--headless");
		}

		return options;
	}
}
