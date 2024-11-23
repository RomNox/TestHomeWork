package com;

import com.shop.models.RegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        // Создаем объект с данными для регистрации
        RegistrationData registrationData = new RegistrationData(
                "male",
                "Vladimir22",
                "Romaikin22",
                "Vladimir_Romaikin22" + System.currentTimeMillis() + "@example.com",
                "Password123456!"
        );

        // Переходим на страницу регистрации
        app.getUser().clickOnRegistrationButton();

        // Заполняем форму регистрации
        app.getUser().fillRegistrationForm(registrationData);

        // Нажимаем кнопку регистрации
        app.getUser().clickOnRegistrationButton();

        // Проверяем успешность регистрации
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Registration failed: Sign out button is not present");
    }
}
