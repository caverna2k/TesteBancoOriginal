import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatInputModule } from "@angular/material/input";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatSortModule } from "@angular/material/sort";
import {MatTableModule } from "@angular/material/table";
import {  MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { BasicAuthInterceptorService } from './service/basic-auth-interceptor.service';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProdutoComponent } from './produto/produto.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    ProdutoComponent,
    LoginComponent,
    LogoutComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    BrowserAnimationsModule,

  ],
  providers: [
    {
    provide:HTTP_INTERCEPTORS, useClass:BasicAuthInterceptorService, multi:true
    }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
