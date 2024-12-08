package com.senkyu.socialnetwork.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senkyu.socialnetwork.user.model.User;
import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_one_id")
    @JsonIgnore
    private User userOne;

    @ManyToOne
    @JoinColumn(name = "user_two_id")
    @JsonIgnore
    private User userTwo;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Chat(Long id, User userOne, User userTwo, LocalDateTime createdAt) {
        this.id = id;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.createdAt = createdAt;
    }

    public Chat() {
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Chat chat = (Chat) o;
        return getId() != null && Objects.equals(getId(), chat.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public Long getId() {
        return this.id;
    }

    public User getUserOne() {
        return this.userOne;
    }

    public User getUserTwo() {
        return this.userTwo;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public void setUserTwo(User userTwo) {
        this.userTwo = userTwo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}