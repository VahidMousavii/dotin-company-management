package ir.dotin.exception;

public class DotinException extends Exception {
    String content;

    public DotinException(String content) {
        this.content = content;
    }

    public String toString() {
        return content;
    }
}