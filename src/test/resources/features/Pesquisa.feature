#language: pt

  @pesquisa

  Funcionalidade: : Pesquisa de Produto
    Eu como usuário,
    quero realizar uma pesquisa de um produto,
    para poder realizar a compra dele no aplicativo.

    Esquema do Cenario: Realizar a pesquisa do produto no app
        Dado que não quero realizar o login
      Quando clico na barra de pesquisa
           E digito o <produto> a ser pesquisado
           E clico no produto para seleciona-lo
       Então verifico se os dados dele estão corretos

      Exemplos:
        |           produto            |
        |       Royal Canin Maxi       |
