import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from '../_model/produto';
import { ProdutoService } from '../service/produto.service';
import { map } from "rxjs/operators"

import {BehaviorSubject, fromEvent, merge, Observable} from 'rxjs';


@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {





  public produtos :any = [];

  ocorreuErro = false;

  constructor(
    private produtoService: ProdutoService,private router: Router,
  ) {


  }

    ngOnInit(): void {
    this.listarProdutos(0,10);
    console.log(this.produtos)
  }

  inativarProduto(produto : Produto):void{

  }

  listarProdutos(numeroPagina, tamanhoPagina) : void {

    this.produtos = [];

    this.produtoService.listarProdutos(numeroPagina,tamanhoPagina).subscribe((data: {}) => {
      console.log(data);
      this.produtos = data['content'];
      console.log(this.produtos);
    });
  }
}
