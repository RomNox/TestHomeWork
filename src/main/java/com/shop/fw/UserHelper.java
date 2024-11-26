package com.shop.fw;

import com.shop.models.RegistrationData;
import com.shop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    // Метод для нажатия на ссылку "Register"
    public void clickOnRegistrationLink() {
        click(By.cssSelector("a[href='/register']")); // Добавляем метод для перехода на страницу регистрации
    }

    // Метод для нажатия на кнопку регистрации
    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    // Метод для заполнения регистрационной формы
    public void fillRegistrationForm(RegistrationData data) {
        if (data.getGender().equalsIgnoreCase("male")) {
            click(By.id("gender-male"));
        } else {
            click(By.id("gender-female"));
        }
        type(By.id("FirstName"), data.getFirstName());
        type(By.id("LastName"), data.getLastName());
        type(By.id("Email"), data.getEmail());
        type(By.id("Password"), data.getPassword());
        type(By.id("ConfirmPassword"), data.getPassword());
    }

    // Метод для заполнения формы входа
    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    // Метод для нажатия на ссылку "Log in"
    public void clickOnLoginLink() {
        click(By.cssSelector("a[href='/login']"));
    }

    // Метод для проверки наличия кнопки "Sign Out"
    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.cssSelector("a[href='/logout']"));
    }

    // Метод для нажатия на кнопку "Log in"
    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }

    // Метод для проверки наличия сообщения об ошибке
    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }

    // Метод для проверки наличия ссылки "Log in"
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("a[href='/login']"));
    }

    // Метод для нажатия на кнопку "Sign Out"
    public void clickOnSignOutButton() {
        click(By.cssSelector("a[href='/logout']"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("a[href='/register']"));
    }

    public void submitRegistrationForm() {
        click(By.id("register-button"));
    }
}
