import sys
input = sys.stdin.readline

S = list(input().rstrip())
now = []

for i in range(1, sys.maxsize):
    now.extend(str(i))

    idx = 0

    for j in range(len(now)-idx):
        # print(now[j], end=" ")
        if idx == len(S):
            break
        if S[idx] == now[j]:
            idx += 1
    # print()
    if idx == len(S):
        print(i)
        exit()
