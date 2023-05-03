package net.proselyte.coursework.controller;

import net.proselyte.coursework.model.WorkTime;
import net.proselyte.coursework.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkTimeController {
    private final WorkTimeService workTimeService;

    @Autowired
    public WorkTimeController(WorkTimeService workTimeService){
        this.workTimeService = workTimeService;
    }

    @GetMapping("/work_time")
    public String findAll(Model model){
        List<WorkTime> worktimes = workTimeService.findAll();
        model.addAttribute("worktimes", worktimes);
        return "work_time-list";
    }

    @GetMapping("/work_time-create")
    public String createWorkTimeForm(WorkTime workTime){
        return "work_time-create";
    }

    @PostMapping("/work_time-create")
    public String createWorkTime(WorkTime workTime){
        workTimeService.saveWorkTime(workTime);
        return "redirect:/work_time";
    }

    @GetMapping("work_time-delete/{id}")
    public String delete(@PathVariable("id") Long id){
        workTimeService.deleteById(id);
        return "redirect:/work_time";
    }

    @GetMapping("/work_time-update/{id}")
    public String updateWorkTimeForm(@PathVariable("id") Long id, Model model){
        WorkTime workTime = workTimeService.findById(id);
        model.addAttribute("workTime", workTime);
        return "work_time-update";
    }

    @PostMapping("/work_time-update")
    public String updateWorkTime(WorkTime workTime){
        workTimeService.saveWorkTime(workTime);
        return "redirect:/work_time";
    }

}
