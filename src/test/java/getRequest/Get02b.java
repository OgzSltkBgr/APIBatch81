package getRequest;

import baseUrl.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02b extends RegresBaseUrl {
     /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"
   And
       Response body should be empty
*/

    @Test
    public void get01() {
        // Given
        //       https://reqres.in/api/users/23
        spec.pathParams("first","api","second","users","third",23);
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        // HTTP Status code should be 404
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(404,response.statusCode());

        // Status Line should be HTTP/1.1 404 Not Found
        System.out.println("response.getStatusLine() = " + response.getStatusLine());
        assertEquals("HTTP/1.1 404 Not Found",response.getStatusLine());

        // Server is "cloudflare"
        System.out.println("response.getHeader(\"Server\") = " + response.getHeader("Server"));
        assertEquals("cloudflare",response.getHeader("Server"));

        // Response body should be empty
        assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9)]","").length());
    }
}
