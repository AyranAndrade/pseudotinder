O objetivo deste projeto é testar o meu conhecimento.

Eu quero chegar no ponto em que eu uso Jquery e Bootstrap instalados via NPM. O Gulp vai minificar os meus arquivos javascript e css.
O projeto deve ler das variáveis de ambiente tudo que ele precisa, como a senha do banco de dados, por exemplo.
Assim que eu faço um pull request para o Github, o Jenkins vai construir o projeto, rodar testes de integração e unitários. Se estiver OK, deixa passar.
Quando eu fizer o merge para a branch master, o Jenkins vai automaticamente levantar um ambiente de produção todo pronto para mim. 
Tudo isso na minha máquina local.
Usar também o devtools do Spring, para eu ter hot reloading do meu código.

## Como instalar e executar o projeto ##

1. Instale o Maven através do comando ```sudo apt-get install maven```;
2. Instale o Mysql;
3. Acesse o arquivo ```src/main/resources/db/migration/application-development.properties``` e coloque o seu nome de usuário e senha;
4. Crie um banco de dados no Mysql chamado ```pseudotinder```;
5. Entre na pasta do projeto e execute ```mvn spring-boot:run -Dspring.profiles.active=development``` para rodar o projeto no ambiente de desenvolvimento. O Maven, seus plugins e o Spring Boot devem se encarregar de baixar e configurar todas as dependências.
6. O projeto estará disponível em http://localhost:8080
7. (Opcional) Se o Spring Boot Devtools estiver no pom.xml, o comando listado na linha 5 não funcionará e precisará ser substituído por ```mvn spring-boot:run -Dspring-boot.run.profiles=development```.

## Como compilar o projeto e executar o jar resultante ##

1. Compile com ```mvn package -Dspring.profiles.active=development``` (Para ambiente de desenvolvimento)
2. Execute com ```java -jar -Dspring.profiles.active=development NOME_DO_ARQUIVO_JAR.jar```

## Como rodar todos os testes do projeto ##

Execute ```mvn test -Dspring.profiles.active=test```. Este comando vai executar os testes unitários e de integração, só que estes últimos serão feitos usando um banco de dados em memória, o HSQLDB.
**AVISO:** Todo o ambiente de teste foi feito para ser executado com o comando acima, que invoca um perfil de teste. Ao executar os testes usando outros comandos como ```mvn test -Dspring.profiles.active=test``` ou ```mvn test``` erros irão acontecer já que o projeto nunca foi pensado para funcionar desta forma.

## Como atualizar as dependências descritas no package.json para as suas últimas versões ##

1. Instale o NPM Check Updates: ```npm install -g npm-check-updates```
2. Execute-o: ```ncu -u```
3. Instale as novas dependências: ```npm install``` 