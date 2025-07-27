package com.healthtrack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UserFlowUITest {

    private static final String URL = "http://localhost:8080/index.html";

    @Test
    public void testWithChrome() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        runUITest(driver, "chrome");
    }

    @Test
    public void testWithFirefox() throws IOException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        runUITest(driver, "firefox");
    }

    private void runUITest(WebDriver driver, String browser) throws IOException {
        try {
            driver.get(URL);

            WebElement titulo = driver.findElement(By.id("titulo"));
            WebElement boton = driver.findElement(By.tagName("button"));

            boolean preCond = titulo.getText().equals("Bienvenido a HealthTrack");
            boton.click();
            boolean postCond = titulo.getText().equals("Peso actualizado");

            // Guardar resultado en HTML simple
            File dir = new File("target/selenium-reports/" + browser);
            dir.mkdirs();
            try (FileWriter writer = new FileWriter(new File(dir, "report.html"))) {
                writer.write("<html><body>");
                writer.write("<h2>Resultado Selenium (" + browser + ")</h2>");
                writer.write("<p>Antes del click: " + preCond + "</p>");
                writer.write("<p>Después del click: " + postCond + "</p>");
                writer.write("</body></html>");
            }

            assertTrue(preCond && postCond, "Validaciones de flujo UI fallidas");

        } finally {
            driver.quit();
        }
    }
}
