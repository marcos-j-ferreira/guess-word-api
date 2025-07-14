#!/bin/bash

# Mapeamento de todas as rotas da API, assim como suas respostas.

URL_BASE="http://localhost:8080/api/v1/words"

# -----------------------------
# Método <GET>: Verificar se a API está rodando
# -----------------------------

echo "Fazendo requisição GET para $URL_BASE..."
curl -i "$URL_BASE"   # -i inclui o status da resposta HTTP
echo -e "\n"           # nova linha para separar as saídas

# Esperado: Um simples "Hello, world"
# <status> 200 OK

# -----------------------------
# Método <POST>: Enviar um nome e receber uma resposta
# -----------------------------

POST_URL="$URL_BASE/user"
NOME="marcos"

echo "Fazendo requisição POST para $POST_URL com nome='$NOME'..."
curl -i -X POST "$POST_URL" \
     -H "Content-Type: application/json" \
     -d "{\"name\":\"$NOME\"}"
echo -e "\n"

# Esperado: Alguma resposta com base no nome enviado
# <status> 201 Created ou similar

