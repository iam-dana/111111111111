import sys
input = sys.stdin.readline

N = int(input())
budget = list(map(int, input().split()))
budget.sort()
total = int(input())
ans = 0

if sum(budget) <= total:
    print(budget[-1])
    exit(0)

start = 1
end = budget[-1]

while start <= end:
    mid = (end+start)//2
    tmp = 0
    for b in budget:
        if b <= mid:
            tmp += b
        else:
            tmp += mid
    if tmp <= total:
        ans = max(mid, ans)
        start = mid+1
    else:
        end = mid-1

print(ans)