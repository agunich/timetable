package com.bntu.timetable.entity.studyplan.structure;

import com.bntu.timetable.entity.BaseEntity;


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
@Table(name = "discipline_load")
public class DisciplineLoad extends BaseEntity {

    @Column(name = "hours")
    private Double hours;

    @ManyToOne
    @JoinColumn(name = "load_id")
    private Load load;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    @JsonIgnore
    private Discipline discipline;
}
