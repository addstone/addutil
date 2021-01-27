package com.soucod.addutil.commons.lang.exception;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-9:55
 * UpdateDate: 2021-01-27-9:55
 * FileName: CloneFailedException
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

/**
 * Exception thrown when a clone cannot be created. In contrast to
 * {@link CloneNotSupportedException} this is a {@link RuntimeException}.
 *
 * @since 3.0
 */
public class CloneFailedException extends RuntimeException {
    // ~ Static fields/initializers ---------------------------------------------

    private static final long serialVersionUID = 20091223L;

    // ~ Constructors -----------------------------------------------------------

    /**
     * Constructs a CloneFailedException.
     *
     * @param message description of the exception
     */
    public CloneFailedException(final String message) {
        super(message);
    }

    /**
     * Constructs a CloneFailedException.
     *
     * @param cause cause of the exception
     */
    public CloneFailedException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a CloneFailedException.
     *
     * @param message description of the exception
     * @param cause cause of the exception
     */
    public CloneFailedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
