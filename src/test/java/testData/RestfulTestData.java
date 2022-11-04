package testData;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {
    public Map<String, Object> expectedDataBookingdatesMethod(String checkin,String checkout){
        Map<String,Object> expectedDataBookingdates=new HashMap<>();  //once inner map yapildi
        expectedDataBookingdates.put("checkin",checkin);
        expectedDataBookingdates.put("checkout",checkout);

        return expectedDataBookingdates;

    }
    public Map<String,Object>expectedDataAllMethod(String firstname,String lastname,Integer totalprice,Map<String,Object> bookingdates,String additionalneeds){
        Map<String,Object> expectedDataAll=new HashMap<>();
        expectedDataAll.put("firstname",firstname);
        expectedDataAll.put("lastname",lastname);
        expectedDataAll.put("totalprice",totalprice);
        expectedDataAll.put("bookingdates",bookingdates);
        expectedDataAll.put("additionalneeds",additionalneeds);

        return expectedDataAll;
    }
    public Map<String, String> bookingdatesMethod(String checkin,String checkout){
        Map<String,String> bookingdatesMap=new HashMap<>();  //once inner map yapildi
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);

        return bookingdatesMap;

    }
    public Map<String,Object>expectedDataMethod(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates){
        Map<String,Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);

        return expectedDataMap;
    }


}