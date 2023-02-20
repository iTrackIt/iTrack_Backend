package rw.iTrack.Application.v1.serviceImpls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.iTrack.Application.v1.dto.UpdateStudentDTO;
import rw.iTrack.Application.v1.models.Student;
import rw.iTrack.Application.v1.repositories.StudentRepository;
import rw.iTrack.Application.v1.services.IStudentService;
import rw.iTrack.Application.v1.utils.Encoder;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, UpdateStudentDTO newData) {
        student.setNames(newData.getNames());
        student.setEmail(newData.getNames());
        student.setYear(newData.getYear());
        student.setClassName(newData.getClassName());
        student.setGender(newData.getGender());
        return this.studentRepository.save(student);
    }

    @Override
    public String deleteStudent(String password, UUID id) throws Exception {
        Encoder encoder = new Encoder();
        Student student = this.studentRepository.findById(id).orElseThrow(()->new Exception("Student not found"));
        if (!encoder.isMatch(password, student.getPassword())) {
            return "Password incorrect";
        }
        this.studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) throws Exception {
        return this.studentRepository.findById(id).orElseThrow(()->new Exception("Student not found"));
    }

    @Override
    public List<Student> addMultipleStudents(List<Student> students) {
        return this.studentRepository.saveAll(students);
    }
}
