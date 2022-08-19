package com.attendancesurvey.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate attendanceDate;
    private boolean isPresent;

    @ManyToOne(fetch= FetchType.LAZY)
    private Course course;
}
