package problem;

import java.io.*;
import java.util.*;

public class Baek25501 {
    public List<String> solution(List<String> strList) {
        List<String> resultList = new ArrayList<>();

        for (String item : strList) {
            resultList.add(isPalindrome(item));
        }

        return resultList;
    }

    public String recursion(String s, int l, int r, int count){
        count += 1;
        if(l >= r) return "1 " + count;
        else if(s.charAt(l) != s.charAt(r)) return "0 " + count;
        else return recursion(s, l+1, r-1, count);
    }
    public String isPalindrome(String s){
        int count = 0;
        return recursion(s, 0, s.length()-1, count);
    }
}
