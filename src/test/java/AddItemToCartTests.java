import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @Test
    public void addItemToCartTest() {
        // Залогинимся в систему
        String email = "existinguser" + System.currentTimeMillis() + "@example.com";
        String password = "Password123!";
        login(email, password);

        // Выбираем товар
        selectProductAndAddToCart(2); // Добавление второго товара

        // Проверяем успешное добавление товара в корзину
        Assert.assertTrue(isElementPresent(By.cssSelector(".bar-notification.success")),
                "Success notification is not present");
        String successMessage = driver.findElement(By.cssSelector(".bar-notification.success")).getText();
        Assert.assertTrue(successMessage.contains("The product has been added to your shopping cart"),
                "Product was not added to cart successfully");
    }

    private void login(String email, String password) {
        // Переход к странице логина
        click(By.cssSelector("a[href='/login']"));

        // Вводим данные для логина
        type(By.id("Email"), email);
        type(By.id("Password"), password);

        // Нажимаем кнопку "Log in"
        click(By.cssSelector("input[value='Log in']"));

        // Проверяем успешность логина
        Assert.assertTrue(isElementPresent(By.cssSelector("a.account")), "Account link is not present");
        Assert.assertEquals(driver.findElement(By.cssSelector("a.account")).getText(), email, "Logged-in user mismatch");
    }

    private void selectProductAndAddToCart(int productIndex) {
        // Добавляем товар по индексу
        String productSelector = ".product-grid .item-box:nth-of-type(" + productIndex + ") input[value='Add to cart']";
        click(By.cssSelector(productSelector));
    }
}
