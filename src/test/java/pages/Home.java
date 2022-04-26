package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends PageObject {

    //Atributos / Elementos da Pagina
    @FindBy(css = "input.fulltext-search-box.ui-autocomplete-input.neemu-search-field")
    private WebElement busca;

    @FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[1]/fieldset[1]/input[3]")
    private WebElement lupa;

    //Construtor Obrigatorio
    public Home(WebDriver driver) {
        super(driver);
    }

    public void buscarProdutoComEnter(String produto){
        busca.clear();
        busca.sendKeys(produto + Keys.ENTER);
    }
}
