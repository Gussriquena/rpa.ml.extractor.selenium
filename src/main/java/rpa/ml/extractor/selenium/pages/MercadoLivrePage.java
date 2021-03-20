package rpa.ml.extractor.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercadoLivrePage extends PageObjects {
	private Logger log = Logger.getLogger(MercadoLivrePage.class);
	
	// Elements
	@FindBy(how = How.XPATH, using = "li[@class='ui-search-layout__item']")
	private WebElement productsList;
	
	@FindBy(how = How.XPATH, using = "//li[@class='ui-search-layout__item']//a[1][@class='ui-search-link']")
	private WebElement productsLinks;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ui-pdp-price__second-line']/span/span[@class='price-tag-fraction'])[1]")
	private WebElement productPrice;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ui-pdp-header']/div/span[@class='ui-pdp-subtitle']")
	private WebElement productSalesAmount;
	
	public MercadoLivrePage(WebDriver driver) {
		super(driver);
	}
}
