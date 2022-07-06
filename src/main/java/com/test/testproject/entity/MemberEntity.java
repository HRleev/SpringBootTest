package com.test.testproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "member_test_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column (unique = true ,length = 30)
    private String member_email;

    @Column(nullable = false , length = 50)
    private String member_password;

    @Column(length = 500)
    private String member_name;

    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL,orphanRemoval = true ,fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntityList=new ArrayList<>();
}
