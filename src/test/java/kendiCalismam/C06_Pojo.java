package kendiCalismam;

import baseUrl.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06_Pojo extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/19
        When
          I send GET Request to the URL
       Then
          Status code is 200
      And
          Response body is like:
                       {
                           "firstname": "Guoqiang",
                            "lastname": "Liu",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }
                             */

    @Test
    public void C06_Pojo() {
        // Set the Url
        spec.pathParams("first","booking","second",19);

        // Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Guoqiang","Liu",111,true,bookingDatesPojo,"Breakfast");

        // Send the Request Get the Response
        Response response =given().spec(spec).when().get("/{first}/{second}");

        // Do Assertion
        BookingPojo actualData=response.as(BookingPojo.class);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());


    }
}
