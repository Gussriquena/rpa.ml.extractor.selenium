package rpa.ml.extractor.selenium.constants;

import rpa.ml.extractor.selenium.utils.ConfigReader;

public enum PageEnum {
	
	// URLs from properties
	URL_ML_MAIN(ConfigReader.read("ml.url.page.main")),
	URL_ML_SEARCH(ConfigReader.read("ml.url.page.search")),
	
	ROBOT_CONFIG_HEADLESS(ConfigReader.read("robot.config.headless")),
	
	// Elements
	XPATH_PRODUCT_LIST_ITEM("//li[@class='ui-search-layout__item']"),
	XPATH_PRODUCT_LIST_LINK("//li[@class='ui-search-layout__item']//a[1][@class='ui-search-link']"),
	XPATH_PRODUCT_PAGE_PRICE("(//div[@class='ui-pdp-price__second-line']/span/span[@class='price-tag-fraction'])[1]"),
	XPATH_PRODUCT_PAGE_AMOUNT("//div[@class='ui-pdp-header']/div/span[@class='ui-pdp-subtitle']"),
	
	EXCEL_PRODUCTS_INPUT(ConfigReader.read("excel.produtos.entrada")),
	EXCEL_PRODUCTS_OUTPUT(ConfigReader.read("excel.produtos.saida"));
	
	private String value;
	
	private PageEnum(String description) {
		this.value = description;
	}
	
	public String getValue() {
		return value;
	}
}
