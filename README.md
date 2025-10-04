# Projeto de Automação de Testes Mobile com Appium e Java

Este projeto contém um conjunto de testes automatizados para um aplicativo móvel de e-commerce de demonstração. O objetivo é validar o fluxo completo de compra de um produto, desde a seleção até a confirmação do pedido.

---

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Framework de Automação:** Appium
* **Framework de Teste:** TestNG
* **Gestor de Dependências e Build:** Maven
* **Padrão de Projeto:** Page Object Model (POM)
* **Relatórios:** Allure Framework

---

## Pré-requisitos

Antes de executar o projeto, garanta que você tenha o seguinte software instalado e configurado em sua máquina:
* Java JDK 17
* Apache Maven
* Node.js e npm
* Appium Server 2.x (`npm install -g appium`)
* Driver UiAutomator2 do Appium (`appium driver install uiautomator2`)
* Android Studio (para o Android SDK e gerenciamento de emuladores)
* Um Emulador Android (AVD) configurado e em execução.
* Allure Commandline (para gerar os relatórios)

---

## ⚙Como Configurar o Projeto

1.  **Clone o Repositório:**
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    ```
2.  **Navegue até a Pasta:**
    ```bash
    cd meu-projeto-appium
    ```
3.  **Abra na sua IDE:**
    * Abra o projeto como um "Existing Maven Project" no IntelliJ IDEA ou Eclipse. A IDE irá baixar e configurar todas as dependências listadas no `pom.xml`.

4.  **Adicione o APK:**
    * Certifique-se de que o arquivo `Android-MyDemoAppRN.1.3.0.build-244.apk` está dentro da pasta `/apps` na raiz do projeto.

---

## ▶ Como Executar os Testes

1.  **Inicie o Servidor Appium:**
    * Abra um terminal e execute o comando:
        ```bash
        appium
        ```
    * Mantenha este terminal aberto.

2.  **Inicie o Emulador Android:**
    * Abra o Android Studio, vá em `Tools > Device Manager` e inicie o seu emulador.

3.  **Execute os Testes via Maven:**
    * Abra **outro** terminal na raiz do projeto e execute o comando:
        ```bash
        mvn clean test
        ```
    * O Maven irá compilar o código e executar a suíte de testes definida no `testng.xml`.

---

## Como Gerar e Visualizar o Relatório

Após a execução dos testes, os resultados do Allure serão gerados na pasta `target/allure-results`. Para visualizar o relatório em HTML:

1.  Execute o seguinte comando no terminal (na raiz do projeto):
    ```bash
    allure serve target/allure-results
    ```
2.  Um servidor web local será iniciado e o relatório será aberto automaticamente no seu navegador.