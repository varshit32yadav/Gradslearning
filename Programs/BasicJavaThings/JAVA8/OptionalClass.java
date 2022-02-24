  import java.util.*;
   public class OptionalClass{
   	public static void main(String[] args) {
   		Integer i1=null;//Integer class can access null also
   		Integer i2=20;

   		//for handling null values
   		Optional<Integer> o1=Optional.ofNullable(i1);//if i1 has some value then hold that value ,and if it has null then it will wrap null as an object and hold that null object.So that NullPointerException is not given.
        //as null is optional in intger.
        Optional<Integer> o2=Optional.ofNullable(i2);
        add(o1,o2);
   	}
   	public static void add(Optional<Integer> a,Optional<Integer> b){
        
        Integer i1=a.orElse(new Integer(0));//if i1 holds null then assign it to 0 else hold the not-null value
        Integer i2=b.orElse(new Integer(0));
   		System.out.println(i1+i2);//now no NullPointerException is given
   	}
   }