package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    //modo protegido para esperar que Selenium fique livre para outra classe usar
    protected WebDriver driver; //Seleniun interno

    //interface da classe "PageObject" tem o mesmo nome da classe
    public PageObject(WebDriver driver) { //Selenium externo
        this.driver = driver; // Selenium interno está recebendo o Selenium externo
        PageFactory.initElements(driver, this); //inicializar o Selenium "zerado"
    }
}
