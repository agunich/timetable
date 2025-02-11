package com.bntu.timetable.entity.teacher;

import com.bntu.timetable.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "academic_title")
public class AcademicTitle extends BaseEntity {

    @Column(name = "name", length = 1000)
    private String name;
}
