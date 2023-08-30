import sys

input = sys.stdin.readline

N = int(input())
house = [list(map(int, input().split())) for _ in range(N)]

dp = [[[0, 0, 0] for _ in range(N)] for _ in range(N)]  # 0: 세로 1: 가로 2: 대각선

for i in range(1, N):
    if not house[0][i]:
        dp[0][i][1] = 1
    else:
        break

for x in range(1, N):
    for y in range(1, N):
        if not house[x][y]:
            dp[x][y][0] = dp[x - 1][y][0] + dp[x - 1][y][2]

            dp[x][y][1] = dp[x][y - 1][1] + dp[x][y - 1][2]

            if not house[x - 1][y] and not house[x][y - 1]:
                dp[x][y][2] = dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2]


print(sum(dp[N - 1][N - 1]))
