package com.mustafa.IssueManagement.repository;

import com.mustafa.IssueManagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
