import sys
from itertools import product
input = sys.stdin.readline

N = input().strip()
destination = int(N)
M = int(input())
not_working = []
if M > 0:
    not_working = list(map(int, input().split()))
button = [str(i) for i in range(0, 10) if i not in not_working]
ans = abs(destination-100)

if len(N) >= 2:
    start = len(N)-1
else:
    start = 1
for l in range(start, len(N)+2):
    for p in product(button, repeat=l):
        ans = min(ans, abs(destination-int(''.join(p)))+l)

print(ans)