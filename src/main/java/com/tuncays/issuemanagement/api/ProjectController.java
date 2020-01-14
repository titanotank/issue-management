package com.tuncays.issuemanagement.api;

import com.tuncays.issuemanagement.dto.ProjectDTO;
import com.tuncays.issuemanagement.entity.Project;
import com.tuncays.issuemanagement.repository.ProjectRepository;
import com.tuncays.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable("id") Long id){

        ProjectDTO projectDTO = projectService.getById(id);
        return ResponseEntity.ok(projectDTO);

    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO project) {
        project = projectService.save(project);
        return ResponseEntity.ok(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id,@Valid @RequestBody ProjectDTO project){
        ProjectDTO projectDTO = projectService.update(id,project);
        return ResponseEntity.ok(projectDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject( @PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(projectService.delete(id));
    }


}
