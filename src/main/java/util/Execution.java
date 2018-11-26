package util;

import java.util.List;

import exception.MemoryBusinessException;
import model.Action;
import model.Element;
import service.ElementService;


public class Execution {



   public void fromLowToHigh(Element[][] testableMemory, List<Action> actions) throws MemoryBusinessException {
      for (int i = 0; i < testableMemory.length; i++) {
         for (int j = 0; j < testableMemory[i].length; j++) {
            performCellCheckInternal(testableMemory, actions, i, j);
         }
      }
   }

   public void fromLowToHigh(Element[][] testableMemory, TriConsumer<Element, Integer, Integer> consumer)
         throws MemoryBusinessException {
      for (int i = 0; i < testableMemory.length; i++) {
         for (int j = 0; j < testableMemory[i].length; j++) {
            consumer.accept(testableMemory[i][j], i, j);
         }
      }
   }

   public void fromHighToLow(Element[][] testableMemory, List<Action> actions) throws MemoryBusinessException {
      for (int i = testableMemory.length - 1; i >= 0; i--) {
         for (int j = testableMemory[i].length - 1; j >= 0; j--) {
            performCellCheckInternal(testableMemory, actions, i, j);
         }
      }
   }


   private void performCellCheckInternal(final Element[][] testableMemory, final List<Action> actions, final int i, final int j)
         throws MemoryBusinessException {
      for (Action action : actions) {
         boolean result = ElementService.perform(testableMemory[i][j], action);

         if (!result) {
            throw new MemoryBusinessException(String.format("Error in  cell [%d][%d]", i, j));
         }
      }
   }


}
