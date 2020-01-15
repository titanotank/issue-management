package com.tuncays.issuemanagement.api;

import com.tuncays.issuemanagement.dto.ProjectDTO;
import com.tuncays.issuemanagement.service.impl.ProjectServiceImpl;
import com.tuncays.issuemanagement.util.ApiPaths;
import com.tuncays.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCTRL.CTRL)
@Api(value = ApiPaths.ProjectCTRL.CTRL, description = "Project APIs")
@Slf4j
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> getById(@PathVariable("id") Long id){
        log.info("asodsakdosakd");
        log.debug("aoskdoaksd params:" + id);
        ProjectDTO projectDTO = projectService.getById(id);
        return ResponseEntity.ok(projectDTO);

    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO project) {
        project = projectService.save(project);
        return ResponseEntity.ok(project);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id,@Valid @RequestBody ProjectDTO project){
        ProjectDTO projectDTO = projectService.update(id,project);
        return ResponseEntity.ok(projectDTO);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject( @PathVariable(name = "id", required = true) Long id){
        return ResponseEntity.ok(projectService.delete(id));
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDTO.class)
    public ResponseEntity<TPage<ProjectDTO>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDTO> data = projectService.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


}
