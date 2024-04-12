import sys

input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
ans = []

for i in range(N):
    graph[i + 1].append(int(input()))

def dfs(start, now):
    if start == now:
        ans.append(now)
        return

    for i in graph[now]:
        if not visited[i]:
            visited[i] = 1
            dfs(start, i)


for i in range(1, N + 1):
    visited = [0] * (N + 1)
    for j in graph[i]:
        dfs(i, j)


print(len(ans))
for a in ans:
    print(a)