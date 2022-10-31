package kendiCalismam;

import baseUrl.AutoBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class C02 extends AutoBaseUrl {
    @Test
    public void get01() {
        // https://automationexercise.com/api/getUserDetailByEmail
        // "responseCode": 400,
        //    "message": "Bad request, email parameter is missing in GET request."
        spec.pathParam("first","getUserDetailByEmail");

        Response response=given().spec(spec).when().get("/{first}");

        JsonPath json =response.jsonPath();

        assertEquals(200,response.getStatusCode());
        assertEquals(400, json.getInt("responseCode"));
        assertEquals("Bad request, email parameter is missing in GET request.", json.getString("message"));




    }
}
