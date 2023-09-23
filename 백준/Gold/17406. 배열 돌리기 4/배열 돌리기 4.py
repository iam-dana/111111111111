from itertools import permutations
from copy import deepcopy
import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
rcs = [list(map(int, input().split())) for _ in range(K)]
way = list(permutations(rcs, K))
origin = deepcopy(arr)
ans = sys.maxsize

for w in way:
    arr = deepcopy(origin)
    for k in range(K):
        r = w[k][0]
        c = w[k][1]
        S = w[k][2]

        for s in range(S, -1, -1):
            x = r - s - 1
            y = c - s - 1
            tmp = arr[x][y]
            for i in range(c - s, c + s):
                y = i
                next = arr[x][y]
                arr[x][y] = tmp
                tmp = next
            # for a in arr:
            #     print(a)
            # print()
            for i in range(r - s, r + s):
                x = i
                next = arr[x][y]
                arr[x][y] = tmp
                tmp = next
            # for a in arr:
            #     print(a)
            # print()
            for i in range(c+s-2, c-s-2, -1):
                y = i
                next = arr[x][y]
                arr[x][y] = tmp
                tmp = next
            # for a in arr:
            #     print(a)
            # print()
            for i in range(r+s-2, r-s-2, -1):
                x = i
                next = arr[x][y]
                arr[x][y] = tmp
                tmp = next

    # for a in arr:
    #     print(a)
    # print()
    for a in arr:
        ans = min(ans, sum(a))

print(ans)