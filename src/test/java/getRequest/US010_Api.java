package getRequest;

import baseUrl.MedunnaBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.AppointmentPojo;
import pojos.PatientPojo;
import pojos.PhysicianPojo;
import pojos.UserPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.Authentication.generateToken;

public class US010_Api extends MedunnaBaseUrl {
    @Test
    public void US010() {
        spec.pathParams("1","api","2","appointments","3","302324");

        UserPojo user = new UserPojo("anonymousUser","2022-11-15T13:16:32.261615Z",300780,"hastaosbt","Oğuz",
                "TOKLUCU","hastaosb@gmail.com",true,"en",null,null,"751-01-3536");

        PatientPojo patient= new PatientPojo("hastaosbt","2022-11-15T13:51:33.044901Z",300396,"Oğuz",
                "TOKLUCU",null,"555-666-5566","MALE","Apositive","","hastaosb@gmail.com",
                "null",user,null,null,null);

        PhysicianPojo physician = new PhysicianPojo("adminosbt","2022-11-16T10:01:39.404884Z",301043,"Prof.Dr. Oğuz",
                "TOKLUCU","1990-12-31T22:00:00Z","444-444-4444","MALE","Apositive","",
                "Professor Doctor",user,"OPHTHALMOLOGY",null,null,200.00,"","image/png");

        AppointmentPojo expectedData= new AppointmentPojo("hastaosbt","2022-11-16T10:19:30.334695Z",302324,
                "2022-11-21T00:00:00Z","2022-11-21T01:00:00Z","PENDING","Gecmis rahatsizligi bulunmamakta",
                "gozluk + Goz damlasi","0.50 Astigmat","0.50 Astigmat gozluk, aqua goz damlasi gunde 5 damla",
                "",physician,patient,null);

        Response response = given().spec(spec).header("Authorization","Bearer "+generateToken())
                .contentType(ContentType.JSON).when().get("/{1}/{2}/{3}");

        AppointmentPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),AppointmentPojo.class);

        response.prettyPrint();
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getCreatedBy(),actualData.getCreatedBy());
        assertEquals(user.getFirstName(),actualData.getPatient().getUser().getFirstName( ));

    }
}
