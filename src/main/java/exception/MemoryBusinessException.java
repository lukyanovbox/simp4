package exception;

public class MemoryBusinessException extends RuntimeException {

   public MemoryBusinessException() {
   }

   public MemoryBusinessException(final String message) {
      super(message);
   }

   public MemoryBusinessException(final String message, final Throwable cause) {
      super(message, cause);
   }

   public MemoryBusinessException(final Throwable cause) {
      super(cause);
   }
}
