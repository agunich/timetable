package com.bntu.timetable.entity.classroom;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Deanery;
import com.bntu.timetable.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "classroom")
public class Classroom extends BaseEntity {

    @Column(name = "number", length = 100)
    private String number;

    @Column(name = "capacity", length = 1000)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private AssignmentType assignmentType;

    @Enumerated(EnumType.STRING)
    private ClassroomStatus classroomStatus;

    @ManyToOne
    @JoinColumn(name = "deanery_id")
    @JsonIgnoreProperties(value = {"departments", "flows"}, allowSetters = true)
    private Deanery deanery;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties(value = {"deanery", "specialities"}, allowSetters = true)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "wing_id")
    @JsonIgnore
    private Wing wing;

    @ManyToOne
    @JoinColumn(name = "classroom_type_id")
    private ClassroomType classroomType;

    @ManyToOne
    @JoinColumn(name = "classroom_specialization_id")
    private ClassroomSpecialization classroomSpecialization;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(name = "end_point_x")
    private int width;

    @Column(name = "end_point_y")
    private int height;


}
