package model;

public class CFidElement implements Element {

   private boolean value;
   private final Element victim;
   private final Type type;

   public CFidElement(Type type, Element element) {
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
         case RISING_0:
            if (!this.value && value) {
               this.victim.set(false);
            }
            break;
         case RISING_1:
            if (!this.value && value) {
               this.victim.set(true);
            }
            break;
         case FALLING_0:
            if (this.value && !value) {
               this.victim.set(false);
            }
            break;
         case FALLING_1:
            if (this.value && !value) {
               this.victim.set(true);
            }
            break;
         default:
            throw new IllegalArgumentException("wrong type");
      }

      this.value = value;

   }

   public enum Type {
      RISING_0, RISING_1, FALLING_0, FALLING_1
   }
}
