import sys
N, M = map(int, sys.stdin.readline().split())

for i in range(N):
    print(sys.stdin.readline().strip()[::-1])