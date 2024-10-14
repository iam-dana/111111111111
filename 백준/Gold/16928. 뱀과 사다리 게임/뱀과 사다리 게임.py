import sys
from collections import deque

def bfs():
    global ans
    while q:
        x, num = q.popleft()
        for i in range(1, 7):
            if x + i == 100:
                ans = min(ans, num + 1)
                return
            elif graph[x + i] != x + i and not visited[graph[x + i]]:
                q.append([graph[x + i], num + 1])
                visited[graph[x + i]] = 1
            elif graph[x+i] == x+i and not visited[x+i]:
                q.append([x + i, num + 1])
                visited[x + i] = 1


N, M = map(int, input().split())
graph = [i for i in range(0, 101)]
visited = [0 for _ in range(0, 101)]
ans = sys.maxsize


for _ in range(N+M):
    x, y = map(int, input().split())
    graph[x] = y

q = deque()
q.append([1, 0])
visited[1] = 1
bfs()

print(ans)

