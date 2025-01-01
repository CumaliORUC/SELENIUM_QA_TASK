package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class ReuseableMethods {

    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        } catch (Exception e) {
            System.out.println("Error while scrolling to element: " + e.getMessage());
        }
    }

    public static void switchToNewWindow(WebDriver driver) {
        // Get the current window handle
        String currentWindow = driver.getWindowHandle();

        // Get all open window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the last opened window
        for (String handle : allWindows) {
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);
            }
        }
    }

    public static void closeAndSwitchToMainWindow(WebDriver driver, String mainWindowHandle) {
        driver.close(); // Close the current window
        driver.switchTo().window(mainWindowHandle); // Switch back to the main window
    }
}
