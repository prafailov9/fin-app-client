package com.project.main.io.csv.exceptions;

/**
 *
 * @author prafailov
 */
public class ActionDoesntExistException extends RuntimeException {

    private final static String MESSAGE = "The specified action does not exist!";

    public ActionDoesntExistException() {
        super();
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }

}
