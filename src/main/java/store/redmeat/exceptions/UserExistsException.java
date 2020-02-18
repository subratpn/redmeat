package store.redmeat.exceptions;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String msg) {
        super(msg);
    }

}
