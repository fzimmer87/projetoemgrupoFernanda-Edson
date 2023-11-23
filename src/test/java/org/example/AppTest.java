package org.example;
import AtributoJson.RespostaAtributoJson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import AtributoJson.AtributosJson;
import org.json.JSONObject;
import org.junit.Assert;
import utils.LerProperties;

import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class AppTest {
    public static Response novoCadastro(String corpoRegistro) throws IOException {
        LerProperties manipulador = new LerProperties();
        return given()
                .contentType(ContentType.JSON)
                .body(corpoRegistro)
                .when()
                .post(manipulador.getRegister())
                .then()
                .extract().response();
    }
    public static Response novoLogin(String corpoLogin) throws IOException {
        LerProperties manipulador = new LerProperties();
        return given()
                .contentType(ContentType.JSON)
                .body(corpoLogin)
                .when()
                .post(manipulador.getCadastrarUsuario())
                .then()
                .extract().response();
    }
    public static void cadastrarNovoVeiculoForwardCar() throws IOException {
        Response cadastrarNovoVeiculo=cadastrarVeiculo();
        Assert.assertEquals(cadastrarNovoVeiculo.jsonPath().getString(AtributosJson.vin),RespostaAtributoJson.numeroVin);
        System.out.println(cadastrarNovoVeiculo);
    }
    public static Response cadastrarVeiculo() throws IOException {
        LerProperties manipulador = new LerProperties();
        return    given()
                .contentType(ContentType.JSON)
                .body(gerarCorpoCadastroVeiculo())
                .when()
                .post(manipulador.getCadastrarVeiculo())

                .then()
                .log().all().extract().response();
    }
    public static void consultarNovoVeiculoCadastradoComGet() throws IOException {
        LerProperties manipulador = new LerProperties();
        given()
                .when()
                .get(manipulador.getCadastrarVeiculo())
                .then().body(containsString(RespostaAtributoJson.numeroVin));
    }
    public static String gerarCorpoCadastro(String firstname,String lastname,String username,String password) {
        JSONObject corpoCadastro = new JSONObject();
        corpoCadastro.put(AtributosJson.firstname, firstname);
        corpoCadastro.put(AtributosJson.lastname, lastname);
        corpoCadastro.put(AtributosJson.username, username);
        corpoCadastro.put(AtributosJson.password, password);
        return corpoCadastro.toString();
    }
    public static String gerarCorpoLogin(String username,String password) {
        JSONObject corpoCadastro = new JSONObject();
        corpoCadastro.put(AtributosJson.username, username);
        corpoCadastro.put(AtributosJson.password, password);
        return corpoCadastro.toString();
    }
    public static String gerarCorpoCadastroVeiculo(){
        JSONObject corpoCadastro = new JSONObject();

        JSONObject dealer = new JSONObject();
        JSONObject model = new JSONObject();
        JSONObject make = new JSONObject();
        JSONObject type = new JSONObject();

        corpoCadastro.put(AtributosJson.dealer, dealer);
        dealer.put(AtributosJson.classs, RespostaAtributoJson.enderecoSite);
        dealer.put(AtributosJson.id,RespostaAtributoJson.id);
        dealer.put(AtributosJson.address,RespostaAtributoJson.address);
        dealer.put(AtributosJson.city,RespostaAtributoJson.city);
        dealer.put(AtributosJson.name,RespostaAtributoJson.name);
        dealer.put(AtributosJson.state,RespostaAtributoJson.state);
        dealer.put(AtributosJson.telephone,RespostaAtributoJson.telefone);
        dealer.put(AtributosJson.website,RespostaAtributoJson.website);
        dealer.put(AtributosJson.zip,RespostaAtributoJson.cep);
        corpoCadastro.put(AtributosJson.model,model);
        model.put(AtributosJson.classs,RespostaAtributoJson.classModel);
        model.put(AtributosJson.id,RespostaAtributoJson.idModel);
        model.put(AtributosJson.fuelType,RespostaAtributoJson.fuelTypeModel);
        corpoCadastro.put(AtributosJson.make,make);
        make.put(AtributosJson.classs,RespostaAtributoJson.classMake);
        make.put(AtributosJson.id,RespostaAtributoJson.idMake);
        make.put(AtributosJson.name,RespostaAtributoJson.nameMake);
        corpoCadastro.put(AtributosJson.modelYear,RespostaAtributoJson.modelYear);
        corpoCadastro.put(AtributosJson.name,RespostaAtributoJson.nameModel);
        corpoCadastro.put(AtributosJson.subName,RespostaAtributoJson.subName);
        corpoCadastro.put(AtributosJson.type,type);
        type.put(AtributosJson.classs,RespostaAtributoJson.classType);
        type.put(AtributosJson.id,RespostaAtributoJson.idType);
        type.put(AtributosJson.name, RespostaAtributoJson.nameType);
        corpoCadastro.put(AtributosJson.stockNumber,RespostaAtributoJson.stockNumber);
        corpoCadastro.put(AtributosJson.price,RespostaAtributoJson.price);
        corpoCadastro.put(AtributosJson.milage,RespostaAtributoJson.milage);
        corpoCadastro.put(AtributosJson.owners, RespostaAtributoJson.owners);
        corpoCadastro.put(AtributosJson.modelYear,RespostaAtributoJson.modelYearFinal);
        corpoCadastro.put(AtributosJson.color,RespostaAtributoJson.color);
        corpoCadastro.put(AtributosJson.carTrim,RespostaAtributoJson.carTrim);
        corpoCadastro.put(AtributosJson.engine, RespostaAtributoJson.engine);
        corpoCadastro.put(AtributosJson.transmission,RespostaAtributoJson.transmission);
        corpoCadastro.put(AtributosJson.vin,RespostaAtributoJson.numeroVin);
        corpoCadastro.put(AtributosJson.options,RespostaAtributoJson.options);
        corpoCadastro.put(AtributosJson.image1,RespostaAtributoJson.image1);
        corpoCadastro.put(AtributosJson.image2,RespostaAtributoJson.image2);

        return corpoCadastro.toString();
    }
}
