package tests.Day04;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import pojos.Employees;
import pojos.Job;

import java.util.List;

public class TestsUsingPojos {
    @BeforeAll
    public static void setup(){
        baseURI="http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr";
    }
    @Test
    public void getASinglJob(){
        Response response = given().pathParam("id", "IT_PROG").
                when().get("/jobs/{id}");
        response.then().statusCode(200);
        response.prettyPeek();
        //convert the body into given type
        Job itJob = response.as(Job.class);
        System.out.println("itJob = " + itJob);
        System.out.println("###################################################################");
        System.out.println("tJob.getJob_title = "+itJob.getJob_title());
        System.out.println("itJob.getJob_id  = " + itJob.getJob_id());
        //verify is job title is programmer
        assertThat(itJob.getJob_title(),equalTo("Programmer"));
    }

    @Test
    public void test(){
        Job job=new Job("01","accountant",500,10000);
        System.out.println(job);

//        System.out.println(job.getJob_title());
//        System.out.println(job.getJob_id());
//        System.out.println(job.getMax_salary());
//        System.out.println(job.getMin_salary());
    }

    @Test
    public void GetManyJobs(){
        Response response = when().get("/jobs");
        response.then().statusCode(200);
      //response.prettyPeek();

        /**
          To make it more organized exactly like the class job
         list of Job (objects from the Job class)
         get the response that contains all the jobs
       */

        List<Job> jobs = response.jsonPath().getList("items",Job.class);
      //  System.out.println("jobs = " + jobs);
        System.out.println(jobs.get(0).getJob_title());
        System.out.println(jobs.get(1).getMin_salary());
        System.out.println("jobs.size() = " + jobs.size());
        System.out.println(jobs.get(1).getJob_title());


        Job itJob = response.jsonPath().getObject("items[1]", Job.class);

        System.out.println("itJob = " + itJob);
    }


    @Test
    public void getOneEmployee(){


        Response response = given().pathParam("id", "102").
                when().get("/employees/{id}");
        response.then().statusCode(200);
        //response.prettyPeek();

        Employees emp = response.as(Employees.class);
        System.out.println(emp);

    }

    @Test
    public void AllTheEmployeesCount(){

        Response response = given().
                when().get("/employees");
        response.then().assertThat().statusCode(200);

        List<Employees> emps = response.jsonPath().getList("items", Employees.class);
        System.out.println("emps.size() = " + emps.size());

        assertThat(emps.size(),equalTo(25));
    }

}
