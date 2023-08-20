from collections import deque
n, k = map(int, input().split(" "))
visited = [0]*100001


def bfs():
    q = deque()
    q.append(n)
    visited[n] = 0
    while q:
        x = q.popleft()
        if x == k:
            break
        for nx in (x+1, x-1, x*2):
            if 0 <= nx < 100001 and not visited[nx]:
                q.append(nx)
                visited[nx] = visited[x] + 1

    return visited[k]


print(bfs())