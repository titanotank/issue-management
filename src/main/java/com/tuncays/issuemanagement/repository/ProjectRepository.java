package com.tuncays.issuemanagement.repository;

import com.tuncays.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project getByProjectCode(String projectCode);

    Project getByProjectCodeContains(String contains);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

}
