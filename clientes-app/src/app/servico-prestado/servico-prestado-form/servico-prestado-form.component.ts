import { ServicoPrestado } from './../servicoPrestado';
import { ClientesService } from './../../clientes.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/clientes/cliente';
import { ServicoPrestadoService } from 'src/app/servico-prestado.service';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[];
  servico: ServicoPrestado;
  success: boolean = false;
  errors: String [];

  constructor(
    private clientesService: ClientesService,
    private servicoPrestado: ServicoPrestadoService
    ) {
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {

    this.clientesService.getClientes()
    .subscribe(response => {
      this.clientes = response;
    });
  }

  onSubmit(){

    this.servicoPrestado.salvar(this.servico)
    .subscribe(response => {
      this.success = true;
      this.errors = [];
      this.servico = new ServicoPrestado();

    }, errorsResponse => {
      this.success = false;
      this.errors = errorsResponse.error.errors;
    });
  }
}
