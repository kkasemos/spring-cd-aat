package com.logindy.fx.pages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FXRatesPage {
	public static final String FXRatesUrl = "http://www.logindy.com/fx-rates.html";

	@FindBy(how = How.CLASS_NAME, className = "rate-panel")
	public List<WebElement> ratePanels;
	
	public void verifyFXRates(int orderNo, String pair, String buy, String sell) {
		assertThat(ratePanels, notNullValue());
		
		WebElement ratePanel = ratePanels.get(orderNo);
		assertThat(ratePanel, notNullValue());
		
		WebElement currencyPair = ratePanel.findElement(By.className("rate-panel__currency-pair"));
		assertThat(currencyPair.getText(), equalTo(pair));
		
		WebElement buyRate = ratePanel.findElement(By.className("rate-panel__buy-rate"));
		assertThat(buyRate.getText(), equalTo(buy));
		
		WebElement sellRate = ratePanel.findElement(By.className("rate-panel__sell-rate"));
		assertThat(sellRate.getText(), equalTo(sell));		
	}
}
