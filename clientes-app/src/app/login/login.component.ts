import { AuthService } from './../auth.service';
import { Usuario } from './usuario';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  cadastrando: boolean;
  mensagemSucesso: string;
  errors: string [];

  constructor(
    private router: Router,
    private authService: AuthService
    ) { }

  onSubmit(){
    this.router.navigate(['/home']);
  }

  preparaCadastrar(event){
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }

  cadastrar(){
    const usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;
    this.authService.salvar(usuario)
      .subscribe(response => {
        this.mensagemSucesso = 'Cadastro realizado com sucesso! Efetue o Login';
        this.cadastrando = false;
        this.username = '';
        this.password = '';
        this.errors = [];
      }, errorResponse => {
        this.mensagemSucesso = null;
        this.errors = errorResponse.error.errors;
        console.log(this.errors);
      });
  }
}
