package algorithm;

import static com.google.common.collect.ImmutableList.of;
import exception.MemoryBusinessException;
import static model.Action.READ_0;
import static model.Action.READ_1;
import static model.Action.WRITE_0;
import static model.Action.WRITE_1;
import model.Element;
import service.ElementService;
import util.Execution;


public class Walking01 {

   public static void run(Element[][] testableMemory) {
      Execution execution = new Execution();
      try {
         long startTime = System.currentTimeMillis();

         execution.fromLowToHigh(testableMemory, of(WRITE_0));

//         execution.fromLowToHigh(testableMemory, (baseEl,i,j) -> {
//            ElementService.perform(baseEl, WRITE_1);
//            execution.fromLowToHigh(testableMemory, (innerel, k, l) ->{
//               if(innerel != baseEl){
//                  if(!ElementService.perform(innerel, READ_0)){
//                     System.out.println(String.format("Error in  cell [%d][%d]",k,l));
//                     throw new MemoryBusinessException();
//                  }
//               }
//            });
//            if(!ElementService.perform(baseEl, READ_1)){
//               System.out.println(String.format("Error in  cell [%d][%d]",i,j));
//               throw new MemoryBusinessException();
//            }
//            ElementService.perform(baseEl, WRITE_0);
//         });

         for (int i = 0; i < testableMemory.length; i++) {
            for (int j = 0; j < testableMemory[i].length; j++) {
               Element baseEl = testableMemory[i][j];
               ElementService.perform(baseEl, WRITE_1);
               for (int k = 0; k < testableMemory.length; k++) {
                  for (int l = 0; l < testableMemory[k].length; l++) {
                     Element innerel = testableMemory[k][l];
                     if(innerel != baseEl){
                        if(!ElementService.perform(innerel, READ_0)){
                           System.out.println(String.format("Error in  cell [%d][%d]",k,l));
                           throw new MemoryBusinessException();
                        }
                     }
                  }
               }
               if(!ElementService.perform(baseEl, READ_1)){
                  System.out.println(String.format("Error in  cell [%d][%d]",i,j));
                  throw new MemoryBusinessException();
               }
               ElementService.perform(baseEl, WRITE_0);
            }
         }


         long finishTime = System.currentTimeMillis();

         int size = testableMemory.length * testableMemory[0].length / 1000000;
         System.out.println(
               String.format("Walking 0/1. Check performed. size: %d Mbit | Processing time: %d ms | Found 0 errors",
                     size,
                     finishTime - startTime));
      }
      catch (MemoryBusinessException ignored) {
      }
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
               for (int k = 0; k < testableMemory.length; k++) {
                  for (int l = 0; l < testableMemory[k].length; l++) {
                     Element innerel = testableMemory[k][l];
                     if (innerel != baseEl & innerel.get()) {
                        System.out.println(String.format("Error in  cell [%d][%d]", k, l));
                        throw new MemoryBusinessException();
                     }
                  }
               }
               if (!baseEl.get()) {
                  System.out.println(String.format("Error in  cell [%d][%d]", i, j));
                  throw new MemoryBusinessException();
               }
               baseEl.set(false);
            }
         }


         long finishTime = System.currentTimeMillis();

         int size = testableMemory.length * testableMemory[0].length / 1000000;
         System.out.println(
               String.format("Walking 0/1 LIGHT. Check performed. size: %d Mbit | Processing time: %d ms | Found 0 errors",
                     size,
                     finishTime - startTime));
      }
      catch (MemoryBusinessException ignored) {
      }
   }
}
