package dev.protobot.blogrestapi.exceptions;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrEmptyStringException;
import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrZeroLongException;
import dev.protobot.blogrestapi.exceptions.helper.shared.HelperStringCanNotHaveAnyNumberException;
import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    //Categories Controller Exceptions
    //..
    //Blog Controller Exceptions
    //..

    //Helper Exceptions
    CATEGORY_BAD_PREREQUISITES(HelperCheckIfNullOrEmptyStringException.class, HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_BE_ZERO(HelperCheckIfNullOrZeroLongException.class, HttpStatus.PRECONDITION_FAILED),
    HELPER_STRING_CANT_HAVE_ANY_NUMBER(HelperStringCanNotHaveAnyNumberException.class, HttpStatus.PRECONDITION_FAILED);



    private Class<? extends Throwable> exceptionClass;
    private HttpStatus status;
    private SupportedExceptions(Class<? extends Throwable>exception, HttpStatus status){
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class <? extends Throwable> getExceptionClass(){
        return this.exceptionClass;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}