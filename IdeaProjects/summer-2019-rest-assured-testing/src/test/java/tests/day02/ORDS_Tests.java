package tests.day02;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ORDS_Tests {

    /**
     Create a new package tests.day2
     Write test case to test in new class ORDSTests:
     get employee from employees table with id 100 (use path parameters)
     Verify response contains King
     response contains 100
     status code 200
     header application/json


     get employee from countries table with id AR (use path parameters)
     Verify response contains Argentina
     response contains AR
     status code 200
     header application/json


     get employee from departments table with id 2000 (use path parameters)
     Verify response contains Argentina
     response contains AR
     status code 404
     header text/html

     */

    @Test
    public void employeeTableTest() {
        Response response = given().pathParam("id", "100").
                when().get("http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr/employees/{id}");
        response.then().statusCode(200).and().contentType("application/json");
        String responseStr = response.asString();
        assertThat(responseStr, containsString("100"));
        assertThat(responseStr, containsString("King"));

    }


    @Test
    public void countriesTableTest() {
        Response response = given().pathParam("id", "AR").
                when().get("http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr/countries/{id}");
        response.then().statusCode(200).and().contentType("application/json");
        assertThat(response.asString(), containsString("AR"));
        assertThat(response.asString(), containsString("Argentina"));

    }


    @Test
    public void departmentsTableTest(){
        Response response = given().pathParam("id", "2000").
                when().get("http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr/departments/{id}");
        response.then().statusCode(404);

        String contentType = response.header("Content-Type");
        assertThat(contentType, is("text/html"));
        Assertions.assertEquals(contentType, "text/html");


    }

    @Test
    public void test100(){
        Response response = given().pathParam("id", "100").
                when().get("http://ec2-3-84-235-168.compute-1.amazonaws.com:1000/ords/hr/employees/{id}");
       response.prettyPeek();
        String str = response.asString();
        assertTrue(str.contains("100"));
        assertTrue(str.contains("King"));
        assertThat(response.getStatusCode(),is(200));
        assertThat(response.getContentType(),is("application/json"));
    }

    @Test
    public void test200(){
        Response response = given().pathParam("id", "AR").
                when().get("http://ec2-3-84-235-168.compute-1.amazonaws.com:1000/ords/hr/countries/{id}");

        response.prettyPeek().then().assertThat().statusCode(200).and().contentType("application/json");
        String responseStr = response.asString();
       assertThat(responseStr,containsString("Argentina"));
       assertThat(responseStr,containsString("AR"));
    }
    @Test
    public void test300(){
        Response response = given().pathParam("id", "2000").when().
                get("http://ec2-3-84-235-168.compute-1.amazonaws.com:1000/ords/hr/countries/{id}");

        response.prettyPeek().then().assertThat().contentType("text/html").and().statusCode(404);

        String header = response.header("Content-Type");
       // assertThat(header,is("text/html"));
        Assertions.assertEquals(header,"text/html");

    }
}
