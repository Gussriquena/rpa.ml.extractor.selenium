package rpa.ml.extractor.selenium.browser;

import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import rpa.ml.extractor.selenium.constants.PageEnum;

public class BrowserConfiguration {

	public static final ChromeOptions getChromeOptions() {
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		chromePreferences.put("profile.managed_default_content_settings.popups", 0);
		chromePreferences.put("profile.managed_default_content_settings.notifications", 2);
		chromePreferences.put("profile.managed_default_content_settings.cookies", 2);
		chromePreferences.put("profile.managed_default_content_settings.images", 2);
		chromePreferences.put("profile.managed_default_content_settings.stylesheets", 2);
		chromePreferences.put("profile.managed_default_content_settings.plugins", 2);
		chromePreferences.put("profile.managed_default_content_settings.popups", 2);
		chromePreferences.put("profile.managed_default_content_settings.geolocation", 2);
		chromePreferences.put("profile.managed_default_content_settings.media_stream", 2);
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
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setExperimentalOption("prefs", chromePreferences);

		if (Boolean.parseBoolean((PageEnum.ROBOT_CONFIG_HEADLESS.getValue()))) {
			options.addArguments("--headless");
		}

		return options;
	}
}
