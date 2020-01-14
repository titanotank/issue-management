package com.tuncays.issuemanagement.dto;

import com.tuncays.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDTO {

     private Long id;
     private String description;
     private String detail;
     private Date date;
     private IssueStatus issueStatus;
     private UserDTO assigne;
     private ProjectDTO project;

}
