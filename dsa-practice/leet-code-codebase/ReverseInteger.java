class Solution {
    public int reverse(int x) {
        return reverse2(x);
    }
    public static int reverse2(int n){
        long temp = n;
        long ans = 0;
        boolean minus = false;
        if(n<0){
           minus = true;
        }
        temp = Math.abs(temp);
        while(temp!=0){
           ans = (temp%10)+(ans*10);
           temp/=10;
        }
        //
        if(minus){
            ans = (ans-(ans*2));
        }
        //this will handle bit int means long positive or negative
         if(ans>=Integer.MAX_VALUE||ans<=Integer.MIN_VALUE){
            return 0;
         }
         return (int)ans;
    }
}