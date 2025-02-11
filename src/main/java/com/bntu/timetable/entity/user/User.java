package com.bntu.timetable.entity.user;

import com.bntu.timetable.entity.BaseEntity;
import com.bntu.timetable.entity.Deanery;
import com.bntu.timetable.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", length = 1000)
    private String firstName;

    @Column(name = "last_name", length = 1000)
    private String lastName;

    @Column(name = "patronymic", length = 1000)
    private String patronymic;

    @Column(name = "email", length = 1000)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "password", length = 1000)
    @JsonIgnore
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "deanery_id")
    private Deanery deanery;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
