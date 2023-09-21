arr = []
ans = 1
num = 0
for i in range(9):
    arr.append(int(input()))
    if arr[i] > num:
        num = arr[i]
        ans = i+1
print(num)
print(ans)
