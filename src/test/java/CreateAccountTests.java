import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {

        // Открыть страницу регистрации
        click(By.cssSelector("a[href='/register']"));

        // Ввести данные пользователя
        click(By.id("gender-male"));
        type(By.id("FirstName"), "Vladimir");
        type(By.id("LastName"), "Romaikin");
        String email = "Vlaadimir_Romaikin" + System.currentTimeMillis() + "@example.com";
        type(By.id("Email"), email);
        type(By.id("Password"), "Password123!");
        type(By.id("ConfirmPassword"), "Password123!");

        // Отправить форму
        click(By.id("register-button"));

        // Проверить, что регистрация прошла успешно
        Assert.assertTrue(isElementPresent(By.cssSelector(".result")), "Success message is not present");
        Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(),
                "Your registration completed",
                "Registration failed");

        // Дополнительно: проверить, что пользователь вошел в систему
        Assert.assertTrue(isElementPresent(By.cssSelector("a.account")), "Account link is not present");
        Assert.assertEquals(driver.findElement(By.cssSelector("a.account")).getText(), email, "Logged-in user mismatch");
    }
}

