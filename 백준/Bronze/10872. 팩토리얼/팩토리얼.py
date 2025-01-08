N = int(input())
ans = 1

while N>0:
    ans *= N
    N -= 1

print(ans)