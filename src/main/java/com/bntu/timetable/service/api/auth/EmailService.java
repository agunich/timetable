package com.bntu.timetable.service.api.auth;

import com.bntu.timetable.entity.user.User;

public interface EmailService {
    void sendAccountActivationEmail(String tokenId, User user);
}
