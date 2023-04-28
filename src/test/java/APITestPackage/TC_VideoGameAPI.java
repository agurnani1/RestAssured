package APITestPackage;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TC_VideoGameAPI {
    @Test
    public void test_getSpecificVideoGame(){
       // given().when()
    }
    @Test
    public void test_getAllVideoGames(){
        given()
                .when()
                    .get("http://localhost:8080/app/videogames").
                then()
                    .statusCode(200);
    }
    //POST:Add a new video game to the DB
    @Test
    public void test_addNewVideoGame(){
        HashMap data = new HashMap();
        data.put("id", 0);
        data.put("name", "SpiderMan");
        data.put("releaseDate", "2023-04-28T04:42:15.811Z");
        data.put("reviewScore", 5);
        data.put("category","Adventure");
        data.put("rating", "Universal");
        Response res=given()
                .contentType("application/json")
                .body(data)
                .when()
                    .post("http://localhost:8080/app/videogames")
        .then()
                .statusCode(200)
                .log().body()
                .extract().response();
        String jsonString = res.asString();
       // Assert.assertEquals(jsonString.contains("Record Added Successfully"),false);
        Assert.assertTrue(jsonString.contains("Record Added Successfully"));
    }


}
