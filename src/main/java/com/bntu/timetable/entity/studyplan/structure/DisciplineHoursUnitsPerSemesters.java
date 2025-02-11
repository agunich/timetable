package com.bntu.timetable.entity.studyplan.structure;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Flow;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.studyplan.schedule.Semester;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "discipline_hours_unites_per_semesters")
public class DisciplineHoursUnitsPerSemesters extends BaseEntity {

    @Column(name = "total_hours")
    private Double totalHours;

    @Column(name = "classroom_hours")
    private Double classroomHours;

    @Column(name = "credit_units")
    private Double creditUnits;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    @JsonIgnore
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;


}
