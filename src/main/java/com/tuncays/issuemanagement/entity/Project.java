package com.tuncays.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_code",length = 30, unique = true)
    private String projectCode;

    @Column(name = "project_name",length = 300)
    private String projectName;

    @JoinColumn(name = "project_manager_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User manager;

}
