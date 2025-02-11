package com.bntu.timetable.entity;

import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "qualification")
public class Qualification extends BaseEntity  {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "qualification")
    @JsonIgnore
    private List<StudyPlan> studyPlans;
}
