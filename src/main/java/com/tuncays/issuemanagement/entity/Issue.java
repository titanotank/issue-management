package com.tuncays.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "detail", length = 1000)
    private String detail;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "issue_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assigne;

    @JoinColumn(name = "issue_project_id")
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private Project project;


}
