package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    private SkillRepository skillRepository;

    public SkillService(@Autowired SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill get(int id) {
        return skillRepository.findById(id).orElse(null);
    }
}