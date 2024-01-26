package awesomecucumber.domainobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String dataOfBirth;
    private String subjects;
    private String hobbies;
    private String picture;
    private String currentAddress;
    private String state;
    private String city;
}
