package tests.Day04;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import pojos.Job;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GsonDemo {

    @Test
    public void deserializeThis() throws FileNotFoundException {
        //steps for deserialization
        //coverts the input to java object
        Gson gson=new Gson();
        //file that want to read by providing the path of the file
        FileReader jsonFile= new FileReader("src/test/resources/it_job.json");
        // fromJson -->takes input source and covert to object again exactly like the Job class
        // which is a single object , because it might be a List
        Job job = gson.fromJson(jsonFile, Job.class);
        // list
       // List<Job>jsonList=new LinkedList<>();
        System.out.println("reader = " +job.getMin_salary());
    }

    @Test
    public void serializeThis() throws IOException {
      //will be the opposite from java to json

       // The converter
       Gson gson = new Gson();

       // use this to format the json file
       // Gson gson=new GsonBuilder().setPrettyPrinting().create();

       //java object that we want to serialize
        Job job = new Job("TE","Teacher",100,100000);
       //class that writes file
        FileWriter output=new FileWriter("src/test/resources/te_job.json");
      // toJson -->serialization is happening here
        gson.toJson(job,output);
        //write into the file
        output.flush();
        output.close();
    }
}
