N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]


for i in range(min(N, M) // 2):
    # num = 2*(N-1-i-i) + 2*(M-1-i-i)
    # print(num)
    for _ in range(R % (2*(N-1-i-i) + 2*(M-1-i-i))):
        x, y = i, i
        tmp = arr[x][y]

        for j in range(i + 1, N - i):
            x = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

        for j in range(i + 1, M - i):
            y = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

        for j in range(N - i - 2, i - 1, -1):
            x = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

        for j in range(M - i - 2, i - 1, -1):
            y = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

for i in range(len(arr)):
    for j in range(M):
        print(arr[i][j], end=" ")
    print()
