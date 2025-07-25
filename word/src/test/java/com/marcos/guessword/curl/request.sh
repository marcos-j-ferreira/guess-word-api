#!/bin/bash

# Mapeamento de todas as rotas da API, assim como suas respostas.

URL_BASE="http://localhost:8080/api/v1/words"

# -----------------------------
# Método <GET>: Verificar se a API está rodando
# Esta foi feita com o objetivo de ser didática, servindo como material para estudo.
# -----------------------------

function print(){
    echo -e " ========================================================="
}

# -- Limpar terminal
clear 

echo "Fazendo requisição GET para $URL_BASE..."
curl -i "$URL_BASE"   # -i inclui o status da resposta HTTP
echo -e "\n"           # nova linha para separar as saídas

# Esperado: Um simples "Hello, world"
# <status> 200 OK

# -----------------------------
# Método <POST>: Enviar um nome e receber uma resposta
# Esta foi feita com o objetivo de ser didática, servindo como material para estudo.
# -----------------------------
print
echo -e "\n"

POST_URL="$URL_BASE/user"
NOME="Luiz"

echo "Fazendo requisição POST para $POST_URL com nome='$NOME'..."
curl -i -X POST "$POST_URL" \
     -H "Content-Type: application/json" \
     -d "{\"name\":\"$NOME\"}"
echo -e "\n"

# Esperado: Alguma resposta com base no nome enviado
# <status> 201 Created ou similar



# Proxima rota: 
#/user?user=marcosJuniorLeme
#Envia um nome, e recebe uma resposta