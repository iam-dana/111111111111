N, M, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

for _ in range(R):
    for i in range(min(N, M)//2):
        x, y = i, i
        tmp = arr[x][y]

        for j in range(i+1, N-i):
            x = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

        for j in range(i+1, M-i):
            y = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

        for j in range(N-i-2, i-1, -1):
            x = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

        for j in range(M-i-2, i-1, -1):
            y = j
            prev = arr[x][y]
            arr[x][y] = tmp
            tmp = prev

for i in range(len(arr)):
    for j in range(M):
        print(arr[i][j], end=" ")
    print()