package kendiCalismam;

import baseUrl.AutoBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Hw02 extends AutoBaseUrl {
    @Test
    public void get01() {
        spec.pathParam("first","productsList");
        Response response = given().spec(spec).when().get("/{first}");
        response.then().statusCode(200).contentType("text/html; charset=utf-8").statusLine("HTTP/1.1 200 OK");
        JsonPath json = response.jsonPath();
        List<String>women = json.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
        List<String> men = json.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
        List<String> kids = json.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");
        assertEquals(12,women.size());
        assertEquals(9,men.size());
        assertEquals(13,kids.size());
    }
}
