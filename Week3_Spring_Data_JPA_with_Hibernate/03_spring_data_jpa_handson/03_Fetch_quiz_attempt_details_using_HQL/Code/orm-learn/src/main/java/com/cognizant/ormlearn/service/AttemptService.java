package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {

    private AttemptRepository attemptRepository;

    public AttemptService(@Autowired AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    public Attempt getAttempt(int userId, int attemptId) {
        return attemptRepository.getAttempt(userId, attemptId);
    }
}