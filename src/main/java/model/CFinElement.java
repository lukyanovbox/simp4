package model;

public class CFinElement implements Element {

   private boolean value;
   private final Element victim;
   private final Type type;

   public CFinElement(Type type, Element element) {
      this.type = type;
      this.victim = element;
   }


   @Override
   public boolean get() {
      return value;
   }

   @Override
   public void set(final boolean value) {
      switch (type) {
         case RISING:
            if (!this.value && value) {
               this.victim.set(!this.victim.get());
            }
            break;

         case FALLING:
            if (this.value && !value) {
               this.victim.set(!this.victim.get());
            }
            break;

         default:
            throw new IllegalArgumentException("wrong type");
      }

      this.value = value;
   }


   public enum Type {
      RISING, FALLING
   }
}
