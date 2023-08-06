from collections import deque

n, m = map(int, input().split())
graph = [list(input()) for _ in range(n)]
dist = 0
treasure = []
t1_x, t1_y, t2_x, t2_y = 0, 0, 0, 0
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(n):
    for j in range(m):
        visited = [[0] * m for _ in range(n)]
        q = deque()
        tmp_x, tmp_y = 0, 0
        tmp_dist = 0
        # 보물을 가정
        if graph[i][j] == 'L':
            visited[i][j] = 1
            q.append((i, j))
            while q:
                x, y = q.popleft()
                for k in range(4):
                    nx, ny = x+dx[k], y+dy[k]
                    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 'L' and not visited[nx][ny]:
                        q.append((nx, ny))
                        visited[nx][ny] = visited[x][y] + 1
                        tmp_x, tmp_y = nx, ny
                        tmp_dist = visited[nx][ny]
        if tmp_dist > dist:
            dist = tmp_dist
            t1_x, t1_y, t2_x, t2_y = i, j, tmp_x, tmp_y

print(dist-1)