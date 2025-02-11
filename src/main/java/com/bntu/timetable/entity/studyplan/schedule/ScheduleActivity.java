package com.bntu.timetable.entity.studyplan.schedule;

import com.bntu.timetable.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@EqualsAndHashCode(callSuper = true, exclude = "semester")
@Table(name = "schedule_activity")
public class ScheduleActivity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    @JsonBackReference(value = "schedule_activity_semester")
    private Semester semester;

    @ElementCollection
    @CollectionTable(name = "schedule_activity_to_week_number", joinColumns = @JoinColumn(name = "activity_id"))
    @Column(name = "week_number")
    private List<Integer> weekNumbers;
}
