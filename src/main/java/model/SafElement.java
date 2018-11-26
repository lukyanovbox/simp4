package model;

public class SafElement implements Element {

   private final boolean value;


   public SafElement(boolean value) {
      this.value = value;
   }

   @Override
   public boolean get() {
      return value;
   }

   @Override
   public void set(final boolean value) {
      // do nothing
   }
}
