package rpa.ml.extractor.selenium.model;

import java.math.BigDecimal;

public class ProductOutput {

	private String name;
	private BigDecimal price;
	private int salesAmount;
	
	public ProductOutput() {
		
	}
	
	public ProductOutput(String name, BigDecimal price, int salesAmount) {
		this.name = name;
		this.price = price;
		this.salesAmount = salesAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	@Override
	public String toString() {
		return "ProductOutput [name=" + name + ", price=" + price + ", salesAmount=" + salesAmount + "]";
	}
	
}
