# Iniciando um Projeto Spring com cURL

A forma mais comum de iniciar um projeto Spring é através da [interface web do Spring Initializr](https://start.spring.io/).
No entanto, também é possível criar o projeto diretamente pela linha de comando usando `curl`, o que pode ser útil para automação ou scripts.

## 1. Os passos estão constado no arquivo `initial.sh`

- [Linha de comando](../settings/initial.sh)



## Gerando o projeto compactado com curl

>O comando abaixo cria um projeto Spring Boot com as seguintes configurações:

- Dependências: Web, Lombok, DevTools
- Tipo: Projeto Maven
- Linguagem: Java
- Versão Java: 17
- Versão Spring Boot: 3.5.3
- Grupo: `com.marcos.guessword`


## Como iniciar:

- `mvn compile` → Compila e baixa dependências.
- `mvn spring-boot:run` → Compila, baixa dependências e executa o app.
- `mvn package` → Gera o jar executável.