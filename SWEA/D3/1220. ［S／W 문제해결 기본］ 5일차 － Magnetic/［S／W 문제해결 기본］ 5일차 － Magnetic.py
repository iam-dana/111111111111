# 테이블 위(x=0) N극, 테이블 아래(x=N) S극, 1: N(빨강), 2: S(파랑)

for t in range(10):
    n = int(input())
    graph = [list(map(int, input().split())) for _ in range(n)]
    ans = 0

    # 1(빨강, N) 은 오른쪽으로,  2(파랑, S) 은 왼쪽으로
    for i in range(len(graph)):
        tmp = [a[i] for a in graph]
        for j in range(len(tmp)):
            if tmp[j] == 1:
                if j == len(tmp)-1:
                    tmp[j] = 0
                    continue
                elif tmp[j+1] == 0:
                    tmp[j], tmp[j+1] = tmp[j+1], tmp[j]
                elif tmp[j+1] == 2:
                    ans += 1
                elif tmp[j+1] == 1:
                    continue
            elif tmp[j] == 2:
                if j == 0:
                    tmp[j] = 0
                    continue
                elif tmp[j-1] == 0:
                    tmp[j], tmp[j-1] = tmp[j-1], tmp[j]
                elif tmp[j-1] == 1:
                    ans += 1
                elif tmp[j-1] == 2:
                    continue
    print('#{} {}'.format(t+1, ans//2))