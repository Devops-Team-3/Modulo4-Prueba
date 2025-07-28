package com.healthtrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFlowUITest {

    private final String testUrl = "http://localhost:8080/index.html";

    public void runUITest(WebDriver driver) throws Exception {
        waitForServer();
        driver.get(testUrl);
        String title = driver.getTitle();
        System.out.println("✅ Título de la página: " + title);
        driver.quit();
    }

    private void waitForServer() {
        System.out.println("⏳ Esperando que el servidor web responda...");
        Awaitility.await()
                .atMost(Duration.ofSeconds(30))
                .pollInterval(Duration.ofSeconds(2))
                .until(() -> {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) new URL(testUrl).openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();
                        return connection.getResponseCode() == 200;
                    } catch (Exception e) {
                        return false;
                    }
                });
        System.out.println("✅ Servidor web disponible.");
    }

    @Test
    public void testWithChrome() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        runUITest(driver);
    }

    @Test
    public void testWithFirefox() throws Exception {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        runUITest(driver);
    }
}
