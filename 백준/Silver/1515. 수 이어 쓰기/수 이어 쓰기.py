import sys

input = sys.stdin.readline

S = input().rstrip()
idx = 0

for i in range(1, sys.maxsize):
    now = str(i)

    for j in range(len(now)):
        if idx == len(S):
            break
        if S[idx] == now[j]:
            idx += 1

    if idx == len(S):
        print(i)
        exit()
