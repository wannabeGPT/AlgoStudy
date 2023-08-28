package Algo;

import java.util.*;

public class 디펜스게임 {

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int size = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);
            if (n < 0 && k > 0) {
                n += pq.poll();
                k--;
//                System.out.printf("%d번째 n: %d , k: %d\n", i+1, n, k);
            }else if (n < 0 && k <= 0){
                break;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1}));
    }
}
