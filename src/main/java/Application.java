import algorithm.AlgorithmB;
import algorithm.Walking01;
import memory.RamMemory;


public class Application {

   public static void main(String[] args) {

      AlgorithmB.run(RamMemory.initialize(4000000));

      Walking01.run(RamMemory.initialize(400000));
   }
}