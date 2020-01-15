package com.tuncays.issuemanagement.service.impl;

import com.tuncays.issuemanagement.dto.IssueDTO;
import com.tuncays.issuemanagement.entity.Issue;
import com.tuncays.issuemanagement.repository.IssueRepository;
import com.tuncays.issuemanagement.service.IssueService;
import com.tuncays.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
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

        Issue issuedb = issueRepository.getOne(id);

        IssueDTO issue = modelMapper.map(issuedb,IssueDTO.class);

        return issue;
    }

    @Override
    public TPage<IssueDTO> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);

        TPage<IssueDTO> page = new TPage<IssueDTO>();

        page.setStats(data, Arrays.asList(modelMapper.map(data.getContent(),IssueDTO[].class)));

        return page;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return  Boolean.TRUE;
    }

    @Override
    public IssueDTO update(Long id, IssueDTO issue) {
        return null;
    }
}
