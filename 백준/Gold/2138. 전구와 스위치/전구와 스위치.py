N = int(input())

start = list(map(int, input()))
result = list(map(int, input()))


def toggle():
    tmp = start[:]
    cnt = 0

    for i in range(1, N):
        if tmp[i - 1] == result[i - 1]:  # 직전의 전구만 비교
            continue
        cnt += 1
        for j in [-1, 0, 1]:
            if i + j < N:
                tmp[i + j] = 1 - tmp[i + j]

    if tmp == result:
        return cnt
    else:
        return 1e9


ans = toggle()
# 첫 번째 전구 토글
start[0] = 1 - start[0]
start[1] = 1 - start[1]

ans = min(ans, toggle()+1)  # 첫 번째 전구 토글한 것 1 더해줌

if ans == 1e9:
    print(-1)
else:
    print(ans)
