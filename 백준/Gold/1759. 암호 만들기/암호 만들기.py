from itertools import combinations
import sys
input = sys.stdin.readline

L, C = map(int, input().split())

a = list(input().split())

V = []
C = []

for tmp in a:
    if tmp == 'a' or tmp == 'e' or tmp == 'i' or tmp =='o' or tmp == 'u':
        C.append(tmp)
    else:
        V.append(tmp)

C.sort()
V.sort()
ans = []

for i in range(2, L):
    tmpV = combinations(V, i)
    for t in tmpV:
        tmpC = combinations(C, L-i)
        for c in tmpC:
            new = t + c
            new2 = sorted(new)
            ans.append(new2)

ans.sort()
for a in ans:
    for b in a:
        print(b, end="")
    print()
