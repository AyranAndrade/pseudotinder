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
