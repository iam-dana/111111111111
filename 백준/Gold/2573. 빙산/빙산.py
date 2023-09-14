from collections import deque
from copy import deepcopy
import sys
input = sys.stdin.readline


def bfs():
    cnt = 0

    visited = [[0]*m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            #print(i, j)
            #print(visited)
            if arr[i][j] and not visited[i][j]:
                cnt += 1
                q = deque()
                q.append((i, j))
                visited[i][j] = 1
                while q:
                    s = q.popleft()
                    x, y = s[0], s[1]
                    for d in range(4):
                        nx = x+dx[d]
                        ny = y+dy[d]
                        if 0 <= nx < n and 0 <= ny < m:
                            if not visited[nx][ny] and arr[nx][ny] > 0:
                                q.append([nx, ny])
                                visited[nx][ny] = 1
                        # print(visited)

    return cnt


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]


for i in (0, n-1):
    arr[i][0] = 0
for i in (0, m-1):
    arr[0][i] = 0


year = 1
if bfs() > 1:
    print(0)
    exit()

while 1:
    check = 0
    tmp = deepcopy(arr)
    for x in range(n):
        for y in range(m):
            if tmp[x][y] > 0:
                check = 1
                cnt = 0
                for i in range(4):
                    if 0 <= x+dx[i] < n and 0 <= y+dy[i] < m:
                        if not tmp[x+dx[i]][y+dy[i]]:
                            cnt += 1
                arr[x][y] -= cnt
                if arr[x][y] < 0:
                    arr[x][y] = 0

    part = bfs()
    if part > 1:
        break
    if not check:
        year = 0
        break
    year += 1

print(year)


