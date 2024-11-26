package com;

import com.shop.models.RegistrationData;
import com.shop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationDataDrivenTests extends TestBase {

    @Test(dataProvider = "registrationDataWithCsv", dataProviderClass = DataProviders.class)
    public void registerUserWithCsvDataTest(RegistrationData registrationData) {
        // Переходим на страницу регистрации
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnRegistrationLink();

        // Заполняем форму регистрации
        app.getUser().fillRegistrationForm(registrationData);

        // Нажимаем кнопку регистрации
        app.getUser().clickOnRegistrationButton();

        // Проверяем успешность регистрации
        Assert.assertTrue(app.getUser().isSignOutButtonPresent(), "Registration failed: Sign out button is not present");
    }
}
