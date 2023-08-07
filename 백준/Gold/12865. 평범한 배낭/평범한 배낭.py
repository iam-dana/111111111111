import sys
input = sys.stdin.readline

N, K = map(int, input().split())
dp = [[0]*(K+1) for _ in range(N+1)]
thing = [[0, 0]]

for _ in range(N):
    w, v = map(int, input().split())
    thing.append([w, v])



for i in range(1, N+1):
    for j in range(1, K+1):

        w = thing[i][0]  # 무게
        v = thing[i][1]  # 가치

        if j < w:
            dp[i][j] = dp[i-1][j]
        else:  # j >= w
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)

print(max(dp[N]))