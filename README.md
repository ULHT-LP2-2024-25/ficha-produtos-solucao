# Solução da ficha loja/produtos

Solução que respeita as boas práticas da programação orientada a objetos: 
* a lógica está toda no `Produto` e na `Loja`
* o `Main` chama métodos da `Loja` em vez de alterar diretamente o seu estado
* por sua vez a `Loja` chama métodos do `Produto` em vez de alterar diretamento o seu estado (tudo o que tenha a ver com o `stock`)
