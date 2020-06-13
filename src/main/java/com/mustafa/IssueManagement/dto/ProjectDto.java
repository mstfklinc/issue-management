package com.mustafa.IssueManagement.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProjectDto {



    private Long id;

    @NotNull //Project name null olamaz.
    private String projectName;

    @NotNull //Project code null olamaz.
    private String projectCode;

}
