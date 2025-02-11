package com.bntu.timetable.service.impl.teacher;

import com.bntu.timetable.entity.teacher.AcademicTitle;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.teacher.AcademicTitleRepository;
import com.bntu.timetable.service.api.teacher.AcademicTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AcademicTitleServiceImpl implements AcademicTitleService {

    @Autowired
    private AcademicTitleRepository academicTitleRepository;

    @Override
    public AcademicTitle getAcademicTitle(UUID id) {
        return getAcademicTitleById(id);
    }

    @Override
    public List<AcademicTitle> getAcademicTitles() {
        return academicTitleRepository.findAll();
    }

    @Override
    public AcademicTitle createAcademicTitle(AcademicTitle academicTitle) {
        return academicTitleRepository.save(academicTitle);
    }

    @Override
    public AcademicTitle updateAcademicTitle(AcademicTitle academicTitleDto) {
        AcademicTitle academicTitle = getAcademicTitle(academicTitleDto.getId());
        academicTitle.setName(academicTitleDto.getName());

        return academicTitleRepository.save(academicTitle);
    }

    @Override
    public void deleteAcademicTitle(UUID id) {
        academicTitleRepository.deleteById(id);
    }

    private AcademicTitle getAcademicTitleById(UUID id) {
        AcademicTitle academicTitle = academicTitleRepository.findById(id).orElse(null);
        if (academicTitle == null) {
            throw new RuntimeException(ErrorMessage.DEANERY_NOT_FOUND);
        }
        return academicTitle;
    }
}
