package com.bntu.timetable.entity.studyplan.structure;

import com.bntu.timetable.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "discipline")
public class Discipline extends BaseEntity {

    @Column(name = "name", length = 1000)
    private String name;

    @Column(name = "description", length = 10000)
    private String description;

    @Column(name = "is_template")
    private Boolean isTemplate;

    @Column(name = "total_hours")
    private Double totalHours;

    @Column(name = "classroom_hours")
    private Double classroomHours;

    @Column(name = "credit_units")
    private Double creditUnits;

    // TODO: reimplement to University class
    @Column(name = "university")
    private String university;

    @Column(name = "position")
    private Integer position;

    @Column(name = "course_work_semester_num")
    private Integer courseWorkSemesterNum;

    @Enumerated(EnumType.STRING)
    private DisciplineType disciplineType;

    @ManyToOne
    @JoinColumn(name = "discipline_group_id")
    private DisciplineGroup disciplineGroup;

    @ManyToOne
    @JoinColumn(name = "component_id")
    @JsonBackReference(value = "component-discipline")
    private Component component;

    @ManyToOne
    @JoinColumn(name = "cycle_id")
    @JsonBackReference(value = "cycle-discipline")
    private Cycle cycle;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisciplineLoad> disciplineLoads;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisciplineSemesterLoad> disciplineSemesterLoads;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisciplineHoursUnitsPerSemesters> disciplineHoursUnitsPerSemesters;

}
