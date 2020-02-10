import java.math.BigInteger;
import java.io.*;
class Encryption
{
public static String main(BigInteger n,BigInteger e,String text)
{
   String s1= "";
         int l= text.length();
         for(int i=0;i<l;i++)
         {
            int k =(int)text.charAt(i)-64;
            if(k<10)
            s1 = s1 + "0"+k;
            else
            s1 =s1+k;
         }
         System.out.println(s1);
         BigInteger d =new BigInteger(s1);
          String  output = (d.modPow(e,n)).toString();
         System.out.println(output);
         return output;
}
}
class Decryption
{
 public static BigInteger main(BigInteger d,BigInteger n,String text)
{
   String s1= "";
        BigInteger p =new BigInteger(text);
        System.out.println("p is"+p);
     p =p.modPow(d,n);
    System.out.println("p is"+p.modPow(d,n));
   
        return p;
}
}
public class Main
{
   
   
   
   
   
   
    private static final BigInteger MAXLONG = BigInteger.valueOf(Long.MAX_VALUE);
private static final BigInteger BIGTWO = BigInteger.valueOf(2);

private static BigInteger smallestPrimeFactor( BigInteger n ) {
    if (n.compareTo(BigInteger.ONE) <= 0) {
        return BigInteger.ZERO;
    }
    if (n.mod(BIGTWO).equals(BigInteger.ZERO)) {
        return BIGTWO;
    }
    if (n.compareTo(MAXLONG) <= 0) {
       
        return BigInteger.valueOf(smallestPrimeFactor( n.longValue() ));
    }
   
    return internalPrimeFactor(n);
}

private static final long smallestPrimeFactor(long n) {
    if (n < 1) {
        return 0;
    }
    if (n % 2 == 0) {
        return 2;
    }
   
    long root = (long)(Math.sqrt(n)) + 1;
    for (long i = 3; i <= root; i += 2) {
        if (n % i == 0) {
            return i;
        }
    }
 
    return n;
}



public static final BigInteger sqrt(BigInteger n) {
    BigInteger a = BigInteger.ONE;
    BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
    while(b.compareTo(a) >= 0) {
        BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
        if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
        else a = mid.add(BigInteger.ONE);
    }
    return a.subtract(BigInteger.ONE);
}

private static final BigInteger internalPrimeFactor(BigInteger n) {

    BigInteger root = sqrt(n);
   
    long maxlimit = root.compareTo(MAXLONG) > 0 ? Long.MAX_VALUE : root.longValue();
   
    for( long i = 3; i <= maxlimit ; i += 2 ){
        if( n.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO) ) {
            return BigInteger.valueOf(i);
        }
    }

 
    for( BigInteger i = MAXLONG; root.compareTo(i) >= 0 ; i = i.add(BIGTWO)) {
        if( n.mod(i).equals(BigInteger.ZERO) ) {
            return i;
        }
    }
   
    return n;
}
   
   
   
   
   
   
   
   
   
   
   
   
   
public static void main(String[]args)
{
    BigInteger P = new BigInteger("1000000000000000000000000000000000067");
    BigInteger Q = new BigInteger("1000000000000000000000000000000000123");
    BigInteger N = P.multiply(Q);
    String  text =  "WELCOMETOJADAVPURUNIVERSITY";  
   
    BigInteger temp =new BigInteger("-1");
    BigInteger func = (P.add(temp)).multiply(Q.add(temp));
    BigInteger func1 =func.add(BigInteger.valueOf(1));
   
  BigInteger e = smallestPrimeFactor(func1);
  BigInteger d = func1.divide(e);
   
    System.out.println("Entered First Prime Number is " + P);
    System.out.println("Entered Second Prime Number is " + Q);
    System.out.println("------------------------------------------");
    System.out.println("Encryption key details" );
    System.out.println("Value of N is " + N);
    System.out.println("Value of e is " + e);
    System.out.println("------------------------------------------");
    System.out.println("Text to encrypt is " + text);
  String x = Encryption.main(N,e,text);
  System.out.println("Encrypted text is " + x);
  System.out.println("Value of function is"+func );
   System.out.println("------------------------------------------");
    System.out.println("Decryption key details" );
    System.out.println("Value of d is " + d);
    System.out.println("Value of N is " + N);
    System.out.println("------------------------------------------");
    System.out.println("Decypted text is ");
    String s3 = Decryption.main(d,N,x).toString();
    if(s3.length()%2!=0)
    s3 = "0"+s3;
    System.out.println(s3);
    for(int i=0;i<s3.length();i+=2)
    {
        char ch =(char)(Integer.parseInt(s3.substring(i,i+2))+64);
         System.out.print(ch);
    }
     System.out.println();
       
   
}
   
}
