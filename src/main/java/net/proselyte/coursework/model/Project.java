package net.proselyte.coursework.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "budget")
    private String budget;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "deadline")
    private String deadline;
}
