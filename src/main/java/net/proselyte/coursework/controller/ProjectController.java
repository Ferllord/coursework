package net.proselyte.coursework.controller;

import net.proselyte.coursework.model.Project;
import net.proselyte.coursework.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProjectController {
    private final ProjectService projectService;


    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String findAll(Model model){
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project-list";
    }

    @GetMapping("/project-create")
    public String createProjectForm(Project project){
        return "project-create";
    }

    @PostMapping("/project-create")
    public String createProject(Project project){
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    @GetMapping("project-delete/{id}")
    public String delete(@PathVariable("id") Long id){
        projectService.deleteById(id);
        return "redirect:/projects";
    }

    @GetMapping("/project-update/{id}")
    public String updateProjectForm(@PathVariable("id") Long id, Model model){
        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        return "project-update";
    }

    @PostMapping("/project-update")
    public String updateProject(Project project){
        projectService.saveProject(project);
        return "redirect:/projects";
    }
}
