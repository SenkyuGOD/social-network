package com.senkyu.socialnetwork.chat.repository;

import com.senkyu.socialnetwork.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("SELECT c FROM Chat c WHERE (c.userOne.id = :userOneId AND c.userTwo.id = :userTwoId) " +
            "OR (c.userOne.id = :userTwoId AND c.userTwo.id = :userOneId)")
    Optional<Chat> findChatByUsersIds(@Param("userOneId") Long userOneId, @Param("userTwoId") Long userTwoId);

    @Query("SELECT c FROM Chat  c WHERE c.userOne.id = :userId OR  c.userTwo.id = :userId")
    List<Chat> findAllByUsersId(Long userId);
}