package solutions;

/**
 * Created by 431 on 2014/12/20.
 */
public class Maths {
    public static int atoi(String str) {
        int result=0;
        return result;
    }

    public static int sqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int l = 1, r = x, res=0;
        while(l <= r){
            int m = (l + r)/2;
            if(m == x / m){
                return m;
            }else if(m > x / m){
                r = m - 1;
            }else{
                l = m + 1;
                res = m;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int iResult = sqrt(11);
        System.out.println(iResult);
    }
}
