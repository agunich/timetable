package com.bntu.timetable.service.impl.timetable;

import com.bntu.timetable.dto.timetable.TimetableCreateCommonInfo;
import com.bntu.timetable.dto.timetable.TimetableDialogCreateCommonInfo;

import com.bntu.timetable.dto.timetable.TimetableDiscipline;
import com.bntu.timetable.dto.timetable.TimetableDisciplineToGroupRequest;
import com.bntu.timetable.entity.Group;
import com.bntu.timetable.entity.studyplan.StudyPlan;
import com.bntu.timetable.entity.studyplan.schedule.Semester;
import com.bntu.timetable.entity.studyplan.structure.DisciplineHoursUnitsPerSemesters;
import com.bntu.timetable.entity.timetable.Timetable;
import com.bntu.timetable.entity.timetable.TimetableStatus;
import com.bntu.timetable.errorhandling.ErrorMessage;
import com.bntu.timetable.repository.timetable.TimetableRepository;
import com.bntu.timetable.service.api.classroom.BuildingService;
import com.bntu.timetable.service.api.deanery.DeaneryService;
import com.bntu.timetable.service.api.deanery.FlowService;
import com.bntu.timetable.service.api.studyplan.StudyPlanService;
import com.bntu.timetable.service.api.teacher.TeacherService;
import com.bntu.timetable.service.api.timetable.ShiftService;
import com.bntu.timetable.service.api.timetable.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private StudyPlanService studyPlanService;

    @Autowired
    private FlowService flowService;

    @Autowired
    private DeaneryService deaneryService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private TeacherService teacherService;


    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private ShiftService shiftService;


    @Override
    public Timetable getTimetable(UUID id) {
        return timetableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Timetable> getTimetables() {
        return timetableRepository.findAll();
    }

    @Override
    public List<Timetable> getTimetables(UUID deaneryId) {
        return timetableRepository.findAll();
    }

    @Override
    public Timetable createTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    @Override
    public Timetable updateTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    @Override
    public void deleteTimetable(UUID id) {
        timetableRepository.deleteById(id);
    }

    @Override
    public TimetableDialogCreateCommonInfo loadDialogCreateCommonInfo(UUID deaneryId) {
        TimetableDialogCreateCommonInfo commonInfo = new TimetableDialogCreateCommonInfo();
        commonInfo.setDeanery(this.deaneryService.getDeanery(deaneryId));
        commonInfo.setFlows(this.flowService.getFlowsByDeaneryId(deaneryId));
        commonInfo.setStudyPlans(this.studyPlanService.getStudyPlansByDeaneryId(deaneryId));
        commonInfo.setShifts(this.shiftService.getShifts());
        return commonInfo;
    }

    @Override
    public Map<List<Group>, List<TimetableDiscipline>> loadGroupToDisciplines(TimetableDisciplineToGroupRequest timetableDisciplineToGroupRequest) {
        Map<List<Group>, List<TimetableDiscipline>> groupsToDisciplines = new HashMap<>();
        for (Map.Entry<UUID, List<Group>> entry : timetableDisciplineToGroupRequest.getPlanToGroups().entrySet()) {
            StudyPlan studyPlan = this.studyPlanService.getStudyPlan(entry.getKey());
            Semester targetSemester = null;
            List<TimetableDiscipline> timetableDisciplines = new ArrayList<>();
            for (Semester sem : studyPlan.getSemesters()) {
                if (sem.getSemesterNum().equals(timetableDisciplineToGroupRequest.getTargetSemesterNum())) {
                    targetSemester = sem;
                    break;
                }
            }


            for (DisciplineHoursUnitsPerSemesters disc : targetSemester.getDisciplineHoursUnitsPerSemesters()) {
                TimetableDiscipline timetableDiscipline = new TimetableDiscipline();
                timetableDiscipline.setDiscipline(disc.getDiscipline());
                timetableDiscipline.setClassroomHours(disc.getClassroomHours());
                timetableDisciplines.add(timetableDiscipline);
            }

            groupsToDisciplines.put(entry.getValue(), timetableDisciplines);
        }
        return groupsToDisciplines;
    }

    @Override
    public Timetable changeTimetableStatus(UUID id, TimetableStatus status) {
        Optional<Timetable> timetable = this.timetableRepository.findById(id);
        if (timetable.isPresent()) {
//            timetable.get().setStatus(status);
//            timetable.get().setStatusChangeDate(LocalDateTime.now());
            return this.timetableRepository.save(timetable.get());
        } else {
            throw new RuntimeException(ErrorMessage.TIMETABLE_NOT_FOUND);
        }
    }

    @Override
    public TimetableCreateCommonInfo loadCreateCommonInfo() {
        TimetableCreateCommonInfo commonInfo = new TimetableCreateCommonInfo();
        commonInfo.setBuildings(this.buildingService.getBuildings());
        commonInfo.setTeachers(this.teacherService.getTeachers());
        return commonInfo;
    }
}
