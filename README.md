# Lojinha Web Automação

Este repositório contém testes automatizados realizados no módulo de produtos de uma aplicação web usando Java e Selenium WebDriver.

## Tecnologias Utilizadas

- Java
- Selenium
- WebDriver
- JUnit
- Maven

# Pré- requisito

Certifique-se de ter o WebDriver do Chrome configurado. Este projeto utiliza o WebDriverManager para facilitar a configuração.

*Exemplo:

WebDriverManager.chromedriver().setup();*


## Configuração do Ambiente

Antes de executar os testes, é necessário configurar o ambiente. O método `beforeEach` é responsável por iniciar o navegador, maximizá-lo e navegar até a página da aplicação.

Exemplo:

*@BeforeEach
public void beforeEach() {
// Configurar o WebDriver e abrir o navegador
}*



## Encerramento do Ambiente

O método `afterEach` é responsável por encerrar o navegador após cada teste.

*Exemplo:

@AfterEach
public void afterEach() {
// Encerrar o navegador
}*



## Estrutura do Projeto

Você pode renomear o arquivo atual clicando no nome do arquivo na barra de navegação ou clicando no botão ** Renomear ** no explorador de arquivos.

-   `modulos.produtos`: Contém os testes automatizados.
-   `paginas`: Contém classes que representam páginas da aplicação.