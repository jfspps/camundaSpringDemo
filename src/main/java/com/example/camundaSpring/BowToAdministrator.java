package com.example.camundaSpring;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

// this represents a service task (see Tasklist in Camunda Modeler); use Named annotation to make it callable to Camunda
// delegate expression (note class name is given with first character in lower-case i.e. reference "bowToAdministrator"
@Named
public class BowToAdministrator implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String password;

        String username = (String) delegateExecution.getVariable("accountUsername");
        System.out.println("Username: " + username);

        String description = (String) delegateExecution.getVariable("description");
        System.out.println("Description found: " + description);

        if (username.isBlank()){
            password = "abcdefg";
        } else
            password = "admin";

        System.out.println("Password set to: " + password);
        delegateExecution.setVariable("accountPassword", password);
    }
}
