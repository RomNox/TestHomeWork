package com;

import com.shop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        // Залогинен или нет?
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        User user = new User("qwertyz123@gmail.com", "4H2NcN6a@!CnG");
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToCartTest() {
        // Выбираем товар на главной странице и добавляем его в корзину
        app.getCart().selectProductAndAddToCart(2); // Добавляем второй товар

        // Проверяем успешное добавление товара в корзину
        Assert.assertTrue(app.getCart().isProductAddedToCart(), "Product was not added to cart successfully");
    }
}