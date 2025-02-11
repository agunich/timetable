package com.bntu.timetable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "flow")
public class Flow extends BaseEntity {
    @Column(name = "name", length = 1000)
    private String name;

    @ManyToOne
    @JoinColumn(name = "deanery_id")
    @JsonIgnoreProperties(value = {"departments", "flows"}, allowSetters = true)
    private Deanery deanery;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "flow_groups",
            joinColumns = {@JoinColumn(name = "flow_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {
                    "flow_id", "group_id"}))
    private List<Group> groups;
    
}
