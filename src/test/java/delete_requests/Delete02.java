package delete_requests;

import baseUrl.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDeletePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {
    /*
     Given
            URL: https://dummy.restapiexample.com/api/v1/delete/2
     When
            User Sends Delete Request and gets response
     Then
          i) Status code is 200
     And
          ii) "status" is "success"
     And
          iii) "data" is "2"
     And
          iv) "message" is "Successfully! Record has been deleted"
       */

    @Test
    public void delete02() {
        spec.pathParams("first","delete","second",2);
        DummyRestApiDeletePojo expectedData=new DummyRestApiDeletePojo("success","2","Successfully! Record has been deleted");
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();
        DummyRestApiDeletePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeletePojo.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getData(),actualData.getData());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
    }
}
