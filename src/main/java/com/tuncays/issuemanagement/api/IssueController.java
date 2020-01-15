package com.tuncays.issuemanagement.api;


import com.tuncays.issuemanagement.dto.IssueDTO;
import com.tuncays.issuemanagement.service.impl.IssueServiceImpl;
import com.tuncays.issuemanagement.util.ApiPaths;
import com.tuncays.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;

@RestController
@RequestMapping(ApiPaths.IssueCTRL.CTRL)
@Api(value = ApiPaths.IssueCTRL.CTRL, description = "Issues APIs")
public class IssueController {

    private final IssueServiceImpl issueService;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueService = issueServiceImpl;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDTO.class)
    public ResponseEntity<IssueDTO> getById(@PathVariable("id") Long id) {

        IssueDTO issueDTO = issueService.getById(id);
        return ResponseEntity.ok(issueDTO);

    }

    @PostMapping

    @ApiOperation(value = "Create Operation", response = IssueDTO.class)
    public ResponseEntity<IssueDTO> createIssue(@Valid @RequestBody IssueDTO issue) {
        issue = issueService.save(issue);
        return ResponseEntity.ok(issue);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = IssueDTO.class)
    public ResponseEntity<IssueDTO> updateIssue(@PathVariable("id") Long id, @Valid @RequestBody IssueDTO issue) {
        IssueDTO issueDTO = issueService.update(id, issue);
        return ResponseEntity.ok(issueDTO);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = IssueDTO.class)
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(name = "id", required = true) Long id) {
        return ResponseEntity.ok(issueService.delete(id));
    }

    @GetMapping("/page")
    public ResponseEntity<TPage<IssueDTO>> pageAll(org.springframework.data.domain.Pageable pageable){
        TPage<IssueDTO> allPageable = issueService.getAllPageable(pageable);
        return ResponseEntity.ok(allPageable);
    }
}

