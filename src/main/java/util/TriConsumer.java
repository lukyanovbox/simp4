package util;

import java.util.Objects;



@FunctionalInterface
public interface TriConsumer<T,U,V> {

   /**
    * Performs this operation on the given argument.
    *
    * @param t the input argument
    */
   void accept(T t,U u,V v);
}