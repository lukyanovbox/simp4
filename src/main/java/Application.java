import algorithm.AlgorithmB;
import algorithm.Walking01;
import memory.RamMemory;
import util.TestingFaultTypes;


public class Application {

   public static void main(String[] args) {

      AlgorithmB.run(RamMemory.initialize(400));
      Walking01.runLight(RamMemory.initialize(400));

      TestingFaultTypes.runTestMemoryWithFaults();
   }
}
