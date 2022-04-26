package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lista extends PageObject {

    //Resultados Encontrados
    @FindBy(xpath = "//body/div[7]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[3]")
    private WebElement resultadosParaProduto;

    //Nome da Aba
    //A aba é do navegador, nao precisa mapear

    public Lista(WebDriver driver) {
        super(driver);
    }

    //Ler o que está na Linha do Resultado
    //Funcao (que retorna resultado)
    public String lerResultadoParaProduto() { // Ler o que esta na linha do Resultado
        return resultadosParaProduto.getText();
    }

    // Ler o titulo da Aba
    public String lerTituloAba() {
        return driver.getTitle();
    }

    // Clicar no produto escolhido
    public void clicarNoProdutoNaLista(String produtoDescricao){
        WebElement nomeDoProduto = driver.findElement(By.xpath("//a[contains(text(),'" + produtoDescricao + "')]"));
        nomeDoProduto.click();
    }
}
