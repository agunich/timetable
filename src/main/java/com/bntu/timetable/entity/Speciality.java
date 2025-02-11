package com.bntu.timetable.entity;

import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "speciality")
public class Speciality extends BaseEntity{

    @Column(name = "short_name", length = 100)
    private String shortName;

    @Column(name = "full_name", length = 1000)
    private String fullName;

    @Column(name = "short_code", length = 100)
    private String shortCode;

    @Column(name = "speciality_code", length = 100)
    private String specialityCode;

    @Column(name = "description", length = 10000)
    private String description;

    @Column(name = "direction_name", length = 1000)
    private String directionName;

    @Column(name = "direction_code", length = 100)
    private String directionCode;

    @Column(name = "specialization_name", length = 1000)
    private String specializationName;

    @Column(name = "specialization_code", length = 100)
    private String specializationCode;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties(value = {"specialities", "deanery"}, allowSetters = true)
    private Department department;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<StudyPlan> studyPlans;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Group> groups;
}
