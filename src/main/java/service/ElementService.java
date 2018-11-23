package service;

import model.Action;
import model.Element;


public class ElementService {

   public static boolean perform(Element element, Action action) {
      switch (action) {
         case READ_0: {
            boolean val = element.get();
            if (val) {
               return false;
            }
            break;
         }
         case READ_1: {
            boolean val = element.get();
            if (!val) {
               return false;
            }
            break;
         }
         case WRITE_0: {
            element.set(false);
            break;
         }
         case WRITE_1: {
            element.set(true);
            break;
         }
         default:
            throw new IllegalArgumentException("Unsupported action");
      }
      return true;
   }

}
