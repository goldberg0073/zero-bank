package pojos;

import com.google.gson.annotations.SerializedName;

public class Employees {

    @SerializedName("employee_id")
    private String  employeeId;
    @SerializedName("first_name")
    private String  firstName;
    @SerializedName("last_name")
    private String   lastName;

    private String email;
    @SerializedName("phone_number")
    private String   phoneNumber;


    public Employees(String employeeId, String firstName, String lastName, String email, String phone_number) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phone_number;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                '}';
    }



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }



}
