package com.bntu.timetable.entity.studyplan.structure;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.studyplan.schedule.Semester;
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
@Table(name = "semester_load")
public class SemesterLoad extends BaseEntity {
    @Column(name = "name", length = 1000)
    private String name;

}
