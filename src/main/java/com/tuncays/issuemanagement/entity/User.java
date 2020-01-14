package com.tuncays.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "uname",length = 100,unique = true)
    private String username;

    @Column (name = "pwd",length = 100)
    private String password;


    @Column (name = "nameSurname",length = 100)
    private String nameSurname;

    @Column (name = "email",length = 100)
    private String email;

    @JoinColumn(name = "assegne_issue_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issue;


}
