package com.bntu.timetable.entity.classroom;


import com.bntu.timetable.entity.BaseEntity;
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
@Table(name = "building")
public class Building extends BaseEntity {

    @Column(name = "number", length = 100)
    private String number;

    @Column(name = "description", length = 10000)
    private String description;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Floor> floors;
}
