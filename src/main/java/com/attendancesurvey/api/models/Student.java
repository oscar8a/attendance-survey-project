package com.attendancesurvey.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "STUDENTS")
public class Student {
    private String name;
}
