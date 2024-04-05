N = int(input())
M = int(input())
loc = list(map(int, input().split()))
road = [0] * (N + 1)
ans = 0

if M >= 2:
    ans = max(ans, loc[0], N-loc[M-1])
    for i in range(len(loc) - 1):
        if (loc[i+1]-loc[i]) % 2 == 0:
            ans = max(ans, (loc[i+1] - loc[i])//2)
        else:
            ans = max(ans, (loc[i+1] - loc[i])//2+1)
else:
    ans = max(ans, loc[0], N-loc[M-1])
print(ans)

