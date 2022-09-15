package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Main {

    public static void main(String[] args) {
        // RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.baseURI = "https://62b86e41f4cb8d63df5db530.mockapi.io";

//        Map<String, String> params = new HashMap<String, String>();
//        params.put("email", "iamharims@gmail.com");
//        params.put("password", "test@123");
//
//        Gson gson = new Gson();
//        String json = gson.toJson(params);
//
        //Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(params).post("/api/{resource}");
//        System.out.println(response.getBody().asString());

        Users[] response1 = given().get("/api/v1/users").as(Users[].class);
        System.out.println(response1.length);
        //System.out.println(response1.getBody().asString());
//        List<Map<String,String>> customNames = JsonPath.from(response1.getBody().asString()).get();
//        System.out.println(customNames.size());
//        for(Map<String,String> cmap : customNames ){
//            System.out.println(cmap.get("createdAt"));
//            System.out.println(cmap.get("name"));
//            System.out.println(cmap.get("avatar"));
//        }
    }
}
