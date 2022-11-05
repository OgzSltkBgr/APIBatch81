package delete_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01() {
        //Set the Url
        spec.pathParams("first","todos","second",198);

        // Set the expected Data
        Map<String,String> expectedData=new HashMap<>();

        // Send the Request Get the Response
        Response response=given().spec(spec).when().delete("/{first}/{second}");

        //Do Assertion
        Map actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());

        assertEquals(expectedData.size(),actualData.size());

        assertEquals(expectedData,actualData);

        assertTrue(actualData.isEmpty());


    }
}
