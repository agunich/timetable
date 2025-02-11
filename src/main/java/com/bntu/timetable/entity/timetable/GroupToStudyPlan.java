package com.bntu.timetable.entity.timetable;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "group_studyplan_timetable")
public class GroupToStudyPlan extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "study_plan_id")
    private StudyPlan studyPlan;

    @ManyToOne
    @JoinColumn(name = "timetable_id")
    @JsonBackReference(value = "timetable-groupsToStudyPlans")
    private Timetable timetable;

}
