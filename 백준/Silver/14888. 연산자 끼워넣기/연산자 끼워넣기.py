import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

n = int(input())
data = list(map(int, input().split()))
add, sub, mult, div = map(int, input().split())

ans_min = 1e9
ans_max = -1e9


def dfs(i, ans):
    global ans_max, ans_min, add, sub, mult, div
    if i == n - 1:
        ans_max = max(ans, ans_max)
        ans_min = min(ans, ans_min)
    else:
        if add > 0:
            add -= 1
            dfs(i + 1, ans + data[i + 1])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i + 1, ans - data[i + 1])
            sub += 1
        if mult > 0:
            mult -= 1
            dfs(i + 1, ans * data[i + 1])
            mult += 1
        if div > 0:
            div -= 1
            dfs(i + 1, int(ans / data[i + 1]))
            div += 1


dfs(0, data[0])
print(ans_max)
print(ans_min)