package rpa.ml.extractor.selenium.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rpa.ml.extractor.selenium.browser.WebDriverFactory;
import rpa.ml.extractor.selenium.constants.PageEnum;
import rpa.ml.extractor.selenium.model.ProductOutput;

public class MercadoLivreController {

	private static Logger log = Logger.getLogger(MercadoLivreController.class);
	private WebDriver driver;
	private List<String> productUrl = new ArrayList<>();
	
	public void initFlow() {
		
		driver = WebDriverFactory.getInstance();
		
		try {
			OpenMercadoLivre();
			getAllProductsUrl();
			List<ProductOutput> productsOutput = getProductPriceAndSales();
			if (null != productsOutput) {
				
			}
		} catch(Exception e) {
			log.info(e.getMessage());
		}
	}
	
	private void OpenMercadoLivre() {
		String completeUrl = PageEnum.URL_ML_SEARCH.getValue() + "/xiaomi-redmi-note-9-pro";
		
		try {
			driver.get(completeUrl);
		} catch (Exception e) {
			log.error("Could not connect with " + completeUrl + " - " + e.getMessage());
		}
	}
	
	private void getAllProductsUrl() {
		List<WebElement> productsUrl = driver.findElements(By.xpath(PageEnum.XPATH_PRODUCT_LIST_LINK.getValue()));
		for (WebElement webElement : productsUrl) {
			productUrl.add(webElement.getAttribute("href"));
		}
	}
	
	private List<ProductOutput> getProductPriceAndSales() {
		List<ProductOutput> productOutput = new ArrayList<>();
		 
		for (String product : productUrl) {
			driver.get(product);
			String productPrice = driver.findElement(By.xpath(PageEnum.XPATH_PRODUCT_PAGE_PRICE.getValue())).getText();
			String productSalesAmount = driver.findElement(By.xpath(PageEnum.XPATH_PRODUCT_PAGE_AMOUNT.getValue())).getText();
			String productName = driver.findElement(By.xpath(PageEnum.XPATH_PRODUCT_PAGE_NAME.getValue())).getText();
			
			if(productSalesAmount.contains("vendido") || productSalesAmount.contains("vendidos")) {
				log.info(productName + " - " + productPrice + " - " + productSalesAmount);
				productOutput.add(new ProductOutput(productName, new BigDecimal(productPrice), Integer.parseInt(productSalesAmount.replaceAll("\\D", ""))));
			}
		}
		
		return productOutput;
	}
}
