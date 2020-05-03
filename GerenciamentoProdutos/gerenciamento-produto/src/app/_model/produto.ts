export class Produto {

  codigoProduto:String;
  descricao:String;
  valor:DoubleRange;
  dataCriacao:Date;
  ativo:boolean;

  constructor(produto: Produto) {
      this.codigoProduto = produto.codigoProduto;
      this.descricao = produto.descricao;
      this.valor = produto.valor;
      this.dataCriacao = produto.dataCriacao;
      this.ativo = produto.ativo;
  }

}
