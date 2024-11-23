package com.shop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper {

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void selectProductAndAddToCart(int productIndex) {
        // Добавляем товар по индексу
        String productSelector = ".product-grid .item-box:nth-of-type(" + productIndex + ") input[value='Add to cart']";
        click(By.cssSelector(productSelector));
    }

    public boolean isProductAddedToCart() {
        // Проверка наличия сообщения об успешном добавлении товара
        return isElementPresent(By.cssSelector(".bar-notification.success"));
    }
}
