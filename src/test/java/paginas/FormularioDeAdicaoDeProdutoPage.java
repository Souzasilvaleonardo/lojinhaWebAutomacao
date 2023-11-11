package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto(String produtoNome) {
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarValorDoProduto(String produtoValor) {
        navegador.findElement(By.id("produtovalor")).sendKeys(produtoValor);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarACorDoProduto(String produtoCor) {
        navegador.findElement(By.id("produtocores")).sendKeys(produtoCor);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoDeProdutoPage submeterFormularioDeAdicaoComSucesso() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new FormularioDeEdicaoDeProdutoPage(navegador);
    }

}
