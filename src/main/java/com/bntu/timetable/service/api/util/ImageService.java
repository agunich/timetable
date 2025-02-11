package com.bntu.timetable.service.api.util;


import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ImageService {

    String save(String image) throws GeneralSecurityException, IOException;

    void delete(String imageId) throws GeneralSecurityException, IOException;

}

