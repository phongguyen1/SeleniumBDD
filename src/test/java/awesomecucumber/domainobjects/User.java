package awesomecucumber.domainobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer salary;
    private String department;
    private String currentAddress;
    private String permanentAddress;
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
