package com.tuncays.issuemanagement.service;

import com.tuncays.issuemanagement.dto.IssueDTO;
import com.tuncays.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;


public interface IssueService {


    IssueDTO save(IssueDTO issue);

    IssueDTO getById(Long id);

    TPage<IssueDTO> getAllPageable(Pageable pageable);

    Boolean delete(Long id);


    IssueDTO update(Long id, IssueDTO issue);
}
