import sys, itertools

input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))
tmp = list(map(int, input().split()))
arr = []
min_ans = 1000000000
max_ans = -1000000000

for i in range(4):
    if i == 0:
        for _ in range(tmp[i]):
            arr.append("plus")
    elif i == 1:
        for _ in range(tmp[i]):
            arr.append("minus")
    elif i == 2:
        for _ in range(tmp[i]):
            arr.append("mul")
    else:
        for _ in range(tmp[i]):
            arr.append("div")

for c in itertools.permutations(arr, N-1):
    tmp = num[0]
    for n in range(N-1):
        if c[n] == "plus":
             tmp += num[n+1]
        elif c[n] == "minus":
             tmp -= num[n+1]
        if c[n] == "mul":
             tmp *= num[n+1]
        if c[n] == "div":
            if tmp < 0:
                tmp = ((-1*tmp)//num[n+1])*-1
            else:
                tmp //= num[n+1]
    min_ans = min(min_ans, tmp)
    max_ans = max(max_ans, tmp)

print(max_ans)
print(min_ans)