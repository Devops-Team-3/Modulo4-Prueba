package com.healthtrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class UserFlowUITest {

    private final String testUrl = "http://localhost:8080/index.html";

    private void runUITest(WebDriver driver) throws Exception {
        try {
            waitForServer();
            driver.get(testUrl);
            String title = driver.getTitle();
            System.out.println("✅ Título de la página: " + title);
        } finally {
            driver.quit(); // Aquí dentro, donde driver está definido y accesible
        }
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        runUITest(driver);
    }

    @Test
    public void testWithFirefox() throws Exception {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        runUITest(driver);
    }
}
