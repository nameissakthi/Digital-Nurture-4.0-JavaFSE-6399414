package com.cognizant.springlearn.aspect;

import com.cognizant.springlearn.SpringLearnApplication;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloAspect.class);

    @Before("execution(String com.cognizant.springlearn.controller.HelloController.sayHello())")
    public void beforeHelloLogger() {
        LOGGER.info("Before sayHello() Method");
    }

    @After("execution(String com.cognizant.springlearn.controller.HelloController.sayHello())")
    public void afterHelloLogger() {
        LOGGER.info("After sayHello() Method");
    }
}
