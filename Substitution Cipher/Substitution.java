import java.util.*;
import java.io.*;
public class Substitution{
    int hash[] = new int[26];
    Double stats[] = {9.045,5.253,6.589,8.049,12.347,6.289,6.794,7.328,9.667,4.986,4.567,
        7.021,6.465,10.259,8.356,5.756,4.271,7.580,7.964,8.906,6.167,5.450,5.990,3.08,5.089,3.22};
    public String StringCipher() throws Exception{
        File file = new File("text.txt"); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String st = br.readLine(); 
        return st;
    }
    public int findDoubleMax(Double arr[]) {
        Double max = 0.00;
        int index=0;
        for(int i=0;i<26;i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
    public int findMax(int arr[]) {
        int max = 0,index=0;
        for(int i=0;i<26;i++){
            if(max < arr[i]){
                max = (int)arr[i];
                index = i;
            }
        }
        return index;
    }
    public int[] findDoubleRank(Double arr[]) {
        int rank[] = new int[26];
        for(int i=0;i<26;i++){
            int x = findDoubleMax(arr);
            rank[x] = i+1;
            arr[x] = 0.00;
        }
        return rank;
    }
    public int[] findRank(int arr[]) {
        int rank[] = new int[26];
        for(int i=0;i<26;i++){
            int x = findMax(arr);
            rank[x] = i+1;
            arr[x] = 0;
        }
        return rank;
    }
    public void decript(String str) {
        int hash[] = new int[26];
        Arrays.fill(hash,0);
        for(int i=0;i<str.length();i++){
            hash[(int)str.charAt(i)-65]++;
        }
        int statsRank[] = findDoubleRank(stats);
        int hashRank[] = findRank(hash);
        for (int i = 0; i < str.length(); i++) {
            for(int j = 0; j < 26; j++){
                if(hashRank[(int)str.charAt(i)-65] == statsRank[j]){
                    if((char)(j+65)=='X')
                        System.out.print("I");
                    else
                        System.out.print((char)(j+65));
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Substitution sub = new Substitution();
        String msg = "";
        try {
            msg = sub.StringCipher();   
        } catch (Exception e) {
            System.out.println(e);
        }
        sub.decript(msg);
    }
}
