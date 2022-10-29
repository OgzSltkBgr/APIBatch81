package getRequest;

import baseUrl.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get05b extends RegresBaseUrl {
     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void get01() {
        spec.pathParams("first","api","second","unknown","third",3);

        Response response=given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.getStatusCode(),200,"status code yanlis");
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8","content type yanlis");
        softAssert.assertEquals(jsonPath.getInt("data.id"),3,"id degeri yanlis");
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red","name degeri yanlis");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002,"year degeri yanlis");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932","color degeri yanlis");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664","pantone value degeri yanlis");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading","url yanlis");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!","text yanlis");


        softAssert.assertAll();
    }
}
