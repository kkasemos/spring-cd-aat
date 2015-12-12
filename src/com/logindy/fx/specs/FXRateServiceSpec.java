package com.logindy.fx.specs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.logindy.fx.pages.FXRatesPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

public class FXRateServiceSpec {
	
	private WebDriver driver;

	public FXRateServiceSpec() {
		this.driver = DriverFactory.getDriver();
	}
	
	@Step("Current <currency pair> buy rate is <buy> and sell rate is <sell>")
	public void currentBuyAndSellRates(String pair, String buy, String sell) {
    	System.out.format("%s %s/%s\n", pair, buy, sell);
	}
	
    @Step("<currency pair> should show up in the page with a buy rate is <buy> and a sell rate is <sell>")
    public void shouldShowFXRates(String pair, String buy, String sell) {
    	FXRatesPage fxRatesPage = PageFactory.initElements(driver, FXRatesPage.class);
    	fxRatesPage.verifyFXRates(0, pair, buy, sell);
    }
    
    @Step("User must open the FX Rates page")
    public void mustOpenFXRatesPage() {
    	this.driver.get(FXRatesPage.FXRatesUrl);
    }

    @Step("Step that takes a table <table>")
    public void stepWithTable(Table table) {
        System.out.println(table.getColumnNames());

        for (TableRow tableRow : table.getTableRows()) {
            System.out.println(tableRow.getCell("Product") + " " + tableRow.getCell("Description"));
        }
    }
}
