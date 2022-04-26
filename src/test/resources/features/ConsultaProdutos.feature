#language: pt
#encoding: utf8

Funcionalidade: Consultar Produtos
  Como um cliente eventual, gostaria de consultar a disponibilidade
  e preço de alguns produtos que tenho interesse em adquirir

  Esquema do Cenario: Consulta Produtos no Site da Cobasi
    Dado que acesso o site da Cobasi <id>
    Quando procuro por <produto> e pressiono Enter
    Entao exibe as opcoes relacionados ao <produto>
    Quando seleciono a <descricaoProduto> da lista
    Entao verifico a marca como <marca> e no valor de <preco>

  Exemplos:
  | id  |      produto     |                 descricaoProduto                |   marca  |  preco     |
  | "1" |  "Ração Cibau"   |    "Ração Cibau Cães Adulto Raças Pequenas"     | "Cibau"  | "R$ 52,90" |
  | "2" | "Petisco Keldog" | "Bifinho Keldog Carne e Cereais Raças Pequenas" | "Keldog" | "R$ 4,10"  |