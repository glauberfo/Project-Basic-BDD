package com.br.iterasys;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class example {

	@Test
	public void getCEP() {

		String cep = "06763390";
		String bairro = "Jardim Maria Rosa";

		JsonPath response = given().when().get("https://viacep.com.br/ws/" + cep + "/json/").then()
				.statusCode(200).extract().body().jsonPath();
		
		assertEquals(response.getString("bairro"), bairro);

	}
	
}
