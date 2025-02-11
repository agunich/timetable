package com.bntu.timetable.entity.timetable;

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
@Table(name = "shift")
public class Shift extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "shift")
    private List<Timeline> timelines;

}
