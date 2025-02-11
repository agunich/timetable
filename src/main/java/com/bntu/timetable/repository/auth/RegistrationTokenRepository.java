package com.bntu.timetable.repository.auth;

import com.bntu.timetable.entity.user.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, UUID> {

}
