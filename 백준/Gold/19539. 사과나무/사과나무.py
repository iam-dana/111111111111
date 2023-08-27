
N = int(input())
height = list(map(int, input().split()))
sum = 0
cnt = 0

for h in height:
    sum += h
    cnt += h//2

if sum % 3 == 0 and cnt >= sum//3:
    print("YES")
else:
    print("NO")












