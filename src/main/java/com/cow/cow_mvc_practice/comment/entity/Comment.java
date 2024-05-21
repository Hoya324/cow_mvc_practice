package com.cow.cow_mvc_practice.comment.entity;

import com.cow.cow_mvc_practice.member.entity.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "comment_id")
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        private Member member;

        private String title;
        private String comment;

        @Builder
        private Comment(Member member, String title, String comment) {
            this.member = member;
            this.title = title;
            this.comment = comment;
        }

        public void update(String title, String comment) {
            this.title = title;
            this.comment = comment;
        }
}
