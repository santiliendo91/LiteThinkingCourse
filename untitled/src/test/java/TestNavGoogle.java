import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestNavGoogle {

    private WebDriver driver;
    private WebDriver driver;
    @BeforeEach
    public void setUpDriver(){
        //Defino la ruta de los recursos y chromedriver
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        //start chromeDriver
        driver = new ChromeDriver();
    }
    @AfterEach
    public void tearDown(){
        //close browser
        driver.quit();
    }

    @Test
    //open google page
    public void testGoogleSearch() throws InterruptedException {
        //abro la pagina de google
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //lleno el campo buscar y uso la tecla "Enter"
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // 10-second timeout
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id]")));
        driver.findElement(By.xpath("//textarea[@id]")).sendKeys("Selenium"+Keys.ENTER);
        //valido que la palabra selenium esta activa dentro los resultados de la busqueda.
        driver.findElement(By.xpath("//h3[contains(text(),\"Selenium\")]")).isEnabled();
        assert driver.findElement(By.xpath("//h3[contains(text(),\"Selenium\")]")).isDisplayed();
    }

    @Test
    public void TestLiteThk() throws InterruptedException {
        driver.get("https://colorlib.com/polygon/metis/form-general.html");
        //search element by ID
        driver.findElement(By.id("text1"));
        //check that element by ID is displayed
        driver.findElement(By.id("text1")).isEnabled();
        //search element By xpath
        driver.findElement(By.xpath("//input[@value='disabled']"));
        //check that element by xpath is displayed
        driver.findElement(By.xpath("//input[@value='disabled']")).isEnabled();
        //search element By xpath
        driver.findElement(By.xpath("//img[@src=\"assets/img/logo.png\"]"));
        //check that element by xpath is displayed
        driver.findElement(By.xpath("//img[@src=\"assets/img/logo.png\"]")).isEnabled();
        //search element by ID
        driver.findElement(By.id("pass1"));
        //check that element by ID is displayed
        driver.findElement(By.id("pass1")).isEnabled();
        driver.findElement(By.xpath("//input[@data-default=\"add a tag\"]"));
        //check that element by xpath is displayed
        driver.findElement(By.xpath("//input[@data-default=\"add a tag\"]")).isEnabled();
        //added a console message to know if test passed.
        System.out.println("passed: encontró todos los elementos");
        // Define dropdown selection
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(2);

    }

    @Test
    public void testLab2part1() {
        driver.get("https://colorlib.com/polygon/metis/form-general.html");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // Click on the  right container
        WebElement chosenContainer = driver.findElement(By.xpath("//div/a[@class='chosen-single']"));
        chosenContainer.click();
        //click on the search textfield
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]/div/div/div/div[@class='chosen-search']")));
        option.click();
        //send "Giant Panda" to select value.
        driver.findElement(By.xpath("//div[7]/div/div/div/div[@class='chosen-search']/input")).sendKeys("Giant Panda"+Keys.ENTER);
    }

    @Test
    public void testLab2part2() {
        driver.get("https://colorlib.com/polygon/metis/form-general.html");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // Click on the  right container
        WebElement chosenContainer = driver.findElement(By.xpath("//div[12]/div/div/ul[@class='chosen-choices']"));
        chosenContainer.click();
        //click on the search textfield
        WebElement chosenOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[12]/div/div/div/ul/li[7]")));
        chosenOption.click();
    }

}
