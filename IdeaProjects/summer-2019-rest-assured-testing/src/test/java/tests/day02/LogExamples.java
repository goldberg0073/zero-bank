package tests.day02;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LogExamples {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr";
    }
    @Test
    public void test1() {
        // request logging
        // log().all(). --> prints everything in the request
        given().log().everything().
                pathParam("id", "7").
                when().get("/regions/{id}").
                then().
                statusCode(200);

    }

    @Test
    public void test2() {
        // response logging
        // log().all(). --> prints everything in the response
        // log().ifError(). --> prints if we get a error status code like 4xx or 5xx
        // ifStatusCodeIsEqualTo(401). --> prints if the status code matches the provided one
        // log().ifValidationFails --> prints if any assertion fails

        given().pathParam("id", "234237").
                when().get("/regions/{id}").
                then().log().ifValidationFails().
                statusCode(404);
    }

    @Test
    public void test3(){
        given().log().everything().
                pathParam("id", "101").
                when().get("/employees/{id}").
                then().log().everything().
                statusCode(200);

    }

}
