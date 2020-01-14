package com.tuncays.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Issue_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IssueHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description",length = 1000)
    private String description;

    @JoinColumn(name = "story_issue_id")
    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    private Issue issue;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @Column(name = "details",length = 1000)
    private String details;

    @JoinColumn(name = "story_user_id")
    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    private User assignee;

}
