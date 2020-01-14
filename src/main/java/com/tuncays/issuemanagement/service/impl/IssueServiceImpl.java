package com.tuncays.issuemanagement.service.impl;

import com.tuncays.issuemanagement.dto.IssueDTO;
import com.tuncays.issuemanagement.entity.Issue;
import com.tuncays.issuemanagement.repository.IssueRepository;
import com.tuncays.issuemanagement.service.IssueService;
import com.tuncays.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;


public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDTO save(IssueDTO issue) {

        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue date can not be null!");
        }

        Issue issueDb = modelMapper.map(issue,Issue.class);

        issueDb = issueRepository.save(issueDb);

        issue = modelMapper.map(issueDb,IssueDTO.class);
        return issue;
    }

    @Override
    public IssueDTO getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDTO> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);

        TPage<IssueDTO> page = new TPage<IssueDTO>();

        IssueDTO[] dtos = modelMapper.map(data,IssueDTO[].class);

        page.setStats(data, Arrays.asList(dtos));

        return page;
    }

    @Override
    public Boolean delete(IssueDTO issue) {
        return null;
    }
}
