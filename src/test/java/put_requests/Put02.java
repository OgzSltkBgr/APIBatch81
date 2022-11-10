package put_requests;

import baseUrl.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/update/21
    When
       User Sends PUT Request and gets response

       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }

       Then
                i) Status code is 200
       And
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    @Test
    public void put02() {
        spec.pathParams("first","update","second",21);

        DummyRestApiDataPojo dummyRestApiDataPojo=new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image");
        DummyRestApiResponsePojo expectedData= new DummyRestApiResponsePojo("success",dummyRestApiDataPojo,"Successfully! Record has been updated.");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyRestApiDataPojo).when().put("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiResponsePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

        assertEquals(dummyRestApiDataPojo.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(dummyRestApiDataPojo.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(dummyRestApiDataPojo.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(dummyRestApiDataPojo.getProfile_image(),actualData.getData().getProfile_image());

    }
}
