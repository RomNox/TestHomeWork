import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        // Создаем объект с данными для регистрации
        RegistrationData registrationData = new RegistrationData(
                "male",
                "Vladimir",
                "Romaikin",
                "Vladimir_Romaikin" + System.currentTimeMillis() + "@example.com",
                "Password123!"
        );

        // Переходим на страницу регистрации
        click(By.cssSelector("a[href='/register']"));

        // Заполняем форму регистрации
        fillRegistrationForm(registrationData);

        // Нажимаем кнопку регистрации
        click(By.id("register-button"));

        // Проверяем успешность регистрации
        Assert.assertTrue(isElementPresent(By.cssSelector(".result")), "Success message is not present");
        Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(),
                "Your registration completed",
                "Registration failed");

        // Проверяем, что пользователь вошел
        Assert.assertTrue(isElementPresent(By.cssSelector("a.account")), "Account link is not present");
        Assert.assertEquals(driver.findElement(By.cssSelector("a.account")).getText(), registrationData.getEmail(), "Logged-in user mismatch");
    }

    @Test
    public void newUserRegistrationWithDifferentGenderTest() {
        // Регистрация женского пользователя
        RegistrationData registrationData = new RegistrationData(
                "female",
                "Irina",
                "Baker",
                "Irinabaker" + System.currentTimeMillis() + "@example.com",
                "Password456!"
        );

        // Переход и заполнение формы
        click(By.cssSelector("a[href='/register']"));
        fillRegistrationForm(registrationData);
        click(By.id("register-button"));

        // Проверка успешности
        Assert.assertTrue(isElementPresent(By.cssSelector(".result")), "Success message is not present");
        Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(),
                "Your registration completed",
                "Registration failed");
    }

    // Общий метод заполнения формы регистрации
    private void fillRegistrationForm(RegistrationData data) {
        if (data.getGender().equals("male")) {
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
}
