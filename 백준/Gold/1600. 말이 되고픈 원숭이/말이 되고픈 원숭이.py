from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    q = deque()
    q.append((0, 0, 0, 0))  # x좌표, y좌표, 거리, 대각선으로 움직인 수
    visited[0][0][0] = 1

    while q:
        s = q.popleft()
        x = s[0]
        y = s[1]
        dist = s[2]
        k = s[3]

        if x == H - 1 and y == W - 1:
            return dist

        if k < K:
            for i in range(8):
                nx = x + dxK[i]
                ny = y + dyK[i]
                if 0 <= nx < H and 0 <= ny < W:
                    if not visited[k + 1][nx][ny] and not board[nx][ny]:
                        q.append([nx, ny, dist + 1, k + 1])
                        visited[k + 1][nx][ny] = 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < H and 0 <= ny < W:
                if not visited[k][nx][ny] and not board[nx][ny]:
                    q.append([nx, ny, dist + 1, k])
                    visited[k][nx][ny] = 1
    return -1


K = int(input())
W, H = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(H)]

visited = [[[0]*W for _ in range(H)] for _ in range(31)]


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

dxK = [-2, -1, -2, -1, 1, 2, 1, 2]
dyK = [-1, -2, 1, 2, -2, -1, 2, 1]

print(bfs())