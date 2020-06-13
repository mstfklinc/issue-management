package com.mustafa.IssueManagement.service.Implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustafa.IssueManagement.dto.ProjectDto;
import com.mustafa.IssueManagement.entity.Project;
import com.mustafa.IssueManagement.repository.ProjectRepository;
import com.mustafa.IssueManagement.service.ProjectService;
import com.mustafa.IssueManagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImplementation implements ProjectService {

    public final ProjectRepository projectRepository;
    public final ModelMapper modelMapper;


    public ProjectServiceImplementation(ProjectRepository projectRepository,ModelMapper modelMapper ) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null){
            throw new IllegalArgumentException("Project code already exist!");
        }

        Project p = modelMapper.map(project,Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {

        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);

    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {

        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }


    @Override
    public Boolean delete(Project project) {
        return null;
    }

    public Boolean delete(Long id) {
       projectRepository.deleteById(id);
       return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {

        //Validation
        Project projectDb = projectRepository.getOne(id);
        if(projectDb == null){
            throw new IllegalArgumentException("Project Code Does not exist ID : " + id);
        }

        //Bussiness Logic
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck != null && projectCheck.getId() != projectDb.getId()) {
            throw new IllegalArgumentException("Project already exist!");
        }

        projectDb.setProjectName(project.getProjectName());
        projectDb.setProjectCode(project.getProjectCode());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);

    }
}
