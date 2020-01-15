package com.tuncays.issuemanagement.dto;

import com.tuncays.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import java.util.Date;


// getter setterleri olmazsa model mapper calısmaz ayrıca dbden null gelmeside dto map hatası verir.
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDTO {

     @ApiModelProperty(value = "Issue id")
     private Long id;
     @ApiModelProperty(value = "Issue description")
     private String description;
     @ApiModelProperty(value = "Issue detail")
     private String detail;
     @ApiModelProperty(value = "Issue date")
     private Date date;
     @ApiModelProperty(value = "Issue status")
     private IssueStatus issueStatus;

     @ApiModelProperty(value = "Issue user")
     private UserDTO assigne;
     @ApiModelProperty(value = "Issue project")
     private ProjectDTO project;

}
