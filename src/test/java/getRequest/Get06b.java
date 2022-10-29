package getRequest;

import baseUrl.RegresBaseUrl;
import baseUrl.RestfulBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06b extends RegresBaseUrl {
    /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2
*/

    @Test
    public void get01() {
        spec.pathParams("first","api","second","unknown");
        Response response =given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        JsonPath json=response.jsonPath();

        response.then().assertThat().statusCode(200);
        assertEquals(200,response.getStatusCode());

        System.out.println("pantone_value ler = " + json.getList("data.pantone_value"));

        List<Integer> uctenBuyukIdler=json.getList("data.findAll{it.id>3}.id");
        System.out.println("uctenBuyukIdler = " + uctenBuyukIdler);
        assertEquals(3,uctenBuyukIdler.size());

        List<String> uctenKucukIdNames=json.getList("data.findAll{it.id<3}.name");
        System.out.println("uctenKucukIdler = " + uctenKucukIdNames);
        assertEquals(2,uctenKucukIdNames.size());

    }
}
