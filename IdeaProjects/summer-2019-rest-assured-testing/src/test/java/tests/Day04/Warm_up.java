package tests.Day04;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class Warm_up {
    @Test
    public void averageSalary(){
        Response response = when().get("http://ec2-34-201-69-55.compute-1.amazonaws.com:1000/ords/hr/employees").
                prettyPeek();
        response.then().statusCode(200);
        List<Integer> salary = response.jsonPath().getList("items.salary");
        System.out.println("salary = " + salary);
        int totalSalary=0;
        for (Integer salaryInt : salary) {
            totalSalary+=salaryInt;
        }
        System.out.println("totalSalary = " + totalSalary);
        assertThat(totalSalary/salary.size(),is(greaterThan(5000)));

        int total=0;
        Iterator<Integer> Myiterator = salary.iterator();
        while(Myiterator.hasNext()){
            total+=Myiterator.next();
        }
        System.out.println("total = " + total);
        assertThat(total/salary.size(),is(greaterThan(5000)));

    }
}
