package tests;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class FirstRestAssuredTest {

    /*
    when i send request to http://api.openrates.io/latest
    then the status must be 200
     */
@Test
    public void VerifyStatusCode(){
    // create response that is sent by server as result of out request
    // Given ==> used when creating the request
    // When ===>used dor sendind the request
    // Then ===> verification of the response

    Response response =when().get("http://api.openrates.io/latest");
          // print the response
            response.prettyPrint();
            //verify the status code
            //verify the status code matches the provided option
          response.then().statusCode(202);


}
/*
When i sent request to  http://api.openrates.io/latest
then body sould contain "base":"EURO"
 */

@Test
    public void VerifyBodyContains(){
    Response response=when().get("http://api.openrates.io/latest");
            //asString ()----> returns the body as a single string
    String bodyStr =response.asString();
    System.out.println("bodyStr = " + bodyStr);
    assertTrue(bodyStr.contains("\"base\":\"EUR\""));
}

/*
When i sent request to  http://api.openrates.io/latest
the response should contain header application/jason
 */
@Test
    public void verifyHeader1() {
    Response response = when().get("http://api.openrates.io/latest");
    String contentType = response.header("Content-Type");
    String date = response.header("Date");
    System.out.println("date = " + date);
    System.out.println("contentType = " + contentType);

    assertEquals("application/json",contentType);
    assertTrue(date.contains("2020"));

}
@Test
    public void VerifyContentType(){
    Response response=when().get("http://api.openrates.io/latest");
    String contentType=response.getContentType();
    System.out.println("contentType = " + contentType);
    //response.getStatusCode---> returns the status code of the response
    int statusCode=response.getStatusCode();
    System.out.println("statusCode = " + statusCode);
    assertEquals("application/json",contentType);

   //this line will print and also verify the status code
   // response.prettyPeek().then().statusCode(200).and().;

}
/*
      when i send request to  http://api.zippopotam.us/us/22031
     *    Then the status must 200
     *    And verify that response contains Fairfax
 */

@Test
    public void VerifyStatusCode1(){
    Response response=when().get("http://api.zippopotam.us/us/22031");
    int statusCode=response.getStatusCode();
   String CententType=response.contentType();
    System.out.println("CententType = " + CententType);
    System.out.println("statusCode = " + statusCode);
    assertEquals("200",statusCode);
    assertTrue(CententType.contains("Fairfax"));

}


    @Test
    public void statusCodeVerify(){
        Response response = when().get("http://api.zippopotam.us/us/22031");
        response.prettyPrint();
        response.then().statusCode(200);
        assertTrue(response.asString().contains("Fairfax"));
    }


/*
   when i send request to  http://api.zippopotam.us/us/22031111
     *    Then the status must 404
 */

 @Test
    public void VerifyCodeStatus11(){



 }
}
