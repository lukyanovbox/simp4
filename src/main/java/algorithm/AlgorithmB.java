package algorithm;

import static com.google.common.collect.ImmutableList.of;
import exception.MemoryBusinessException;
import static java.lang.String.format;
import static model.Action.READ_0;
import static model.Action.READ_1;
import static model.Action.WRITE_0;
import static model.Action.WRITE_1;
import model.Element;
import util.Execution;


public class AlgorithmB {



   public static void run(Element[][] testableMemory) {
      Execution execution = new Execution();
      try {
         long startTime = System.currentTimeMillis();

         execution.fromLowToHigh(testableMemory, of(WRITE_0));
         execution.fromLowToHigh(testableMemory, of(READ_0, WRITE_1, WRITE_0, WRITE_1));
         execution.fromLowToHigh(testableMemory, of(READ_1, WRITE_0, READ_0, WRITE_1));
         execution.fromHighToLow(testableMemory, of(READ_1, WRITE_0, WRITE_1, WRITE_0));
         execution.fromHighToLow(testableMemory, of(READ_0, WRITE_1, READ_1, WRITE_0));

         long finishTime = System.currentTimeMillis();

         int size = testableMemory.length * testableMemory[0].length / 1000000;
         System.out.println(
               String.format("Algorithm B. Check performed. size: %d Mbit | Processing time: %d ms | Found 0 errors",
                     size,
                     finishTime - startTime));
      }
      catch (MemoryBusinessException e) {
         System.out.println(format("Algorithm B. %s", e.getMessage()));

      }
   }
}
