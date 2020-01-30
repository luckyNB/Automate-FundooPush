package com.fundoopush.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddArticlePage {
    @FindBy(xpath = "//mat-icon[@class='mat-icon-floating mat-icon material-icons notranslate mat-icon-no-color']")
    WebElement addSymbol;
    @FindBy(xpath = "//button[contains(text(),'ADD ARTICLE')]")
    WebElement addArticleButton;



}
