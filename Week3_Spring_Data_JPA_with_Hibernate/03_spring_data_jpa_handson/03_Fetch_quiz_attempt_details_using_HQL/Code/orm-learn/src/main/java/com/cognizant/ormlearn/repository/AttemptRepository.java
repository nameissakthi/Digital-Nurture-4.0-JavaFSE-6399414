package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    @Query("SELECT a FROM Attempt a " +
           "JOIN FETCH a.user u " +
           "JOIN FETCH a.attemptQuestions aq " +
           "JOIN FETCH aq.question q " +
           "JOIN FETCH aq.attemptOptions ao " +
           "JOIN FETCH ao.option o " +
           "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
