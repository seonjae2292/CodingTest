package problem;

public class Baek27433 {
    public long solution(int num) {
        if(num <= 1) return 1;
        return num * solution(num - 1);
    }
}
