import java.util.*;
public class Encrypt {
    private String key, msg;
    Encrypt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key:");
        key = sc.nextLine();
        System.out.println("Enter the message:");
        msg = sc.nextLine();
    }
    public String generate(){
        int key[][] = new int[4][4];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                key[i][j] = (int)this.key.charAt(count++)-65;
            }
        }
        String result = "";
        int msgArr[] = new int[4];
        count = 0;
        for (int i = 0; i < this.msg.length()/4; i++) {
            for (int j = 0; j < 4; j++) {
                msgArr[j] = (int)this.msg.charAt(count++)-65;
            }
            msgArr = multiply(key,msgArr);
            for (int j = 0; j < 4; j++) {
                result += (char)(msgArr[j]+65);
            }
        }
        return result;
    }
    public int[] multiply(int key[][],int msgArr[]){
        int result[] = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] += key[i][j]*msgArr[j];
                result[i] = result[i]%26;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Encrypt en = new Encrypt();
        System.out.println("Message:"+en.generate());
    }
}
