package com.tuncays.issuemanagement.repository;

import com.tuncays.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {




}
