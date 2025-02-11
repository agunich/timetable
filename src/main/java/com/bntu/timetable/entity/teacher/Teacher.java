package com.bntu.timetable.entity.teacher;


import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.studyplan.structure.DisciplineGroup;
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
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    @Column(name = "firstName", length = 1000)
    private String firstName;

    @Column(name = "lastName", length = 1000)
    private String lastName;

    @Column(name = "patronymic", length = 1000)
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "teacher_position_id")
    private TeacherPosition teacherPosition;

    @ManyToOne
    @JoinColumn(name = "academic_title_id")
    private AcademicTitle academicTitle;

    @ManyToOne
    @JoinColumn(name = "academic_degree_id")
    private AcademicDegree academicDegree;

    @Column(name = "additional_info", length = 10000)
    private String additionalInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "staff_type")
    private StaffType staffType;

    @ManyToOne
    @JoinColumn(name = "work_tariff_id")
    private WorkTariff workTariff;

    @Column(name = "hours")
    private Integer hours;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teachers_discipline_groups",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "discipline_group_id", referencedColumnName = "id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {
                    "teacher_id", "discipline_group_id"}))
    private List<DisciplineGroup> disciplineGroups;

}
