package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Produto extends PageObject {

    @FindBy(css = "a.styles__BrandLink-sc-1rue5eb-14.iEjUzW")
    private WebElement marca;

    @FindBy(css = "div.styles__WrapperProductPrice-sc-1nhsrae-7.gkMznb")
    private WebElement preco;

    public Produto(WebDriver driver) {
        super(driver);
    }

    public String lerMarca(){
        return marca.getText();
    }

    public String lerPreco(){
        return preco.getText();
    }
}
