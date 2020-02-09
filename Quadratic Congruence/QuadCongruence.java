public class QuadCongruence {
    public int a,b,c,p;
    QuadCongruence(int a,int b,int c,int n,int p){
        this.a = a;
        this.b = b;
        this.c = c - n;
        this.p = p;
    }
    public boolean checkCongruence() {
        for (int x = 1; x < p; x++) 
            if ((x*x*a + b*x + c)%p == 0) 
                return true;
        return false;
    }
    public void findCongruence() {
        for (int x = 1; x < p; x++) 
            if ((x*x*a + b*x + c)%p == 0) 
                System.out.println("x = "+x);;
    }
    public static void main(String[] args) {
        QuadCongruence qc = new QuadCongruence(Integer.parseInt(args[0]), 
        Integer.parseInt(args[1]), Integer.parseInt(args[2]), 
        Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        if(!qc.checkCongruence()) {
            System.out.println("No solutions possible.");
        }
        else{
            System.out.println(qc.a+"x² + "+qc.b+"x + "+qc.c+" ≡ "+args[3]+"(mod "+qc.p+")");
            qc.findCongruence();
        }       
    }
}
