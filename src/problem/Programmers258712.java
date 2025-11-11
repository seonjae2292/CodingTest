package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Programmers258712 {
    public Integer solution(String[] friends, String[] gifts) {
        List<String> friendList = new ArrayList<>(Arrays.asList(friends));

        // 선물 거래 목록
        HashMap<String, List<String>> hashMap = new HashMap<>();
        // 다음달에 받아야 하는 선물 개수
        HashMap<String, Integer> forResultHashMap = new HashMap<>();

        // 선물 거래 목록 HashMap에 저장
        // value : 선물을 준 사람들
        for(String item : gifts) {
            String[] splitedString = item.split(" ");

            if(hashMap.containsKey(splitedString[0])) {
                hashMap.get(splitedString[0]).add(splitedString[1]);
            } else {
                List<String> initValue = new ArrayList<>();
                initValue.add(splitedString[1]);
                hashMap.put(splitedString[0], initValue);
            }
        }

        for (int j = 0; j < friendList.size() - 1; j++) {
            // 선물 주고 받은적 있는지 확인
            for (int i = j+1; i < friendList.size(); i++) {
                int finalJ = j;
                int finalI = i;

                // a가 b에게 선물을 몇번 줬는지 저장하기 위한
                long aToBCount = -1;
                if (hashMap.containsKey(friendList.get(finalJ))) {
                    aToBCount = hashMap.get(friendList.get(finalJ)).stream()
                            .filter(item -> item.equals(friendList.get(finalI)))
                            .count();
                } else {
                    aToBCount = 0;
                }

                // b가 a에게 선물을 몇번 줬는지 저장하기 위한
                long bToACount = -1;
                if (hashMap.containsKey(friendList.get(finalI))) {
                    bToACount = hashMap.get(friendList.get(finalI)).stream()
                            .filter(item -> item.equals(friendList.get(finalJ)))
                            .count();
                } else {
                    bToACount = 0;
                }

                // 선물을 주고 받은 적이 없거나 같을 때
                if (aToBCount + bToACount == 0 || aToBCount == bToACount) {
                    long APresent = presentCounter(friendList.get(finalJ), hashMap);
                    long BPresent = presentCounter(friendList.get(finalI), hashMap);

                    if (APresent > BPresent) {
                        forResultHashMap.merge(friendList.get(finalJ), 1, Integer::sum);
                    } else if (APresent < BPresent) {
                        forResultHashMap.merge(friendList.get(finalI), 1, Integer::sum);
                    } else { // 선물지수가 같은 경우
                        forResultHashMap.merge(friendList.get(finalJ), 0, Integer::sum);
                        forResultHashMap.merge(friendList.get(finalI), 0, Integer::sum);
                    }
                } else { // 있을 때
                    // 누가 더 많이 줬는지 구해야한다.
                    if (aToBCount > bToACount) {
                        forResultHashMap.merge(friendList.get(finalJ), 1, Integer::sum);
                    } else {
                        forResultHashMap.merge(friendList.get(finalI), 1, Integer::sum);
                    }
                }
            }
        }

        int result = -1;

        // forResultHashMap의 value에서 가장 큰 값 return
        for (int i = 0; i < friends.length; i++) {
            if (forResultHashMap.containsKey(friends[i])) {
                if (result < forResultHashMap.get(friends[i])) {
                    result = forResultHashMap.get(friends[i]);
                }
            }
        }

        return result;
    }

    // 선물지수 구하는 메서드
    private long presentCounter(String name, HashMap<String, List<String>> hashMap) {
        // 내가 선물 준 횟수
        int giveGiftCount = 0;
        if (hashMap.containsKey(name)) {
            giveGiftCount = hashMap.get(name).size();
        }

        // 내가 선물 받은 횟수
        long receiveGiftCount = 0;
        for(String key : hashMap.keySet()) {
            if(!key.equals(name)) {
                long targetCount = hashMap.get(key).stream()
                        .filter(item -> item.equals(name))
                        .count();

                receiveGiftCount += targetCount;
            }
        }

        // 선물지수 : 준 선물 횟수 - 받은 선물 횟수
        return giveGiftCount - receiveGiftCount;
    }
}
