public class sushu {
    public static void main(String[] args) {
        int count=0;
        for (int i = 2; i < 20000; i++) {
            boolean b=true;
            for (int j = 2; j < i; j++) {
                if (i%j==0){
                    b=false;
                    break;
                }
            }
            if (b){
                count++;
                System.out.print(i+" ");
                if (count%5==0){
                    System.out.println();
                }
            }
        }
    }
}
