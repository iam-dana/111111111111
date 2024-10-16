import sys, heapq as hq

input = sys.stdin.readline

N, M, X = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append([end, cost])


def dijkstra(start):
    q = []
    distance = [sys.maxsize]*(N+1)

    hq.heappush(q, [0, start])
    distance[start] = 0

    while q:
        now_cost, now = hq.heappop(q)

        if distance[now] < now_cost:
            continue

        for node_end, node_cost in graph[now]:
            tmp_cost = now_cost + node_cost

            if distance[node_end] > tmp_cost:
                distance[node_end] = tmp_cost
                hq.heappush(q, [tmp_cost, node_end])

    return distance


ans = 0
for i in range(1, N+1):
    go = dijkstra(i)
    back = dijkstra(X)
    ans = max(ans, go[X]+back[i])

print(ans)