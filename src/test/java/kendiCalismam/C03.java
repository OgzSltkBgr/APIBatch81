package kendiCalismam;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class C03 extends JsonPlaceHolderBaseUrl {

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
    public void get03() {
        spec.pathParams("first","todos","second",2);

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualMap=response.as(HashMap.class);

        assertEquals(expectedData.get("userId"),actualMap.get("userId"));
        assertEquals(expectedData.get("title"),actualMap.get("title"));
        assertEquals(expectedData.get("completed"),actualMap.get("completed"));

        JsonPath json = response.jsonPath();
    }
}
