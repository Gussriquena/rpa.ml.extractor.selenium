package rpa.ml.extractor.selenium.main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import rpa.ml.extractor.selenium.controller.MercadoLivreController;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("resources\\log4j.properties");
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

		log.info("Starting mercado livre selenium extractor");
		
		MercadoLivreController mercadoLivreController = new MercadoLivreController();
		mercadoLivreController.initFlow();
	}

}
