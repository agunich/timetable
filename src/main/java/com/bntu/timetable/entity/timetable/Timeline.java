package com.bntu.timetable.entity.timetable;

import com.bntu.timetable.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "timeline")
public class Timeline extends BaseEntity {

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "academic_hours")
    private Double academicHours;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    @JsonIgnore
    private Shift shift;

}
