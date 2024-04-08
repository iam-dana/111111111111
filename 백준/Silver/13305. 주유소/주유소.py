N = int(input())
length = list(map(int, input().split()))
price = list(map(int, input().split()))

minPrice = price[0]
ans = 0

for i in range(N-1):  # 마지막 가격은 셀 필요 없음
    if minPrice > price[i]:
        minPrice = price[i]  # 현재 가격이 더 싸다면 교체
    ans += minPrice*length[i]

print(ans)