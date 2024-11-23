package com;

import com.shop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        // Проверяем залогинен или нет
        if (app.getUser().isSignOutButtonPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginPositiveTest() {
        // Создаем объект пользователя с корректными данными
        User user = new User()
                .setEmail("qwertyz123@gmail.com")
                .setPassword("4H2NcN6a@!CnG");

        // Переход на страницу логина и вход в систему
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();

        // Проверяем, что пользователь успешно вошел в систему
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Sign out button is not present");
    }

    @Test(priority = 2)
    public void loginNegativeWithoutEmailTest() {
        // Создаем объект пользователя без email
        User user = new User()
                .setPassword("4H2NcN6a@!CnG");

        // Переход на страницу логина и попытка входа в систему
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();

        // Проверяем, что отображается предупреждение об ошибке
        Assert.assertTrue(app.getUser().isErrorMessagePresent(), "Error message is not present");
    }
}
