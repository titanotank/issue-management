package com.tuncays.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity  implements Serializable {


    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "created_By", length = 100)
    private String createdBy;

    @Column(name = "updated_At")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_By", length = 100)
    private String updatedBy;

    @Column(name = "issue_status")
    private IssueStatus issueStatus;

}
