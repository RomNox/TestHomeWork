package com;

import com.shop.models.Contact;
import com.shop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        // Убедимся, что пользователь залогинен перед добавлением контакта
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        User user = new User()
                .setEmail("qwertyz123@gmail.com")
                .setPassword("4H2NcN6a@!CnG");
        app.getUser().fillLoginForm(user);
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        // Переходим на страницу добавления нового контакта
        app.getContact().clickOnAddContactLink();

        // Создаем объект Contact
        Contact contact = new Contact()
                .setName("Irina")
                .setLastName("Baker")
                .setPhone("1234567890")
                .setEmail("irinabaker@gmail.com")
                .setAddress("123 Berliner Street")
                .setDescription("Friend");

        // Заполняем форму контакта и сохраняем его
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();

        // Проверяем успешное добавление контакта
        Assert.assertTrue(app.getContact().isContactAdded("Irina"), "Contact was not added successfully");
    }
}
