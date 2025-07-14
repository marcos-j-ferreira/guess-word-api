#!/bin/bash

# É mais comum iniciar um projeto via Spring Initializr pela interface web:
# https://start.spring.io
# No entanto, este script oferece uma alternativa usando curl para gerar o projeto automaticamente.

# Verifica a versão do curl
curl --version

# Gera o projeto Spring Boot com as dependências necessárias.
# O arquivo será baixado compactado (.zip)

curl https://start.spring.io/starter.zip \
  -d dependencies=web,lombok,devtools \
  -d type=maven-project \
  -d language=java \
  -d groupId=com.marcos \
  -d artifactId=word \
  -d name=word \
  -d description="A simple word guessing game." \
  -d packageName=com.marcos.word \
  -d javaVersion=17 \
  -d bootVersion=3.5.3 \
  -o word.zip

# Extrai o conteúdo do projeto e acessa a pasta gerada

unzip word.zip
cd word
