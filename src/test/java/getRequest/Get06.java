package getRequest;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get06 extends RestfulBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/2325
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
          {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
},
    "additionalneeds": "Breakfast"
}
    */

    @Test
    public void get01() {
        // 1. Set the URL (Url oluştur)
        spec.pathParams("first","booking","second",2325);

        // 2. Set the expected data (put, post, patch)

        // 3. Send the request and get the response (Talep gönderme ve cevap alma)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        /*
        Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice":132,
    "depositpaid": false,
    "bookingdates": { // outer json
        "checkin": "2022-10-27", // inner json
        "checkout": "2022-11-07" // inner json
    },
    "additionalneeds": "None"
         */
        // 4. Do assertion
   //    response
   //            .then()
   //            .assertThat()
   //            .statusCode(200)
   //            .contentType(ContentType.JSON)
   //            .body("firstname",equalTo("Bradley"),
   //                    "lastname",equalTo("Pearson"),
   //                    "totalprice",equalTo(132),
   //                    "depositpaid",equalTo(false),
   //                    "bookingdates.checkin",equalTo("2022-10-27"),
   //                    "bookingdates.checkout",equalTo("2022-11-07"),
   //                    "additionalneeds",equalTo("None"));

        // 2. Yol
       JsonPath json= response.jsonPath();
   //    assertEquals("Bradley",json.getString("firstname"));
   //    assertEquals("Pearson",json.getString("lastname"));
   //    assertEquals(132,json.getInt("totalprice"));
   //    assertFalse(json.getBoolean("depositpaid"));
   //    assertEquals("2022-10-27",json.getString("bookingdates.checkin"));
   //    assertEquals("2022-11-07",json.getString("bookingdates.checkout"));
   //    assertEquals("None",json.getString("additionalneeds"));

        // 3. Yol: Soft Assertion
        // sofAssert class  3 adimda kullanilir

        // i) Obje oluşturma

        SoftAssert softAssert= new SoftAssert();

        //ii) Do Assertion (dogrulama yapma)
        softAssert.assertEquals(json.getString("firstname"), "Bradleyx","firstname hatali");
        softAssert.assertEquals(json.getString("lastname"),"Pearson","lastname hatalı");
        softAssert.assertEquals(json.getInt("totalprice"),132,"Total price Hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"),false,"dapositpaid hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2022-10-27","booking tarihi hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2022-11-07","booking tarihi hatali");
        softAssert.assertEquals(json.getString("additionalneeds"),"None","additionalneeds hatali");

        // iii) Dogrulama islemleri sonunda softAssert.assertAll() diyerek yaptigimiz tum dogrulama islemlerinin kontrol edilmesini
        // sagliyoruz.
        // Eger sistemin sonunda softAssert.assertAlll() kullanmaz isek taleplerimiz hatali olsa bile testimiz pass olacaktır.
        softAssert.assertAll();

    }
}
