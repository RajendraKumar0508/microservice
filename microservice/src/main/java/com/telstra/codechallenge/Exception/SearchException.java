package com.telstra.codechallenge.Exception;
public class SearchException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
  
    public String getErrorMessage() {
        return errorMessage;
    }
    public SearchException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public SearchException() {
        super();
    }
}
