package com.bntu.timetable.entity;

import com.bntu.timetable.entity.timetable.Timetable;
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
@Table(name = "deanery")
public class Deanery extends BaseEntity {

    @Column(name = "short_name", length = 100)
    private String shortName;

    @Column(name = "full_name", length = 1000)
    private String fullName;

    @Column(name = "description", length = 10000)
    private String description;

    @OneToMany(mappedBy = "deanery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments;

    @OneToMany(mappedBy = "deanery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flow> flows;

    @OneToMany(mappedBy = "deanery")
    @JsonIgnore
    private List<Timetable> timetables;

}
