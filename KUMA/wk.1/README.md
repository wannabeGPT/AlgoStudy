# 바탕화면정리

## 아이디어
* x, y좌표의 단순 비교
* 재활에 적합한 문제

## 코드
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        char now = wallpaper[i].charAt(j);
        if(now == '.') {
            map[i][j] = 0;
        } else {
            map[i][j] = 1;

            minX = Math.min(minX, i);
            minY = Math.min(minY, j);

            maxX = Math.max(maxX, i+1);
            maxY = Math.max(maxY, j+1);

        }
    }
}
```

# 햄버거 만들기

## 아이디어
* 스택을 두 개 사용해서 한 스택에 재료를 순서대로 넣고 정해진 순서대로 재료가 갖춰지면 햄버거 제작
* 스택을 두 개 사용하는 아이디어가 중요한듯

## 코드
```java
for (int now : ingredient) {
    dq.offer(now);
    boolean flag = true;

    if (dq.size() >= 4) {
        for (int i = 0; i < 4; i++) {
            int cur = dq.pollLast();
            tmp.offer(cur);
            if (cur != correct[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            // 햄버거 완성된 경우
            while(!tmp.isEmpty()) {
                tmp.pollLast();
            }
            answer++;
        } else {
            // 햄버거 완성 못한 경우
            while(!tmp.isEmpty()) {
                int cur = tmp.pollLast();
                dq.offer(cur);
            }
        }
    }
}
```

# 마법의엘리베이터

## 아이디어
* 재귀호출을 통해 1의 자리를 검사해주고 넘어가는 식으로 해결
* 자리를 올림할 지 아니면 그대로 내릴 지를 분기한다.

## 코드
```java
public static int calc(int storey, int sum) {

    if (storey == 0) return sum;

    int now = storey % 10;
    int res;

    if (storey >= 10){
        res = Math.min(calc(storey / 10, sum + now ),
                calc(storey / 10 + 1, sum + (10 - now)));
    }else {
        res = Math.min(calc(storey / 10, sum + now), sum + (10 - now) + 1);
    }

    return res;
}
```

# 정수삼각형

## 아이디어
* 전형적인 dp문제, 피라미드 모양 아래부터 위로 bottom-up 방식으로 해결

## 코드
```java
public int solution(int[][] triangle) {
    int answer = 0;

    // 맨 아래에서 윗줄부터 아랫줄 양옆 중 높은 숫자 더해줌
    int size = triangle.length;

    for (int i = size-2; i >= 0; i--) {
        for (int j = 0; j < i+1; j++) {
            triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
        }
    }
    answer = triangle[0][0];
    return answer;
}
```