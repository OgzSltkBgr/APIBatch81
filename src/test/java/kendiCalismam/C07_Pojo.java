package kendiCalismam;

import baseUrl.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C07_Pojo extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                "id": 2508,
                "name": "Sharmila Deshpande VM",
                "email": "deshpande_sharmila_vm@becker.name",
                "gender": "female",
                "status": "active"
                 }
          }
    */

    @Test
    public void C07_Pojo() {
        // Set the Url
        spec.pathParams("first","users","second",2508);

        // Set the Expected Data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508,"Sharmila Deshpande VM","deshpande_sharmila_vm@becker.name","female","active");
        GoRestPojo expectedData= new GoRestPojo(null,goRestDataPojo);
        System.out.println("expectedData = " + expectedData);

        // Send the Request Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        GoRestPojo actualdata=response.as(GoRestPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getMeta(),actualdata.getMeta());
        assertEquals(goRestDataPojo.getId(),actualdata.getData().getId());
        assertEquals(goRestDataPojo.getName(),actualdata.getData().getName());
        assertEquals(goRestDataPojo.getEmail(),actualdata.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(),actualdata.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(),actualdata.getData().getStatus());

    }
}
