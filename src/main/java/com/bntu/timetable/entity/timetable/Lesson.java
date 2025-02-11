package com.bntu.timetable.entity.timetable;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.Subgroup;
import com.bntu.timetable.entity.classroom.Building;
import com.bntu.timetable.entity.classroom.Classroom;
import com.bntu.timetable.entity.studyplan.structure.Discipline;
import com.bntu.timetable.entity.studyplan.structure.EducationForm;
import com.bntu.timetable.entity.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "lesson")
public class Lesson extends BaseEntity {

    @JoinColumn(name = "name")
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lessons_to_groups",
            joinColumns = {@JoinColumn(name = "lesson_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {
                    "lesson_id", "group_id"}))
    private Set<Group> groups;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lessons_to_subgroups",
            joinColumns = {@JoinColumn(name = "lesson_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subgroup_id", referencedColumnName = "id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {
                    "lesson_id", "subgroup_id"}))
    private Set<Subgroup> subgroups;


    @ManyToOne
    @JoinColumn(name = "timeline_id")
    private Timeline timeline;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "timetable_id")
    @JsonBackReference(value = "timetable-lesson")
    private Timetable timetable;

    @Enumerated(EnumType.STRING)
    @Column(name = "student_type")
    private StudentType studentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type")
    private LessonType lessonType;

    @Column(name = "once_in_two_week")
    private Boolean onceInTwoWeek;

    @Column(name = "week_num")
    private BigInteger weekNum;


    // 0 - Sunday.. 6 - Saturday
    @Column(name = "day")
    private Integer day;

    @ManyToOne
    @JoinColumn(name = "building_id")
//    @JsonManagedReference(value = "lesson-building")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
//    @JsonManagedReference(value = "lesson-classroom")
    private Classroom classroom;

//    building: Building;
//    classroom: Classroom;

}
