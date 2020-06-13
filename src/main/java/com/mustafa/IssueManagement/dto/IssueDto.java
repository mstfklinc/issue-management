package com.mustafa.IssueManagement.dto;

import com.mustafa.IssueManagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDto {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private IssueDto assignee;
    private ProjectDto project;
}
