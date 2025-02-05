package dsa;

import java.util.ArrayList;
import java.util.HashMap;

public class L1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        // agar dono strings equal hai toh true return krdo
        if (s1.equals(s2)) return true;

        // ek list banao jisme hum wo index store krege jaha pr s1 aur s2 ka char differ krega
        ArrayList<Integer> diffIndexList = new ArrayList<>();
        if (n1 != n2) return false;
        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndexList.add(i);
            }
        }

        // agar list ka size 2 se bada hai, mtlb 2 se jyada jagah pr char differ krrhe h s1 and s2 which denies the condition ki atmost 1 swap ho skta hai, kunki ek hi swap k liye do hi different index ki need h
        if (diffIndexList.size() != 2) return false;

        // agar size 2 hai to kya krna hai;
        int idx1 = diffIndexList.get(0), idx2 = diffIndexList.get(1);

        // charachetrs swap krk check kr skte hai ki equal 
        return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
    }
    
    public static void main(String[] args) {
        String s1 = "aa", s2 = "ac";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
