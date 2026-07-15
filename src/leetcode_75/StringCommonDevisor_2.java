package leetcode_75;

public class StringCommonDevisor_2 {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";

        int length = gcd(str1.length() , str2.length());
        return str1.substring(0, length);
    }
    private int gcd(int length1, int length2){
        while(length2!=0){
            int temp = length2;
            length2 = length1%length2;
            length1 = temp;
        }
        return length1;
    }
}
