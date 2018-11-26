package util;

import algorithm.AlgorithmB;
import algorithm.Walking01;
import static java.lang.System.out;
import memory.RamMemory;
import model.CFidElement;
import static model.CFidElement.Type.*;
import model.CFinElement;
import model.Element;
import model.SafElement;


public class TestingFaultTypes {

   public static void runTestMemoryWithFaults() {
      Element[][] ram = RamMemory.initialize(400);
      ram[1][1] = new SafElement(true);
      out.println("saf check =1");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new SafElement(true);
      out.println("saf check =0");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new CFinElement(CFinElement.Type.RISING, ram[2][2]);
      out.println("CFin check ∧(↑,aj) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new CFinElement(CFinElement.Type.FALLING, ram[2][2]);
      out.println("CFin check ∧(↓,aj) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[5][5] = new CFinElement(CFinElement.Type.RISING, ram[3][3]);
      out.println("CFin check ∨(↑,aj) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[5][5] = new CFinElement(CFinElement.Type.FALLING, ram[3][3]);
      out.println("CFin check ∨(↓,aj) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new CFidElement(RISING_0, ram[2][2]);
      out.println("CFid check ∧(↑,0) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new CFidElement(RISING_1, ram[2][2]);
      out.println("CFid check ∧(↑,1) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new CFidElement(FALLING_0, ram[2][2]);
      out.println("CFid check ∧(↓,0) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[1][1] = new CFidElement(FALLING_1, ram[2][2]);
      out.println("CFid check ∧(↓,1) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[5][5] = new CFidElement(RISING_0, ram[2][2]);
      out.println("CFid check ∨(↑,0) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[5][5] = new CFidElement(RISING_1, ram[2][2]);
      out.println("CFid check ∨(↑,1) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[5][5] = new CFidElement(FALLING_0, ram[2][2]);
      out.println("CFid check ∨(↓,0) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");

      ram = RamMemory.initialize(400);
      ram[5][5] = new CFidElement(FALLING_1, ram[2][2]);
      out.println("CFid check ∨(↓,1) ");
      AlgorithmB.run(ram);
      Walking01.run(ram);

      out.println("-----------");
   }
}
