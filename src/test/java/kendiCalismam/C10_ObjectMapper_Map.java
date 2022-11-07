package kendiCalismam;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C10_ObjectMapper_Map extends JsonPlaceHolderBaseUrl {
    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void C10() throws IOException {

        // Set the Url
        spec.pathParam("first","todos");

        // Set the Expected Data
        Map<String,Object> expectedData= new ObjectMapper().readValue("", HashMap.class);
    }
}
