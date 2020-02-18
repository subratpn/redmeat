package store.redmeat.exceptions;

import javax.security.sasl.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {

    public InvalidCredentialsException(String msg) {
        super(msg);
    }
}
