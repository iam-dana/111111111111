import sys
input = sys.stdin.readline

N, M = map(int, input().split())

for i in range(N):
    str = input().strip()
    print(str[::-1])