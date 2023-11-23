package org.example;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import metodos.RealizaCadastroLogin;

import java.io.IOException;
import java.util.ArrayList;



public class MyStepdefs {
    RealizaCadastroLogin realizaCadastroLogin = new RealizaCadastroLogin();

    @Dado("que realizo o cadastro na plataforma da ForwardCar com massa de MySQL")
    public void queRealizoOCadastroNaPlataformaDaForwardCarComMassaDeMySQL()  throws IOException {
        realizaCadastroLogin.cadastrarUsuario();
    }

    @Entao("sistema me retorna statusCode {int}")
    public void sistemaMeRetornaStatusCode(int statusCode) throws IOException {
        ArrayList<Response> responses = realizaCadastroLogin.cadastroDeUsuario();
        for (int i = 0; i < responses.size(); i++) {
            responses.get(i).then().log().all().assertThat().statusCode(statusCode);
        }
    }
    @Quando("que realizo o cadastro na plataforma da ForwardCar com username ja existente")
    public void queRealizoOCadastroNaPlataformaDaForwardCarComUsernameJaExistente() {
        realizaCadastroLogin.cadastrarUsuario();
    }
    @Entao("sistema nao realiza cadastro e retorna statusCode {int}")
    public void sistemaNaoRealizaCadastroERetornaStatusCode(int statusCode) throws IOException{
        ArrayList<Response> responses = realizaCadastroLogin.cadastroDeUsuario();
        for (int i = 0; i < responses.size(); i++) {
            responses.get(i).then().log().all().assertThat().statusCode(statusCode);
        }
    }
    @Dado("que realizo login com usuario cadastrado")
    public void queRealizoLoginComUsuarioCadastrado() throws IOException {
        realizaCadastroLogin.LoginDeUsuario();
    }

    @Entao("o sistema me retorna status code {int}")
    public void oSistemaMeRetornaStatusCode(int statusCode) throws IOException {
        ArrayList<Response> responses = realizaCadastroLogin.LoginDeUsuario();
        for (int i = 0; i < responses.size(); i++) {
            responses.get(0).then().log().all().assertThat().statusCode(statusCode);
        }
    }

    @Dado("que quero cadastrar um novo veículo e preencho os seguintes campos")
    public void queQueroCadastrarUmNovoVeículoEPreenchoOsSeguintesCampos() throws IOException{
        AppTest.cadastrarVeiculo();
    }

    @Entao("sistema me retorna o VIN do modelo que cadastrei")
    public void sistemaMeRetornaOVINDoModeloQueCadastrei() throws IOException{
        AppTest.cadastrarNovoVeiculoForwardCar();
    }

    @Dado("que cadastrei um novo veiculo na ForwardCar")
    public void queCadastreiUmNovoVeiculoNaForwardCar() throws IOException{
        AppTest.cadastrarVeiculo();
    }
    @Entao("sistema me retorna VIN do carro cadastrado no GET")
    public void sistemaMeRetornaVINDoCarroCadastradoNoGET() throws IOException{
        AppTest.consultarNovoVeiculoCadastradoComGet();
    }
}