package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Evidences {

    // método para tirar print
    public void takesScreenshot(WebDriver driver, String pastaPrint, String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Cenario por pasta
        FileUtils.copyFile(foto,new File(pastaPrint + "Cenario/" + nomePrint + ".png"));
        // Cenario no nome do print
        FileUtils.copyFile(foto,new File(pastaPrint + nomePrint + ".png"));
    }
}
