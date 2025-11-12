package problem;

import java.util.*;

public class Baek10870 {
    public List<Integer> solution(int count, int num, List<Integer> list) {
        if(count >= num+1) return list;
       list.add(list.get(count - 2) + list.get(count - 1));
       count++;
       return solution(count, num, list);
    }
}
