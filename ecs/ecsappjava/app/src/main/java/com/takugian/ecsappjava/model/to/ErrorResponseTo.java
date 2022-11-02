package com.takugian.ecsappjava.model.to;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseTo {

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_description")
    private String errorDescription;

    public ErrorResponseTo() {

    }

    public ErrorResponseTo(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "{" +
                " errorCode='" + getErrorCode() + "'" +
                ", errorDescription='" + getErrorDescription() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ErrorResponseTo)) {
            return false;
        }
        ErrorResponseTo errorResponseTo = (ErrorResponseTo) o;
        return Objects.equals(errorCode, errorResponseTo.errorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}
