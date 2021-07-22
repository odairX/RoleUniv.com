# Projeto-RoleUniv.com

## roleUniversitario

* [Odair Xavier](https://github.com/odairX)

### Executando

Para executar esse projeto é necessário executar o banco de dados Derby, em seguida executar o Tomcat e então acessar o endereço `http://localhost:9090/RoleUniv.com`.

### Para iniciar o Derby

`mvn exec:java@derby-start`

### Para parar o Derby

`mvn exec:java@derby-stop`

### Para executar o Tomcat

`mvn tomcat7:run`

## Banco de Dados

Endereço para cadastrar as tabelas `http://localhost:9090/RoleUniv.com/dbclient.jsp`.

### JDBC

Abaixo estão os dados para conexão com o banco de dados Derby.

URL: `jdbc:derby://localhost:1527/eventodb`

Usuário: `app`

Senha: `app`

### Tabelas

Para a aplicação funcionar, as tabelas precisam ser criadas.

```sql
create table evento (
  codigo varchar(100),
  nome varchar(100),
  cidade varchar(100)
)
```
# RoleUniv.com
# RoleUniv.com
