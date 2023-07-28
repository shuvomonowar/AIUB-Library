package ecom.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name", nullable = false)
    @NotNull
    private String student_name;

    @Column(name = "academic_program", nullable = false)
    @NotNull
    private String academic_program;

    @Column(name = "status", nullable = false)
    @NotNull
    private String status;

    @Column(name = "created_on")
    private LocalDate createdOn;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getAcademic_program() {
        return academic_program;
    }

    public void setAcademic_program(String academic_program) {
        this.academic_program = academic_program;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
