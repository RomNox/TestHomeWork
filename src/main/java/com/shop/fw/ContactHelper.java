package com.shop.fw;

import com.shop.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    // Метод для сохранения контактной информации
    public void clickOnSaveButton() {
        click(By.cssSelector(".save-button")); //Тут я не уверен
    }

    // Метод для заполнения контактной формы
    public void fillContactForm(Contact contact) {
        type(By.id("Name"), contact.getName());
        type(By.id("LastName"), contact.getLastName());
        type(By.id("Phone"), contact.getPhone());
        type(By.id("Email"), contact.getEmail());
        type(By.id("Address"), contact.getAddress());
        type(By.id("Description"), contact.getDescription());
    }

    // Метод для перехода к форме добавления нового контакта
    public void clickOnAddContactLink() {
        click(By.cssSelector("[href='/add-contact']")); // Тут я тоже не уверен
    }

    // Метод для проверки, что контакт добавлен
    public boolean isContactAdded(String name) {
        List<WebElement> contacts = driver.findElements(By.cssSelector(".contact-name"));
        for (WebElement element : contacts) {
            if (element.getText().contains(name)) {
                return true;
            }
        }
        return false;
    }

    // Метод для удаления контакта
    public void deleteContact() {
        click(By.cssSelector(".contact-item")); // Нажать на контакт
        click(By.xpath("//button[.='Remove']")); // Нажать "Удалить"
    }

    // Метод для получения количества контактов
    public int getContactCount() {
        if (isElementPresent(By.cssSelector(".contact-item"))) {
            return driver.findElements(By.cssSelector(".contact-item")).size();
        }
        return 0;
    }
}
