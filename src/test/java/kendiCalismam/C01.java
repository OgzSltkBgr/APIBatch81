package kendiCalismam;

import baseUrl.AutoBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class C01 extends AutoBaseUrl {
    @Test
    public void get01() {
        //https://automationexercise.com/api/brandsList
        spec.pathParam("first","brandsList");

        Response response=given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        JsonPath json = response.jsonPath();

        List<String> brandNames=json.getList("brands.findAll{it.brand}.brand");
        System.out.println("brandNames = " + brandNames);

        List<String> polo =json.getList("brands.findAll{it.brand=='Polo'}.brand");
        System.out.println("polo adet sayisi = " + polo.size());

        List<String> hm =json.getList("brands.findAll{it.brand=='H&M'}.brand");
        System.out.println("hm adet sayisi = " + hm.size());

        List<String> madame =json.getList("brands.findAll{it.brand=='Madame'}.brand");
        System.out.println("madame adet sayisi = " + madame.size());

        List<String> babyhug =json.getList("brands.findAll{it.brand=='Babyhug'}.brand");
        System.out.println("babyhug adet sayisi = " + babyhug.size());

        response.then().statusCode(200);
        assertEquals(200,response.getStatusCode());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),200);
    }
}
