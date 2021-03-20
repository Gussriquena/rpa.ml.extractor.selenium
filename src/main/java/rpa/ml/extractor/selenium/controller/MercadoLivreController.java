package rpa.ml.extractor.selenium.controller;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import rpa.ml.extractor.selenium.browser.WebDriverFactory;
import rpa.ml.extractor.selenium.constants.PageEnum;

public class MercadoLivreController {

	private static Logger log = Logger.getLogger(MercadoLivreController.class);
	private WebDriver driver;
	
	public void initFlow() {
		
		driver = WebDriverFactory.getInstance();
		
		OpenMercadoLivre();
	}
	
	private void OpenMercadoLivre() {
		String completeUrl = PageEnum.URL_ML_SEARCH.getValue() + "/xiaomi-redmi-note-9-pro";
		
		try {
			driver.get(completeUrl);
		} catch (Exception e) {
			log.error("Could not connect with " + completeUrl + " - " + e.getMessage());
		}
	}
}
