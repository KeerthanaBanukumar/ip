/*public class NodeException extends Exception {
    public NodeException(String message) {
        super(message);
    }
}
*/
/**
 * Custom exception class for handling errors in the Node application.
 * Extends the built-in Exception class to provide custom error messages.
 */
public class NodeException extends Exception {

    /**
     * Constructs a NodeException with a specific error message.
     *
     * @param message The error message to be associated with this exception.
     */
    public NodeException(String message) {
        super(message);
    }
}
