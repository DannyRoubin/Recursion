public class ItemNotFoundException extends RuntimeException {
    String message;
    public ItemNotFoundException() {
    }
    public ItemNotFoundException(String errorMsg) {
        this.message = errorMsg;
    }
    public String getMessage() {
        return message;
    }
}
