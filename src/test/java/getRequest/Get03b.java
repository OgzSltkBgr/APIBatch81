package getRequest;

import baseUrl.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03b extends RegresBaseUrl {

    /*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/

    @Test
    public void get01() {
        spec.pathParams("first","api","second","users","third",2);
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.email",equalTo("janet.weaver@reqres.in"),
                        "data.first_name",equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}
