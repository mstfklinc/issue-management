package com.mustafa.IssueManagement.entity;



import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity //Bir database yapısı olduğunu ifade eder.
@Table(name = "issue") //Tablo adı
@Data //Otomatik getter ve stter mtodları yaratır.
@NoArgsConstructor //Boş bir constructor yaratır.
@AllArgsConstructor //Parametreli constructor yaratır.
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    //ManyToOne ile relational işlemi yapılıyor.
    //Birçok issue class'ı bir tane user ile ilişkilendirilebilir.
    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;

}
