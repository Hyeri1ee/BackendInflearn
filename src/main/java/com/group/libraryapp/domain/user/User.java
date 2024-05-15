package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 20, name = "name") //name varchar(20)
    private String name;
    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "user") //주인이 가진 필드 이름
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void updateName(String name){
        this.name = name;
    }

    public User(String name, int age) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        this.name = name;
        this.age = age;
    }

}
