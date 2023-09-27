board = [list(map(int, input())) for _ in range(9)]
zero = []
for i in range(9):
    for j in range(9):
        if not board[i][j]:
            zero.append([i, j])


def dfs(depth):
    if depth == len(zero):
        for i in range(9):
            for j in range(9):
                print(board[i][j], end="")
            print()
        exit(0)
        return

    x = zero[depth][0]
    y = zero[depth][1]
    visited = [0] * 10

    for i in range(9):
        if board[x][i]:
            visited[board[x][i]] = 1

    for i in range(9):
        if board[i][y]:
            visited[board[i][y]] = 1

    for i in range(x // 3 * 3, x // 3 * 3 + 3):
        for j in range(y // 3 * 3, y // 3 * 3 + 3):
            if board[i][j]:
                visited[board[i][j]] = 1

    for i in range(1, 10):
        if not visited[i]:
            board[x][y] = i
            dfs(depth + 1)
            board[x][y] = 0


dfs(0)

"""
# 가로
arr1 = []
for i in board:
    arr1.append(i)

# 세로
arr2 = []
for i in range(9):
    tmp = []
    for j in range(9):
        tmp.append(board[j][i])
    arr2.append(tmp)

# 네모칸
arr3 = []
for i in range(0, 9, 3):
    for j in range(0, 9, 3):
        tmp = []
        for x in range(i, i+3):
            for y in range(j, j+3):
                tmp.append(board[x][y])
        arr3.append(tmp)
"""
