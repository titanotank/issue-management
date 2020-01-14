package com.tuncays.issuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private int id;
    @NotNull
    private String projectCode;
    @NotNull
    private String projectName;
}
