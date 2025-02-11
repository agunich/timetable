package com.bntu.timetable.entity.timetable;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Deanery;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.studyplan.structure.EducationForm;
import com.bntu.timetable.entity.teacher.StaffType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "timetable")
public class Timetable extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "deanery_id")
    @JsonIgnoreProperties(value = {"departments", "flows", "timetables"}, allowSetters = true)
    private Deanery deanery;

    @Enumerated(EnumType.STRING)
    @Column(name = "timetable_status")
    private TimetableStatus timetableStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_form")
    private EducationForm educationForm;

    @Enumerated(EnumType.STRING)
    @Column(name = "student_type")
    private StudentType studentType;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "year")
    private Integer year;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "timetable_groups",
//            joinColumns = {@JoinColumn(name = "timetable_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
//            uniqueConstraints = @UniqueConstraint(columnNames = {
//                    "timetable_id", "group_id"}))
//    private List<Group> groups;

    @OneToMany(mappedBy = "timetable", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "timetable-groupsToStudyPlans")
    private List<GroupToStudyPlan> groupsToStudyPlans;


    @ManyToOne(cascade = CascadeType.MERGE)
    private Shift shift;

    @OneToMany(mappedBy = "timetable", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "timetable-lesson")
    private List<Lesson> lessons;


}
