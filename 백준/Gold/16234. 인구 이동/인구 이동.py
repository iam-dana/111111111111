import sys
from collections import deque
input = sys.stdin.readline

n, l, r = map(int, input().split())
graph = []
ans = 0
for i in range(n):
    graph.append(list(map(int, input().split())))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def move(u):
    h = 0
    for x, y in u:
        h += graph[x][y]
    h = h // len(u)
    for x, y in u:
        graph[x][y] = h
    return


while 1:
    e_key = 0
    visited = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            unite = []
            q = deque()
            if not visited[i][j]:
                q.append([i, j])
                visited[i][j] = 1
                unite.append([i, j])
                while q:
                    x, y = q.popleft()
                    for k in range(4):
                        nx, ny = x+dx[k], y+dy[k]
                        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and l <= abs(graph[x][y] - graph[nx][ny]) <= r:
                            visited[nx][ny] = 1
                            q.append([nx, ny])
                            unite.append([nx, ny])
                if len(unite) > 1:
                    move(unite)
                    e_key += 1
    if not e_key:
        break
    else:
        ans += 1

print(ans)

