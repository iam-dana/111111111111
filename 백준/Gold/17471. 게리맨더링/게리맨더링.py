import sys, itertools, collections

input = sys.stdin.readline

N = int(input())
population = list(map(int, input().split()))
adj = []
g = collections.defaultdict(list)
answer = float('inf')


def bfs(arr):
    visited = [False] * (N + 1)
    q = collections.deque()
    q.append(arr[0])
    visited[arr[0]] = True

    while q:
        s = q.popleft()
        for next in g[s]:
            if next in arr and not visited[next]:
                q.append(next)
                visited[next] = True

    check = []
    for i in range(1, N + 1):
        if visited[i]:
            check.append(i)

    if arr == check:
        return True
    else:
        return False


for i in range(N):
    tmp = list(map(int, input().split()))
    for j in range(1, len(tmp)):
        g[i + 1].append(tmp[j])

tmp = [i for i in range(N+1)]
origin = [i for i in range(1, N + 1)]

for i in range(1, N // 2 + 1):
    for areaA in itertools.combinations(tmp, i):
        areaB = [x for x in range(1, N + 1) if x not in areaA]
        if bfs(list(areaA)) and bfs(areaB):
            pA = pB = 0
            for a in areaA:
                pA += population[a-1]
            for b in areaB:
                pB += population[b-1]
            answer = min(answer, abs(pA-pB))

if answer == float('inf'):
    print(-1)
else:
    print(answer)