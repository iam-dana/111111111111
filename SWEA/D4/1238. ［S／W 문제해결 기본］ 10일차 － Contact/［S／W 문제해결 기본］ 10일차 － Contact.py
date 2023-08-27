from collections import deque

def bfs(start):
    visited = [0 for _ in range(101)]
    q = deque()
    q.append([start, 0])
    visited[start] = 1

    while q:
        s = q.popleft()
        idx = s[0]
        cnt = s[1]
        ans[cnt].append(idx)

        for i in l[idx]:
            if not visited[i]:
                q.append([i, cnt+1])
                visited[i] = 1

    return cnt


for t in range(1, 11):
    N, S = map(int, input().split())
    arr = list(map(int, input().split()))
    l = [[] for _ in range(101)]
    ans = [[] for _ in range(101)]

    for i in range(len(arr)-1):
        if i % 2 == 0:
            l[arr[i]].append(arr[i+1])

    last = bfs(S)
    print("#{} {}".format(t, max(ans[last])))





