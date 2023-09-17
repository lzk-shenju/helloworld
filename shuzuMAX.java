import java.util.Scanner;
public class shuzuMAX {

    public static int max(int m,int n){
        return m>n ? m :n;
    }

    public static int MAX_Three(int arr[]){
        int n=arr.length;

        int End[]=new int[n];
        int All[]=new int[n];

        End[n-1]=arr[n-1];
        All[n-1]=arr[n-1];
        End[0]=All[0]=arr[0];

        for(int i=1;i<n;i++){
            End[i]=max(End[i-1]+arr[i],arr[i]);
            All[i]=max(End[i],All[i-1]);
        }

        return All[n-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=Integer.parseInt(sc.next());
        //number表示数组的长度
        int[] num=new int[number];

        //赋值
        for(int i=0;i<number;i++){
            num[i]=(int)sc.nextInt();
        }
        System.out.println(MAX_Three(num));

    }

}

