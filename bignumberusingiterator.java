package BH;

import java.util.ArrayList;
import java.util.Iterator;

public class bignumberusingiterator {
    public static void main(String[] args) {
    	  ArrayList<Integer> numbers = new ArrayList<Integer>();
          numbers.add(876);
          numbers.add(6);
          numbers.add(67589);
          numbers.add(1340);
          numbers.add(2);
          Iterator<Integer> i = numbers.iterator();
          int big = numbers.get(0);
          while (i.hasNext())
          {
              Integer number = i.next();
              if( number>big) {
                  big=number;
              }
              
          }
          System.out.println(big);
      }

}
