package com.tuncays.issuemanagement.service;

import com.tuncays.issuemanagement.entity.Issue;
import com.tuncays.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {



    Project save(Project project) throws IllegalAccessException;

    Project getById(Long id);

    Project getByProjectCode(String projectCode);

    Project getByProjectCodeContains(String contains);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);


}