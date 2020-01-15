package com.tuncays.issuemanagement.service.impl;

import com.tuncays.issuemanagement.dto.ProjectDTO;
import com.tuncays.issuemanagement.entity.Project;
import com.tuncays.issuemanagement.repository.ProjectRepository;
import com.tuncays.issuemanagement.service.ProjectService;
import com.tuncays.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {

        //Aynı proje coduna göre kayıt var mı diye bakacağız

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck != null){
            throw new IllegalArgumentException("Project Code is exist!");
        }



        Project projectdb = modelMapper.map(project,Project.class);

        projectdb = projectRepository.save(projectdb);

        project = modelMapper.map(projectdb,ProjectDTO.class);
        return project;
    }

    @Override
    public ProjectDTO getById(Long id) {

        Project projectdb = projectRepository.getOne(id);

        ProjectDTO project = modelMapper.map(projectdb,ProjectDTO.class);

        return project;
    }

    @Override
    public ProjectDTO getByProjectCode(String projectCode) {

        Project projectdb = projectRepository.getByProjectCode(projectCode);
        ProjectDTO project =modelMapper.map(projectdb,ProjectDTO.class);

        return project;
    }

    @Override
    public ProjectDTO getByProjectCodeContains(String contains) {
        return null;
    }

    @Override
    public TPage<ProjectDTO> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDTO> respnose = new TPage<>();
        respnose.setStats(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDTO[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public ProjectDTO update(Long id,ProjectDTO project) {

        // Verilen id ye göre kayıt var mı
        Project projectdb = projectRepository.getOne(id);

        if(projectdb == null){
            throw new IllegalArgumentException("Project does not exist by givin id: !" + id);
        }
        // Güncellenmek istenen değerde project codu varmı, kendisi haric
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck != null && projectCheck.getId() != projectdb.getId()){
            throw new IllegalArgumentException("Project Code is exist!");
        }

        // değerleri set edip yollayacağız
        projectdb.setProjectCode(project.getProjectCode());
        projectdb.setProjectName(project.getProjectName());

        projectdb = projectRepository.save(projectdb);
        project = modelMapper.map(projectdb,ProjectDTO.class);

        return project;
    }
}
