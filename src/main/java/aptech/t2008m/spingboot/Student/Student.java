package aptech.t2008m.spingboot.Student;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {
    @Id
    private int rollNumber;
    private String fullName;
    private String email;
    private String address;
    private int status;
}
