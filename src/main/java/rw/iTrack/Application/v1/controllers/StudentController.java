package rw.iTrack.Application.v1.controllers;

import com.sun.media.sound.AiffFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rw.iTrack.Application.v1.dto.CreateStudentDTO;
import rw.iTrack.Application.v1.dto.UpdateStudentDTO;
import rw.iTrack.Application.v1.models.Student;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.serviceImpls.StudentServiceImpl;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createStudent(@RequestBody CreateStudentDTO dto) {
        Student student = new Student(dto.getNames(), dto.getEmail(), dto.getPassword(), dto.getGender(), dto.getClassName(), dto.getYear());
        URI uri = URI.create(ServletComponentsBuilder.fromCurrentContextPath().path("/api/v1/student/create").toString());
        return ResponseEntity.created(uri).body(new ApiResponse(true, "Student created successfully", this.studentService.createStudent(student)));
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<ApiResponse> createStudent(@RequestBody List<CreateStudentDTO> students) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/student/create").toString());
        return ResponseEntity.created(uri).body(new ApiResponse(true, "Student created successfully", this.studentService.addMultipleStudents(students)));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody UpdateStudentDTO dto) {
        Student student = new Student(); //TODO -> tobe implemented to get logged in student
        return ResponseEntity.ok().body(new ApiResponse(true, "Student updated successfully", this.studentService.updateStudent(student, dto)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteStudent(@RequestBody String password) {
        Student student = new Student();//TODO -> to be implemented to get logged in student
        return ResponseEntity.ok().body(new ApiResponse(true, "Student deleted successfully", this.studentService.deleteStudent(password, student.getId())));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllStudents() {
        return ResponseEntity.ok().body(new ApiResponse(true, "Students fetched successfully", this.studentService.getAllStudents()));
    }

    @GetMapping("/:id")
    public ResponseEntity<ApiResponse> getStudentsById(@PathVariable(name = "id") UUID studentId) {
        return ResponseEntity.ok().body(new ApiResponse(true, "Student fetched successfully", this.studentService.getStudentById(studentId)));
    }


}
