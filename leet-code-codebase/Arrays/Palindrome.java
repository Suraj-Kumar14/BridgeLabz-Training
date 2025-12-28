   public boolean isPalindrome(int x) {
        int rev=0;
        int number=x;
        while(x>0){
            int rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        if(rev==number) return true;
        else return false;
    }