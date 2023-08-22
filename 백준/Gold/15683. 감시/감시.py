from copy import deepcopy
import sys
input = sys.stdin.readline


def fill(x, y, arr, d):
    for i in d:
        nx, ny = x, y
        while True:
            nx = nx + dx[i]
            ny = ny + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if arr[nx][ny] == 6:
                    break
                elif arr[nx][ny] == 0:
                    arr[nx][ny] = '#'
            else:
                break


def dfs(arr, cnt):
    global result
    temp = deepcopy(arr)
    if cnt == cctv_cnt:
        num = 0
        for i in range(n):
            num += temp[i].count(0)
        result = min(result, num)
        return
    x, y, cctv = q[cnt]
    for i in direction[cctv]:
        fill(x, y, temp, i)
        dfs(temp, cnt+1)
        temp = deepcopy(arr)


n, m = map(int, input().split())
graph = []
q = []
cctv_cnt = 0
result = 100000000

direction = [[],
             [[0], [1], [2], [3]],
             [[0, 1], [2, 3]],
             [[1, 2], [2, 0], [0, 3], [3, 1]],
             [[3, 1, 2], [1, 2, 0], [2, 0, 3], [0, 3, 1]],
             [[0, 1, 2, 3]]
             ]


dx = [1, -1, 0, 0]  # D:0 U:1 R:2 L:3
dy = [0, 0, 1, -1]

for i in range(n):
    a = list(map(int, input().split()))
    graph.append(a)
    # cctv 세기
    for j in range(len(a)):
        if a[j] != 0 and a[j] != 6:
            q.append([i, j, a[j]])  # cctv 좌표 저장
            cctv_cnt += 1


dfs(graph, 0)
print(result)