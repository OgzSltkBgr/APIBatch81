package getRequest;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
De-serialization : Json datayı Java objesine cevirme
Serialization: Java objesini Json formatına cevirme
De-serialization : Iki turlu yapacagiz.
Gson: Google tarafindan uretilmistir
Object Maper:
 */
    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": completed
       }
*/

    @Test
    public void get01() {
        spec.pathParams("first","todos","second",2);


        // Set the expected Data expectedData=Payload

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expected"+expectedData);

        // Send the get request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String ,Object>actualData=response.as(HashMap.class); // De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());
    }
    // Dinamik Yontem
    @Test
    public void get01b() {
        spec.pathParams("first","todos","second",2);


        // Set the expected Data expectedData=Payload

        JsonPlaceHolderTestData objJsonPlace = new JsonPlaceHolderTestData();

        Map<String,Object>expectedData=objJsonPlace.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        System.out.println("expectedData = " + expectedData);


        // Send the get request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String ,Object>actualData=response.as(HashMap.class); // De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        assertEquals("1.1 vegur",response.header("Via"));
        assertEquals("cloudflare",response.header("Server"));
        assertEquals(200,response.statusCode());
    }
}
