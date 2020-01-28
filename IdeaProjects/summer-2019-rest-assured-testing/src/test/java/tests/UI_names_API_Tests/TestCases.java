package tests.UI_names_API_Tests;

import com.sun.istack.NotNull;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCases {

    @Test
    public void NoParamsTest(){
        Response response = given().log().everything().when().get("https://uinames.com/api/").prettyPeek();
            response.then().assertThat().statusCode(200);
            response.contentType().contains("application/json");
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");
       // assertFalse(name.isEmpty());
        assertThat(name,is(notNullValue()));
        System.out.println("name = " + name);

        String surname = jsonPath.getString("surname");
        assertThat(surname,is(notNullValue()));

        String gender = jsonPath.getString("gender");
        assertThat(gender,is(notNullValue()));

        String region= jsonPath.getString("region");
        assertThat(region,is(notNullValue()));
    }

    @Test
    public void GenderTest(){
        Response response = given().queryParam("gender", "male").
                get("https://uinames.com/api/").prettyPeek();

       response.then().statusCode(200).and().contentType("application/json; charset=utf-8");

        JsonPath jsonPath = response.jsonPath();
        String gender = jsonPath.getString("gender");
        assertTrue(gender.equals("male"));

    }

    @Test
    public void ParamsTest(){

        Response response = given().queryParam("region", "United States").
                and().queryParam("gender", "male").
                get("https://uinames.com/api/").prettyPeek();
        response.then().statusCode(200).and().contentType("application/json");

        JsonPath jsonPath = response.jsonPath();
        String gender = jsonPath.getString("gender");
        assertEquals(gender,"male");

        String region = jsonPath.getString("region");
        assertEquals(region,"United States");

    }

    @Test
    public void InvalidGenderTest(){
        Response response = given().queryParam("gender", "shemale").
                get("https://uinames.com/api/").prettyPeek();
         response.then().statusCode(400);
         response.statusLine().contains("Bad Request");
        System.out.println("response line= " + response.statusLine());

        String error = response.jsonPath().getString("error");
        assertThat(error,is("Invalid gender"));
    }

    @Test
    public void InvalidRegionTest(){

        Response response = given().queryParam("region", "mozambique").
                get("https://uinames.com/api/").prettyPeek();
        response.then().statusCode(400);
        response.statusLine().contains("Bad Request");

        String error = response.jsonPath().getString("error");
        assertThat(error,is("Region or language not found"));

    }

    @Test
    public void AmountAndRegionsTest(){
        Response response = given().queryParam("region", "United States").
                queryParam("amount", 5).
                get("https://uinames.com/api/").prettyPeek();
        response.then().statusCode(200).and().contentType("application/json; charset=utf-8");
        List<String> name = response.jsonPath().getList("name");
        List<String> surname = response.jsonPath().getList("surname");
        List<String>fullName=new ArrayList<>();
        //System.out.println("name = " + name);
      //  System.out.println("surname = " + surname);
        Iterator<String> MyIterator = name.iterator();
        Iterator<String> iterator = surname.iterator();
        while(MyIterator.hasNext()){
            String concat = MyIterator.next().concat(" "+iterator.next());
        //   System.out.println("concat = " + concat);
           fullName.add(concat);
        }

        System.out.println("fullName = " + fullName);
        for (int i = 0; i <fullName.size()-1; i++) {
         assertFalse(fullName.get(i).equals(fullName.get(i+1)));
        }
    }

    @Test
    public void paramsTest(){
        Response response = given().queryParam("region", "Morocco").
                queryParam("gender", "male").queryParam("amount", 3).
                get("https://uinames.com/api/").prettyPeek();
        response.then().statusCode(200).and().contentType("application/json; charset=utf-8");
        List<String> region = response.jsonPath().getList("region");
        System.out.println("region.size() = " + region.size());
        for (int i = 0; i < region.size()-1; i++) {

           assertTrue(region.get(i).equals(region.get(i+1)));
        }
        List<String> gender = response.jsonPath().getList("gender");
        for (int i = 0; i < gender.size()-1; i++) {
             assertTrue(gender.get(i).equals(gender.get(i+1)));

        }
    }
    /**
     Amount count test
     1. Create a request by providing query parameter: amount (must be bigger than 1)
     2. Verify status code 200, content type application/json; charset=utf-8
     3. Verify that number of objects returned in the response is same as the amount passed in step 1
     */
    @Test
    public void AmountCountTest(){
        Response response = given().queryParam("amount", 7).
                get("https://uinames.com/api/").prettyPeek();
        response.then().statusCode(200).and().contentType("application/json; charset=utf-8");
        List<Integer> AmountCount = response.jsonPath().getList("amount");
        System.out.println("AmountCount.size() = " + AmountCount.size());
        assertThat(AmountCount.size(),is(7));
    }



}
