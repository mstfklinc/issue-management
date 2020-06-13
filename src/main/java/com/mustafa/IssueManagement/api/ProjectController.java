package com.mustafa.IssueManagement.api;

import com.mustafa.IssueManagement.dto.ProjectDto;
import com.mustafa.IssueManagement.service.Implementation.ProjectServiceImplementation;
import com.mustafa.IssueManagement.util.ApiPaths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //Bu annotation Project controllerin bir controller olduğunu ifade eder.
@RequestMapping(ApiPaths.ProjectController.Controller)
@Slf4j
public class ProjectController {

    //Tüm controllerler içerisinde HTTPm metodları bağlanacak.
    //GET, PUT, POST, DELETE

    private final ProjectServiceImplementation projectServiceImplementation;

    public ProjectController(ProjectServiceImplementation projectServiceImplementation) {
        this.projectServiceImplementation = projectServiceImplementation;
    }

    //GET
    //Response Entity,Api metodlarımızın ve tğm web servislerimizin dışarıda aynı imzaya sahip olmasını sağlar,
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id){
        log.info("Project Controller -> GetById -> Param : " + id);
        log.debug("Project Controller -> GetById -> Param : " + id);
        ProjectDto projectDto = projectServiceImplementation.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    //POST
    @PostMapping()
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImplementation.save(projectDto));
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImplementation.update(id,project));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(projectServiceImplementation.delete(id));
    }
}
