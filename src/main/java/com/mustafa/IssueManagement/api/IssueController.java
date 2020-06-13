package com.mustafa.IssueManagement.api;

import com.mustafa.IssueManagement.dto.IssueDto;
import com.mustafa.IssueManagement.service.Implementation.IssueServiceImplementation;
import com.mustafa.IssueManagement.util.ApiPaths;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueController.Controller)
public class IssueController {

    private final IssueServiceImplementation issueServiceImplementation;


    public IssueController(IssueServiceImplementation issueServiceImplementation) {
        this.issueServiceImplementation = issueServiceImplementation;
    }

    //GET
    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id){
            IssueDto projectDto =issueServiceImplementation.getById(id);
            return ResponseEntity.ok(projectDto);
    }

    //POST
    @PostMapping()
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplementation.save(project));
    }

    //PUT
    @PutMapping()
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplementation.update(id, project));
    }

    //DELETE
    @DeleteMapping()
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id){
        return ResponseEntity.ok(issueServiceImplementation.delete(id));
    }
}
