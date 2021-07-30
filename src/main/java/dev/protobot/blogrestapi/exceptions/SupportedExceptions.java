package dev.protobot.blogrestapi.exceptions;

import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrEmptyStringException;
import dev.protobot.blogrestapi.exceptions.helper.shared.HelperCheckIfNullOrZeroLongException;
import dev.protobot.blogrestapi.exceptions.helper.shared.HelperStringCanNotHaveAnyNumberException;
import dev.protobot.blogrestapi.exceptions.helper.shared.ShouldNotExistEntityInDatabaseException;
import dev.protobot.blogrestapi.exceptions.service.author.AuthorDoesntExistInDatabaseException;
import dev.protobot.blogrestapi.exceptions.service.category.CategoryDoesntExistInDatabaseException;
import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    //Categories Controller Exceptions
    //..

    //Author Service Exceptions
    AUTHOR_DOESNT_EXIST_DATABASE(AuthorDoesntExistInDatabaseException.class, HttpStatus.NO_CONTENT),

    //Category Service Exceptions
    CATEGORY_DOESNT_EXIST_DATABASE(CategoryDoesntExistInDatabaseException.class, HttpStatus.NO_CONTENT),

    //Helper Exceptions
    SHOULD_NOT_EXIST_IN_DATABASE(ShouldNotExistEntityInDatabaseException.class, HttpStatus.CONFLICT),
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