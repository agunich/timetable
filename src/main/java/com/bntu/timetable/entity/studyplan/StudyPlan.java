package com.bntu.timetable.entity.studyplan;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Qualification;
import com.bntu.timetable.entity.Speciality;
import com.bntu.timetable.entity.studyplan.schedule.ScheduleTotalActivity;
import com.bntu.timetable.entity.studyplan.schedule.Semester;
import com.bntu.timetable.entity.studyplan.structure.Cycle;
import com.bntu.timetable.entity.studyplan.structure.EducationForm;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "semesters")
@Table(name = "study_plan")
public class StudyPlan extends BaseEntity {

    @Column(name = "standard_plan")
    private Boolean standardPlan;

    @Column(name = "register_number", length = 1000)
    private String registerNumber;

    @OneToMany(mappedBy = "studyPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "study_plan_semester")
    private List<Semester> semesters;

    @OneToMany(mappedBy = "studyPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduleTotalActivity> scheduleTotalActivities;

    @Column
    private Integer developmentYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StudyPlanStatus status;

    @Column(name = "status_change_date")
    private LocalDateTime statusChangeDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_form")
    private EducationForm educationForm;

    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @OneToMany(mappedBy = "studyPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Cycle> cycles;

}
