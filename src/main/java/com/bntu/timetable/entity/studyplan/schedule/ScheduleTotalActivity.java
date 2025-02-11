package com.bntu.timetable.entity.studyplan.schedule;


import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "schedule_total_activity")
public class ScheduleTotalActivity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "study_plan_id")
    @JsonIgnore
    private StudyPlan studyPlan;

    @Column(name = "total_week_count")
    private Double totalWeekCount;
}
