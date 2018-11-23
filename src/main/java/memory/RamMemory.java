package memory;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import model.Element;
import model.SimpleElement;


public class RamMemory {

   public static Element[][] initialize(int size) {

      int k = (int) round(sqrt(size));

      Element[][] memory = new SimpleElement[k][k];

      for (int i = 0; i < memory.length; i++) {
         for (int j = 0; j < memory[i].length; j++) {
            memory[i][j] = new SimpleElement();
         }
      }
      return memory;
   }
}
