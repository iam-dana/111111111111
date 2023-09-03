from sys import maxsize
m = maxsize

N = int(input())

D = [[0]*N for _ in range(N+1)]
cost = [[0]*N for _ in range(N+1)]

for i in range(1, N+1):
    x, y, z = map(int, input().split())
    cost[i][0] = x
    cost[i][1] = y
    cost[i][2] = z

ans = m
for first in range(3):  # 첫번째 집 RGB 012
    for i in range(3):
        if i == first:
            D[1][i] = cost[1][i]
        else:
            D[1][i] = m

    for i in range(2, N+1):
        D[i][0] = cost[i][0] + min(D[i-1][1], D[i-1][2])
        D[i][1] = cost[i][1] + min(D[i-1][0], D[i-1][2])
        D[i][2] = cost[i][2] + min(D[i-1][0], D[i-1][1])

    for i in range(3):
        if i == first:
            continue
        ans = min(ans, D[N][i])

print(ans)

