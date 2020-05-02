import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login = '';
  senha = '';
  erroLogin = false;


  constructor(private router: Router,
    private loginservice: AuthService) { }

  ngOnInit(): void {
  }

  checkLogin() {
    (this.loginservice.authenticate(this.login, this.senha).subscribe(
      data => {
        this.router.navigate(['produto'])
        this.erroLogin = false
      },
      error => {
        this.erroLogin = true

      }
    )
    );

  }

}
