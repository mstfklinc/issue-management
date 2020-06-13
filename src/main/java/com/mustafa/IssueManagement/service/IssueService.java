package com.mustafa.IssueManagement.service;

import com.mustafa.IssueManagement.dto.IssueDto;
import com.mustafa.IssueManagement.entity.Issue;
import com.mustafa.IssueManagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {

    IssueDto save(IssueDto issue);
    IssueDto getById(Long id);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(Long issueId);
    IssueDto update(Long id, IssueDto project);
}
