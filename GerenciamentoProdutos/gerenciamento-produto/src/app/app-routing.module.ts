import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutoComponent } from './produto/produto.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { FormsModule }   from '@angular/forms';

const routes: Routes = [

  { path:'produto', component: ProdutoComponent},
  { path: '', component: LoginComponent },
  { path: 'logout', component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
