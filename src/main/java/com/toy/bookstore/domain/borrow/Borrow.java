package com.toy.bookstore.domain.borrow;

import com.toy.bookstore.domain.book.Book;
import com.toy.bookstore.domain.user.Member;
import com.toy.bookstore.infrastructure.jpa.BorrowBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Borrow extends BorrowBaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
