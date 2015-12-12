package com.logindy.fx.pages;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FXRatesPage {
	public static final String FXRatesUrl = "http://www.logindy.com/fx/rates";

	@FindBy(how = How.CLASS_NAME, className = "rate-panel")
	public List<WebElement> ratePanels;
	
	public void verifyFXRates(int orderNo, String pair, String buy, String sell) {
		assertThat(ratePanels, notNullValue());
		
		WebElement rates = ratePanels.get(orderNo);
		
		assertThat(rates, notNullValue());
		assertThat(rates.getText(), equalTo(pair));
	}
}
