package com.mustafa.IssueManagement.service;

import com.mustafa.IssueManagement.dto.ProjectDto;
import com.mustafa.IssueManagement.entity.Issue;
import com.mustafa.IssueManagement.entity.Project;
import com.mustafa.IssueManagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);
    ProjectDto getById(Long id);
    TPage<ProjectDto> getAllPageable(Pageable pageable);
    ProjectDto getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);
    Boolean delete(Project project);
    ProjectDto update(Long id, ProjectDto project);
}
