package com.tuncays.issuemanagement.service.impl;

import com.tuncays.issuemanagement.entity.IssueHistory;
import com.tuncays.issuemanagement.repository.IssueHistoryRepository;
import com.tuncays.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueStory) {

        if(issueStory.getDate() == null){
            throw new IllegalArgumentException("IssueDTO History Date can not be null!");
        }

        issueStory = issueHistoryRepository.save(issueStory);
        return issueStory;
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
