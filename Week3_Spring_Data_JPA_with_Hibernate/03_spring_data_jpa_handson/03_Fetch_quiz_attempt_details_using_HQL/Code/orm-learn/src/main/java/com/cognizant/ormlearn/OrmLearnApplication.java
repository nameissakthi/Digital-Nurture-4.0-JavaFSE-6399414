package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAttemptDetail();
    }

    public void testGetAttemptDetail() {
        Attempt attempt = attemptService.getAttempt(1, 1);

        if (attempt == null) {
            System.out.println("No attempt found with userId = 1 and attemptId = 101");
            return;
        }

        System.out.println("Attempt ID: " + attempt.getId());
        System.out.println("User ID: " + attempt.getUser().getId());
        System.out.println("Attempt Date: " + attempt.getAttemptDate());

        Set<AttemptQuestion> attemptQuestions = attempt.getAttemptQuestions();
        for (AttemptQuestion aq : attemptQuestions) {
            System.out.println("\nQuestion ID: " + aq.getQuestion().getId());
            System.out.println("Question Text: " + aq.getQuestion().getText());

            Set<AttemptOption> attemptOptions = aq.getAttemptOptions();
            for (AttemptOption ao : attemptOptions) {
                System.out.println("Option ID: " + ao.getOption().getId());
                System.out.println("Option Text: " + ao.getOption().getText());
                System.out.println("Selected: " + ao.isSelected());
            }
        }
    }
}
