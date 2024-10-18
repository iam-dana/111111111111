import sys
from collections import deque

input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[0]*M for _ in range(N)]


def mark(i, j, count):
    q = deque()
    q.append([i, j])
    graph[i][j] = count
    visited[i][j] = 1

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if 0 > nx or nx >= N or 0 > ny or ny >= M or visited[nx][ny]:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = count
                visited[nx][ny] = 1
                q.append([nx, ny])


count = 1
for i in range(N):
    for j in range(M):
        if not visited[i][j] and graph[i][j] == 1:
            mark(i, j, count)
            count += 1

edge = set()


def getDist(i, j, island):
    q = deque()
    for d in range(4):
        q.append([i, j, 0, d])

    while q:
        x, y, count, dir = q.popleft()
        nx, ny = x+dx[dir], y+dy[dir]
        if 0 > nx or nx >= N or 0 > ny or ny >= M or graph[nx][ny] == island:
            continue

        if not graph[nx][ny]:
            q.append([nx, ny, count+1, dir])
            continue

        if graph[nx][ny] != island and count >= 2:
            edge.add((count, island, graph[nx][ny]))


for i in range(N):
    for j in range(M):
        if graph[i][j]:
            getDist(i, j, graph[i][j])


edge = list(edge)
edge.sort()

parent = [i for i in range(count)]


def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = parent[a]
    else:
        parent[a] = parent[b]


ans = 0
num = 1
for cost, start, end in edge:
    if find(start) != find(end):
        num += 1
        union(start, end)
        ans += cost


if ans == 0 or num != count-1:
    print(-1)
else:
    print(ans)