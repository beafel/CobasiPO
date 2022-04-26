package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Home;
import pages.Lista;
import pages.Produto;
import utils.Evidences;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConsultaProdutos {

    //Declarar Paginas
    Home home;
    Lista lista;
    Produto produto;

    //Classes de Apoio / Utils
    Evidences evidences; // referencia da classe Evidences que foi criada

    //Atributos e Objetos
    String id; // id compartilhado por todos os blocos de steps
    String nomePrint;
    String url;
    WebDriver driver;
    static String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime()) + "/";

    @Before
    public void iniciar(){
        url = "https://www.cobasi.com.br";
        System.setProperty("webdriver.chrome.driver","drivers/chrome/100/chromedriver100.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        System.out.println("Passo 0 - Preparou o setup");
        evidences = new Evidences();
        home = new Home(driver);
        lista = new Lista(driver);
        produto = new Produto(driver);
    }

    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Passo 6 - Fechou o browser");
    }

    @Dado("^que acesso o site da Cobasi \"([^\"]*)\"$")
    public void queAcessoOSiteDaCobasi(String id) throws IOException {
        this.id = id;
        driver.get(url);
        System.out.println("Passo 1 - Acessou o Site Cobasi");

        evidences.takesScreenshot(driver, pastaPrint,"Print 1 - Acessou Site Cobasi");
    }

    @Quando("^procuro por \"([^\"]*)\" e pressiono Enter$")
    public void procuroPorEPressionoEnter(String produto) throws IOException {
        home.buscarProdutoComEnter(produto);
        System.out.println("Passo 2 - Pesquisou por " + produto );
        evidences.takesScreenshot(driver, pastaPrint,"Print 2 - Pesquisou por " + produto);
    }

    @Entao("^exibe as opcoes relacionados ao \"([^\"]*)\"$")
    public void exibe_as_opcoes_relacionados_ao(String produto) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Passo 3 - Validou Titulo da Aba");
        assertEquals(produto + " - Cobasi", lista.lerTituloAba());
        System.out.println("Passo 3.1 - Validou Busca " + produto);
        assertEquals("VOCÊ BUSCOU POR \"" + produto.toUpperCase() + "\"",lista.lerResultadoParaProduto());
    }

    @Quando("^seleciono a \"([^\"]*)\" da lista$")
    public void seleciono_a_da_lista(String descricaoProduto) throws IOException, InterruptedException {
        lista.clicarNoProdutoNaLista(descricaoProduto);
        System.out.println("Passo 4 - Selecionou " + descricaoProduto);
        //Thread.sleep(2000);
        evidences.takesScreenshot(driver, pastaPrint,"Print 3 - Selecionou " + descricaoProduto);
    }

    @Entao("^verifico a marca como \"([^\"]*)\" e no valor de \"([^\"]*)\"$")
    public void verifico_a_marca_como_e_no_valor_de(String marca, String preco){
        System.out.println("Passo 5 - Validou Marca");
        assertEquals(marca,produto.lerMarca());
        System.out.println("Passo 5.1 - Validou Valor");
        assertEquals(preco,produto.lerPreco());
    }
}
