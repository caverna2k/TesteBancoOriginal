import { HttpClient, HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produto } from '../_model/produto';
import {BehaviorSubject} from 'rxjs';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  dataChange: BehaviorSubject<Produto[]> = new BehaviorSubject<Produto[]>([]);

  constructor(
    private httpClient:HttpClient
  ) { }

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };


  asdf: Produto[]= [];

  public listarProdutos(numeroPagina, tamanhoPagina) {
    console.log("listagem call")

    let any = this.httpClient.get("http://localhost:8080/v1/produtos/listar" + "/"+ numeroPagina + "/" + tamanhoPagina ).pipe(
      map(this.extractData));

    return any;

  };

}
