package com.bntu.timetable.entity.classroom;

import com.bntu.timetable.entity.BaseEntity;
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
@Table(name = "wing")
public class Wing extends BaseEntity {

    @Column(name = "name", length = 1000)
    private String name;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    @JsonIgnore
    private Floor floor;

    @OneToMany(mappedBy = "wing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classroom> classrooms;

    @Column(name = "plan_image", length = 500000)
    private String planImage;

}
