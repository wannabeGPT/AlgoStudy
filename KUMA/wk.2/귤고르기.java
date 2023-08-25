package Algo;

import java.util.*;

public class 귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        // k개 상자
        // 서로 다른 종류의 수의 최솟값

        HashMap counter = new HashMap<Integer, Integer>();

        int size = tangerine.length;

        for (int i = 0; i < size; i++) {
            int now = tangerine[i];

            if (counter.get(now) != null){
                counter.put(now, (int)counter.get(now) + 1);
            }else {
                counter.put(now, 1);
            }
        }

        Collection<Integer> values = counter.values();
        ArrayList<Integer> res = new ArrayList();
        for (int x : values) {
            res.add(x);
        }
        Collections.sort(res, Collections.reverseOrder());
        int sum = 0;
        for (int x : res) {
            sum += x;
            answer++;
            if (sum >= k) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
