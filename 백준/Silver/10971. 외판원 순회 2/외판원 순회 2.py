import sys
input = sys.stdin.readline

ans = sys.maxsize


def dfs(start, next, cost, visited):
    global ans
    if len(visited) == N:
        if board[next][start]:
            ans = min(ans, cost+board[next][start])
        return

    for i in range(N):
        if board[next][i] and i not in visited and not ans < cost:
            visited.append(i)
            dfs(start, i, cost+board[next][i], visited)
            visited.pop()


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    dfs(i, i, 0, [i])

print(ans)
