package algorithm;

import static com.google.common.collect.ImmutableList.of;
import exception.MemoryBusinessException;
import static java.lang.String.format;
import static model.Action.WRITE_0;
import model.Element;
import util.Execution;


public class Walking01 {

   public static void run(Element[][] testableMemory) {
      runLight(testableMemory);
   }

   public static void runLight(Element[][] testableMemory) {
      Execution execution = new Execution();
      try {
         long startTime = System.currentTimeMillis();

         execution.fromLowToHigh(testableMemory, of(WRITE_0));

         for (int i = 0; i < testableMemory.length; i++) {
            for (int j = 0; j < testableMemory[i].length; j++) {
               Element baseEl = testableMemory[i][j];
               baseEl.set(true);

               read0(testableMemory, 0, 0, i + 1, j);
               read0(testableMemory, i, j + 1, testableMemory.length, testableMemory.length);

               if (!baseEl.get()) {
                  throw new MemoryBusinessException(format("Error in  cell [%d][%d]", i, j));
               }
               baseEl.set(false);
            }
         }


         long finishTime = System.currentTimeMillis();

         int size = testableMemory.length * testableMemory[0].length / 1000000;
         System.out.println(
               format("Walking 0/1 LIGHT. Check performed. size: %d Mbit | Processing time: %d ms | Found 0 errors",
                     size,
                     finishTime - startTime));
      }
      catch (MemoryBusinessException e) {
         System.out.println(format("Walking 0/1. %s", e.getMessage()));
      }
   }

   private static void read0(final Element[][] testableMemory, final int starti, final int startj, final int i, final int j) {
      for (int k = starti; k < i; k++) {
         for (int l = startj; l < j; l++) {
            Element innerel = testableMemory[k][l];
            if (innerel.get()) {
               throw new MemoryBusinessException(format("Error in  cell [%d][%d]", k, l));
            }
         }
      }
   }
}
