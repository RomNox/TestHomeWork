package com.shop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    // Метод для проверки наличия определенного компонента на главной странице
    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div.main-carousel"));
    }

    // Метод для перехода на главную страницу через клик по логотипу или ссылке "Home"
    public void clickOnHomeLink() {
        click(By.cssSelector("a[href='/']"));
    }
}
