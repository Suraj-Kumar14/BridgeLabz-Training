 public int romanToInt(String s) {
       HashMap<Character,Integer>Roman=new HashMap<>();
       Roman.put('I',1);
       Roman.put('V',5);
       Roman.put('X',10);
       Roman.put('L',50);
       Roman.put('C',100);
       Roman.put('D',500);
       Roman.put('M',1000);
       int curr=0;
       int pre=0;
       int sum=0;

       for(int i=s.length()-1;i>=0;i--){
             curr=Roman.get(s.charAt(i));
            if(curr<pre){
                sum-=curr;
            } else {
                sum+=curr;
            }
            pre=curr;
       }
       return sum;
    }