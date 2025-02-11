package com.bntu.timetable.entity;

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
@Table(name = "study_group")
public class Group extends BaseEntity {

    @Column(name = "number", length = 1000)
    private String number;

    @Column(name = "student_count")
    private Integer studentCount;

    @Column(name = "enter_year")
    private Integer enterYear;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private List<Flow> flows;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subgroup> subgroups;

    @ManyToOne
    @JsonIgnoreProperties(value = {"department", "groups", "studyPlans"}, allowSetters = true)
    private Speciality speciality;

}
