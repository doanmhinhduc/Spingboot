package aptech.t2008m.spingboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentApi {
    @Autowired
    StudentRepository studentRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit){
        return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        studentRepository.save(student);
        return student;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{rollNumber}")
    public Student finById(@PathVariable String rollNumber){
        return studentRepository.findById(rollNumber).get();

    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{rollNumber}")
    public Student update(@PathVariable String rollNumber, @RequestBody Student updateStudent){
        Student existing = studentRepository.findById(rollNumber).get();
        existing.setFullName(updateStudent.getFullName());
        studentRepository.save(existing);
        return updateStudent ;
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{rollNumber}")
    public boolean delete(@PathVariable String rollNumber) {
        studentRepository.deleteById(rollNumber);
        return true;
    }
}
