package model;

public class SimpleElement implements Element {

   private boolean value;

   @Override
   public boolean get() {
      return this.value;
   }

   @Override
   public void set(final boolean value) {
      this.value = value;
   }
}
