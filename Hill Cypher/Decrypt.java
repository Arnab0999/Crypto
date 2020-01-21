public class Decript {
    static final int N = 4;
    public String generate(String key, String msg){
        int k = 0;
        String result = "";
        int[][] keyMat = new int[4][4];
        int[] msgArr = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                keyMat[i][j] = (int)key.charAt(k++)-65;
            }
        }
        k = 0;
        keyMat = inverse(keyMat);
        for (int i = 0; i < msg.length()/4; i++) {
            for (int j = 0; j < 4; j++) {
                msgArr[j] = (int)msg.charAt(k++)-65;
            }
            msgArr = multiply(keyMat,msgArr);
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
    static void getCofactor(int A[][], int temp[][], int p, int q, int n) 
    { 
        int i = 0, j = 0; 
  
        // Looping for each element of the matrix 
        for (int row = 0; row < n; row++) 
        { 
            for (int col = 0; col < n; col++) 
            { 
                // Copying into temporary matrix only those element 
                // which are not in given row and column 
                if (row != p && col != q) 
                { 
                    temp[i][j++] = A[row][col]; 
  
                    // Row is filled, so increase row index and 
                    // reset col index 
                    if (j == n - 1) 
                    { 
                        j = 0; 
                        i++; 
                    } 
                } 
            } 
        } 
    } 
  
/* Recursive function for finding determinant of matrix. 
n is current dimension of A[][]. */
    static int determinant(int A[][], int n) 
    { 
        int D = 0; // Initialize result 
  
        // Base case : if matrix contains single element 
        if (n == 1) 
            return A[0][0]; 
  
        int [][]temp = new int[N][N]; // To store cofactors 
  
        int sign = 1; // To store sign multiplier 
  
        // Iterate for each element of first row 
        for (int f = 0; f < n; f++) 
        { 
            // Getting Cofactor of A[0][f] 
            getCofactor(A, temp, 0, f, n); 
            D += sign * A[0][f] * determinant(temp, n - 1); 
  
            // terms are to be added with alternate sign 
            sign = -sign; 
        } 
  
        return D; 
    } 
  
// Function to get adjoint of A[N][N] in adj[N][N]. 
    static void adjoint(int A[][],int [][]adj) 
    { 
        
  
    // temp is used to store cofactors of A[][] 
        int sign = 1; 
        int [][]temp = new int[N][N]; 
  
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
            { 
            // Get cofactor of A[i][j] 
                getCofactor(A, temp, i, j, N); 
  
            // sign of adj[j][i] positive if sum of row 
            // and column indexes is even. 
                sign = ((i + j) % 2 == 0)? 1: -1; 
  
            // Interchanging rows and columns to get the 
            // transpose of the cofactor matrix 
                adj[j][i] = (sign)*(determinant(temp, N-1)); 
                adj[j][i] = adj[j][i]%26;
            } 
        } 
    } 
  
// Function to calculate and store inverse, returns false if 
// matrix is singular 
    static int[][] inverse(int A[][]) 
    { 
        int inverse[][] = new int[4][4];
    // Find determinant of A[][] 
        int det = determinant(A, N)%26; 
        System.out.println(det);
        if (det == 0) 
        { 
            System.out.print("Singular matrix, can't find its inverse"); 
            return null; 
        } 
  
    // Find adjoint 
        int [][]adj = new int[N][N]; 
        adjoint(A, adj); 
  
    // Find Inverse using formula "inverse(A) = adj(A)/det(A)" 
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) {
                inverse[i][j] = adj[i][j]/det; 
                inverse[i][j] = inverse[i][j]%26;
                System.out.print(inverse[i][j]);
            }
        return inverse; 
    } 
    public static void main(String[] args) {
        Decript op = new Decript();
        System.out.println("Message:"+op.generate("YOUAREMYNIGGAIPS","CUMAKGGIIGQO"));
    }
}
