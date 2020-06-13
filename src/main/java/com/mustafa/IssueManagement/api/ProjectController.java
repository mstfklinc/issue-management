package com.mustafa.IssueManagement.api;

import com.mustafa.IssueManagement.dto.ProjectDto;
import com.mustafa.IssueManagement.service.Implementation.ProjectServiceImplementation;
import com.mustafa.IssueManagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //Bu annotation Project cpntrollerin bir controller olduğunu ifade eder.
@RequestMapping(ApiPaths.ProjectController.Controller)
@Api(value = "Project Apis")
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
    @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id){
        ProjectDto projectDto = projectServiceImplementation.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    //POST
    @PostMapping()
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImplementation.save(projectDto));
    }

    //PUT
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImplementation.update(id,project));
    }

    //DELETE
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(projectServiceImplementation.delete(id));
    }
}
