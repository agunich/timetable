package com.bntu.timetable.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "registration_token")
public class RegistrationToken {

    @Id
    private UUID id;

    private Date expiryDate;

    public RegistrationToken() {
    }

}
