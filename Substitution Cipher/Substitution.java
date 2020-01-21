import java.util.*;
public class Substitution{
    int hash[] = new int[26];
    float stats[] = {8.167,1.492,2.202,4.253,12.702,2.228,2.015,6.094,6.966,0.153,1.292,4.025,
    2.406,6.749,7.507,1.929,0.095,5.987,6.327,9.356,2.758,0.978,2.560,0.150,1.994,0.077};
    public String StringCipher() {
        File file = new File("text.txt"); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String st = br.nextLine(); 
        return st;
    }
    public int findMax(T arr[]) {
        int max = 0,index=0;
        for(int i=0;i<26;i++){
            if(max < (int)arr[i]){
                max = (int)arr[i];
                index = i;
            }
        }
        return index;
    }
    public int[] findRank(T arr[]) {
        int rank[] = new int[26];
        for(int i=0;i<26;i++){
            int x = findMax(arr);
            rank[x] = i+1;
            arr[x] = 0;
        }
        return rank;
    }
    public String decript(String str) {
        Arrays.fill(hash,0);
        for(int i=0;i<26;i++){
            if(hash[i]-65==i)
                hash[i]++;
        }
        int statsRank[] = findRank(stats);
        int hashRank[] = findRank(hash);
        
    }
}
