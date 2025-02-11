package com.bntu.timetable.entity.studyplan.structure;

import com.bntu.timetable.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "component")
public class Component extends BaseEntity {

    @Column(name = "name", length = 1000)
    private String name;

    @Enumerated(EnumType.STRING)
    private ComponentType componentType;

    @Column(name = "position")
    private Integer position;

    @Column(name = "total_hours")
    private Double totalHours;

    @Column(name = "classroom_hours")
    private Double classroomHours;

    @Column(name = "credit_units")
    private Double creditUnits;

    @Column(name = "description", length = 10000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "cycle_id")
    @JsonBackReference(value = "cycle-component")
    private Cycle cycle;

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "component-discipline")
    private List<Discipline> disciplines;
}
