import sys
from collections import deque

input = sys.stdin.readline

N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

CMD = list(map(int, input().split()))
for C in CMD:
    if C == 1:
        for i in range(len(arr[0])):
            tmp = []
            for j in range(len(arr)):
                tmp.append(arr[j][i])
            tmp = list(reversed(tmp))
            for j in range(len(arr)):
                arr[j][i] = tmp[j]

    if C == 2:
        for i in range(len(arr)):
            arr[i] = list(reversed(arr[i]))

    if C == 3:
        arr = list(map(list, zip(*arr[::-1])))

    if C == 4:
        arr = list(map(list, zip(*arr)))[::-1]

    if C == 5:
        dx = [0, 0, len(arr) // 2, len(arr) // 2]
        dy = [0, len(arr[0]) // 2, len(arr[0]) // 2, 0]
        tmp = deque()
        for i in range(4):
            tmp2 = []
            for x in range(dx[i], dx[i] + len(arr) // 2):
                for y in range(dy[i], dy[i] + len(arr[0]) // 2):
                    tmp2.append(arr[x][y])
            tmp.append(tmp2)
        tmp.appendleft(tmp.pop())
        for i in range(4):
            s = tmp[i]
            idx = 0
            for x in range(dx[i], dx[i] + len(arr) // 2):
                for y in range(dy[i], dy[i] + len(arr[0]) // 2):
                    arr[x][y] = s[idx]
                    idx += 1

    if C == 6:
        dx = [0, 0, len(arr) // 2, len(arr) // 2]
        dy = [0, len(arr[0]) // 2, len(arr[0]) // 2, 0]
        tmp = deque()
        for i in range(4):
            tmp2 = []
            for x in range(dx[i], dx[i] + len(arr) // 2):
                for y in range(dy[i], dy[i] + len(arr[0]) // 2):
                    tmp2.append(arr[x][y])
            tmp.append(tmp2)
        tmp.append(tmp.popleft())
        for i in range(4):
            s = tmp[i]
            idx = 0
            for x in range(dx[i], dx[i] + len(arr) // 2):
                for y in range(dy[i], dy[i] + len(arr[0]) // 2):
                    arr[x][y] = s[idx]
                    idx += 1

for i in range(len(arr)):
    for j in range(len(arr[0])):
        print(arr[i][j], end=" ")
    print()
