package com.bntu.timetable.entity.classroom;

import com.bntu.timetable.entity.BaseEntity;
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
@Table(name = "classroom_type")
public class ClassroomType extends BaseEntity {

    @Column(name = "name", length = 1000)
    private String name;

    @Column(name ="color", length = 100)
    private String color;

}
