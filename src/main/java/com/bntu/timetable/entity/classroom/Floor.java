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
@Table(name = "floor")
public class Floor extends BaseEntity {

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "building_id")
    @JsonIgnore
    private Building building;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wing> wings;

}
