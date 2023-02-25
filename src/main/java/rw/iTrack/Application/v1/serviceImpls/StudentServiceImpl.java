package rw.iTrack.Application.v1.serviceImpls;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rw.iTrack.Application.v1.config.JwtService;
import rw.iTrack.Application.v1.dto.LoginResponse;
import rw.iTrack.Application.v1.dto.UpdateStudentDTO;
import rw.iTrack.Application.v1.models.Student;
import rw.iTrack.Application.v1.repositories.StudentRepository;
import rw.iTrack.Application.v1.services.IStudentService;
import rw.iTrack.Application.v1.utils.Encoder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final Encoder encoder;
    private final JwtService jwtService;

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
    public String deleteStudent(String password, Long id) throws Exception {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new Exception("Student not found"));
        if (!this.encoder.isMatch(password, student.getPassword())) {
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
    public Student getStudentById(Long id) throws Exception {
        System.out.println(id);
        return this.studentRepository.findById(id).orElseThrow(() -> new Exception("Student not found"));
    }

    @Override
    public List<Student> addMultipleStudents(List<Student> students) {
        return this.studentRepository.saveAll(students);
    }

    @Override
    public LoginResponse login(String email, String password) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        Student student = this.studentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email (" + email + ") does not exist"));
        if (student == null) return null;
        boolean isMatch = encoder.isMatch(password, student.getPassword());
        if (!isMatch) return null;
        System.out.println("User:  " + student.getNames());
        String jwtToken = this.jwtService.generateToken(student.getEmail());
        System.out.println("Token:  " + jwtToken);
        return new LoginResponse(jwtToken, student);
    }

    @Override
    public Student getLoggedInStudent() {
        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        return studentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Logged in user not found"));
    }
}