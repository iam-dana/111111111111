import sys, heapq as hq
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append([end, cost])


def dijkstra(start):
    q = []
    distance = [sys.maxsize]*(N+1)
    distance[start] = 0

    hq.heappush(q, [0, start])

    while q:
        now_cost, now = hq.heappop(q)
        if now_cost > distance[now]:
            continue
        for next, next_cost in graph[now]:
            if next_cost+now_cost < distance[next]:
                distance[next] = next_cost+now_cost
                hq.heappush(q, [next_cost+now_cost, next])

    return distance


start, end = map(int, input().split())
distance = dijkstra(start)
print(distance[end])