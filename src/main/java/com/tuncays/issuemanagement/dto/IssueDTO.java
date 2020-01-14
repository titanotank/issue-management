package com.tuncays.issuemanagement.dto;

import com.tuncays.issuemanagement.entity.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.util.Date;


// getter setterleri olmazsa model mapper calısmaz ayrıca dbden null gelmeside dto map hatası verir.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDTO {

     private Long id;
     private String description;
     private String detail;
     private Date date;
     private IssueStatus issueStatus;
     private UserDTO assigne;
     private ProjectDTO project;

}
