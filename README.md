## O projeto ##

Este projeto é uma imitação simplificada do Tinder para a web. A primeira página é uma tela onde a pessoa acessa o seu perfil, caso já o tenha, ou vai para uma página de cadastro. Por ser simples, nem o cadastro nem o acesso é feito com senha.  Dadas as informações no registro, como nome e fotos, ele é levado a uma página onde pode visualizar o perfil de outras pessoas. abaixo, ele terá um botão de like e um de dislike. O primeiro é caso a pessoa tenha interesse, o segundo é caso não tenha interesse. Se houver um match (ambas as pessoas se deram like), a pessoa terá a possibilidade de mandar mensagens apenas textuais a seu(ua) pretendente, marcando assim um encontro para a vida real.


## Antes de começar ##

1. Instale o Maven;
2. Instale o Mysql;

## Para olhar ##

1. Execute os passos descritos na seção "Antes de começar";
2. Acesse o arquivo ```src/main/resources/db/migration/application-development.properties``` e coloque o seu nome de usuário e senha que foram cadastrados no Mysql;
3. Crie um banco de dados no Mysql chamado ```pseudotinder```;
4. Compile com ```mvn package -Dspring.profiles.active=development```;
5. Execute com ```java -jar -Dspring.profiles.active=development NOME_DO_ARQUIVO_JAR.jar```.

## Para testar ##

1. Execute os passos descritos na seção "Antes de começar";
2. Execute ```mvn test -Dspring.profiles.active=test```. Este comando vai executar os testes unitários e de integração, só que estes últimos serão feitos usando um banco de dados em memória, o HSQLDB.

## Para desenvolver ##

1. Execute os passos descritos na seção "Antes de começar";
2. Acesse o arquivo ```src/main/resources/db/migration/application-development.properties``` e coloque o seu nome de usuário e senha que foram cadastrados no Mysql;
3. Crie um banco de dados no Mysql chamado ```pseudotinder```;
4. Execute o comando ```mvn spring-boot:run -Dspring-boot.run.profiles=development```. ele se encarregará de baixar todas as dependências e deixar o projeto pronto. Basta acessar o endereço
```http://localhost:8080```;
5. Abra um outro terminal e execute ```gulp watch```. Este comando vai fazer com que qualquer
alteração num arquivo Javascript ou CSS seja carregado automaticamente.


## O Algoritmo ##


Para escolher qual será o próximo pretendente a ser exibido utilizo o algoritmo Elo Score. Aqui está um bom [link](https://www.hackerearth.com/blog/algorithms/elo-rating-system-common-link-facemash-chess/) sobre este assunto. Todas as pessoas que se cadastram começam com uma pontuação padrão. Quando esta dá like em outra pessoa, alguns pontos são retirados dela e dados à pessoa que recebeu o like. Quando esta dá dislike, alguns pontos são retirados da pessoa que recebeu dislike e dados a pessoa que deu dislike. Desta maneira, pessoas que recebem muitos likes terão uma pontuação maior e são mais desejáveis (é este o termo que o Tinder usa) e pessoas que recebem muitos dislikes terão uma pontuação menor. Então, para cada pessoa será exibida outras pessoas que tem uma pontuação semelhante ou que deram like no usuário. Esta última condição serve para o usuário olhar o perfil das pessoas que deram like nele e saber se está interessado ou não.


## Tecnologias usadas ##


* Spring Boot;
* Spring MVC;
* Spring Data JPA:
* Spring Developer Tools;
* JUnit 4 integrado ao Spring
* Spring Security; 
* MySQL (Banco de dados para ambiente de desenvolvimento);
* HSQLDB (Banco de dados para ambiente de testes de integração);
* Thymeleaf (Template engine);
* Flyway (Migração de banco de dados);
* NodeJS e NPM (Para baixar e instalar automaticamente dependências do front-end, como o Bootstrap);
* Gulp (Para minimizar os arquivos CSS e JS entre outras tarefas);


## Apêndice ##

* Maven pode ser instalado através do comando ```sudo apt-get install maven```;
* Caso o Spring DevTools não estivesse no pom.xml, o comando para executar o projeto seria ```mvn spring-boot:run -Dspring.profiles.active=development```;
* Todo o ambiente de teste foi feito para ser executado com o comando 
```mvn test -Dspring.profiles.active=test```, que invoca um ambiente de teste. Ao executar os testes usando outros comandos como ```mvn test -Dspring.profiles.active=development```, 
ou simplesmente ```mvn test```, estes irão ser executados utilizando um ambiente inapropriado, e portanto, erros irão acontecer, o que é natural, uma vez que o projeto nunca foi pensado para funcionar desta forma;
* Para atualizar as dependências descritas no package.json, você deve:
  * Instalar o NPM Check Updates: ```npm install -g npm-check-updates```;
  * Executá-lo: ```ncu -u```;
  * Instalar as novas dependências: ```npm install```.
