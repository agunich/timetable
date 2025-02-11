package com.bntu.timetable.entity.studyplan.structure;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Speciality;
import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "cycle")
public class Cycle extends BaseEntity {

    @Column(name = "name", length = 1000)
    private String name;

    @Column(name = "position")
    private Integer position;

    @Enumerated(EnumType.STRING)
    private CycleType cycleType;



    @Column(name = "total_hours")
    private Double totalHours;

    @Column(name = "classroom_hours")
    private Double classroomHours;

    @Column(name = "credit_units")
    private Double creditUnits;

    @OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "cycle-discipline")
    private List<Discipline> disciplines;

    @OneToMany(mappedBy = "cycle", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "cycle-component")
    private List<Component> components;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "study_plan_id")
    @JsonBackReference
    private StudyPlan studyPlan;


}
