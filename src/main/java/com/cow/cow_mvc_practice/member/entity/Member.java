package com.cow.cow_mvc_practice.member.entity;

import java.util.ArrayList;
import java.util.List;

import com.cow.cow_mvc_practice.post.entity.Post;

import com.cow.cow_mvc_practice.utill.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "member_id"))
public class Member extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private final List<Post> posts = new ArrayList<>();

    @Builder
    private Member(final String name) {
        this.name = name;
    }

    public static Member from(String name) {
        return Member.builder()
                .name(name)
                .build();
    }

    public void updateName(String name) {
        this.name = name;
    }
}
