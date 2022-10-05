
import lombok.*;



@Getter
@Setter
@Builder
public class Employee {

    private String name;
    private Integer id;
    private Integer age;
    private String gender;
    private Integer yoj;
    private double salary;
    private String dept;

}
