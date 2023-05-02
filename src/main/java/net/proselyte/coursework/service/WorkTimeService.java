package net.proselyte.coursework.service;

import net.proselyte.coursework.model.Employee;
import net.proselyte.coursework.model.WorkTime;
import net.proselyte.coursework.repository.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;

    @Autowired
    public WorkTimeService(WorkTimeRepository workTimeRepository){
        this.workTimeRepository = workTimeRepository;
    }

    public WorkTime findById(Long id){
        return workTimeRepository.getOne(id);
    }

    public List<WorkTime> findAll(){
        return workTimeRepository.findAll();
    }

    public WorkTime saveWorkTime(WorkTime workTime){
        return workTimeRepository.save(workTime);
    }

    public void deleteById(Long id){
        workTimeRepository.deleteById(id);
    }
}
