package com.tuncays.issuemanagement.service;

import com.tuncays.issuemanagement.dto.ProjectDTO;
import com.tuncays.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface ProjectService {



    ProjectDTO save(ProjectDTO project) throws IllegalAccessException;

    ProjectDTO getById(Long id);

    ProjectDTO getByProjectCode(String projectCode);

    ProjectDTO getByProjectCodeContains(String contains);

    TPage<ProjectDTO> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    ProjectDTO update(Long id,ProjectDTO projectDTO);


}