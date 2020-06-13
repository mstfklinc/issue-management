package com.mustafa.IssueManagement.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {


    @ApiModelProperty(required = true, value = "Project ID")
    private Long id;

    @NotNull //Project name null olamaz.
    @ApiModelProperty(required = true, value = "Name of Project") //Not null olduğu için true
    private String projectName;

    @NotNull //Project code null olamaz.
    @ApiModelProperty(required = true, value = "Date of Project")
    private String projectCode;

}
