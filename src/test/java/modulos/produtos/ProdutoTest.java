package modulos.produtos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web no Modulo de Produtos")
public class ProdutoTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        //Abrir o navegador
        WebDriverManager.chromedriver().setup();
        this.navegador = new ChromeDriver();

        this.navegador.manage().window().maximize();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // Navegar para a página da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web-bugada/v2/");
    }

    @Test
    @DisplayName("Nao e permitido resgistrar um produto igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {


        // Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormilarioDeAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("000")
                .informarACorDoProduto("Preto")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Nao e permitido resgistrar um produto maior que 7.000")
    public void testNaoEPermitidoRegistrarProdutoComValormaiorque7k() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormilarioDeAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("700001")
                .informarACorDoProduto("Preto")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Conseguir adcionar produtos que estejam no limite de 0,01")
    public void testAdcionarProdutosQueEstejamNaFaixaDeUmCentavos() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormilarioDeAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("001")
                .informarACorDoProduto("Preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @Test
    @DisplayName("Conseguir adcionar produtos que estejam no limite de 7.000")
    public void testAdcionarProdutosQueEstejamNaFaixaDeSetMilReais() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormilarioDeAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("700000")
                .informarACorDoProduto("Cinza")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @AfterEach
    public void afterEach() {

        navegador.quit();
    }

}
