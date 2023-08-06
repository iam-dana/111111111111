from collections import deque

T = int(input())
for t in range(T):
    cube = [['w','w','w','w','w','w','w','w','w'],   # 0: 위(U)
            ['g','g','g','g','g','g','g','g','g'],   # 1: 왼(L)
            ['r','r','r','r','r','r','r','r','r'],   # 2: 앞(F)
            ['b','b','b','b','b','b','b','b','b'],   # 3: 오(R)
            ['o','o','o','o','o','o','o','o','o'],   # 4: 뒤(B)
            ['y','y','y','y','y','y','y','y','y']]   # 5: 아래(D)

    n = int(input())
    method = list(map(str, input().split()))


    def print_cube():
        for i in range(6):
            print(i)
            for j in range(9):
                if j != 0 and j % 3 == 0:
                    print()
                print(cube[i][j], end="")
            print()
        print()

    def right(x):
        cube[x][0], cube[x][1], cube[x][2], cube[x][3], cube[x][4], cube[x][5], cube[x][6], cube[x][7], cube[x][8] = cube[x][6], cube[x][3], cube[x][0], cube[x][7], cube[x][4], cube[x][1], cube[x][8], cube[x][5], cube[x][2]


    def left(x):
        cube[x][0], cube[x][1], cube[x][2], cube[x][3], cube[x][4], cube[x][5], cube[x][6], cube[x][7], cube[x][8] = cube[x][2], cube[x][5], cube[x][8], cube[x][1], cube[x][4], cube[x][7], cube[x][0], cube[x][3], cube[x][6]


    for m in method:
        side, d = m[0], m[1]
        if side == 'U':  # 위를 돌리면 1, 2, 3, 4의 (0, 1, 2) 바뀜
            tmp = deque()
            tmp.append([cube[2][0], cube[2][1], cube[2][2]])
            tmp.append([cube[3][0], cube[3][1], cube[3][2]])
            tmp.append([cube[4][0], cube[4][1], cube[4][2]])
            tmp.append([cube[1][0], cube[1][1], cube[1][2]])
            if d == '+':  # 2341 -> 3412
                right(0)
                s = tmp.popleft()
                tmp.append(s)
                cube[2][0], cube[2][1], cube[2][2] = tmp[0]
                cube[3][0], cube[3][1], cube[3][2] = tmp[1]
                cube[4][0], cube[4][1], cube[4][2] = tmp[2]
                cube[1][0], cube[1][1], cube[1][2] = tmp[3]
            else:  # 2341 -> 1234
                left(0)
                s = tmp.pop()
                tmp.appendleft(s)
                cube[2][0], cube[2][1], cube[2][2] = tmp[0]
                cube[3][0], cube[3][1], cube[3][2] = tmp[1]
                cube[4][0], cube[4][1], cube[4][2] = tmp[2]
                cube[1][0], cube[1][1], cube[1][2] = tmp[3]
            # print_cube()

        elif side == 'D':  # 아래를 돌리면 1, 2, 3, 4 의 (6, 7, 8) 바뀜
            tmp = deque()
            tmp.append([cube[2][6], cube[2][7], cube[2][8]])
            tmp.append([cube[3][6], cube[3][7], cube[3][8]])
            tmp.append([cube[4][6], cube[4][7], cube[4][8]])
            tmp.append([cube[1][6], cube[1][7], cube[1][8]])
            if d == '+':  # 2341 -> 1234
                right(5)
                s = tmp.pop()
                tmp.appendleft(s)
                cube[2][6], cube[2][7], cube[2][8] = tmp[0]
                cube[3][6], cube[3][7], cube[3][8] = tmp[1]
                cube[4][6], cube[4][7], cube[4][8] = tmp[2]
                cube[1][6], cube[1][7], cube[1][8] = tmp[3]
            else:  # 2341 -> 3412
                left(5)
                s = tmp.popleft()
                tmp.append(s)
                cube[2][6], cube[2][7], cube[2][8] = tmp[0]
                cube[3][6], cube[3][7], cube[3][8] = tmp[1]
                cube[4][6], cube[4][7], cube[4][8] = tmp[2]
                cube[1][6], cube[1][7], cube[1][8] = tmp[3]
            # print_cube()

        elif side == 'F':  # 앞면을 돌리면 0, 1, 3, 5 가 바뀜
            tmp = deque()
            tmp.append([cube[0][6], cube[0][7], cube[0][8]])
            tmp.append([cube[1][2], cube[1][5], cube[1][8]])
            tmp.append([cube[5][0], cube[5][1], cube[5][2]])
            tmp.append([cube[3][0], cube[3][3], cube[3][6]])
            if d == '+':   # 0153 -> 1530
                right(2)
                s = tmp.popleft()
                tmp.append(s)  # 0, 5
                cube[0][8], cube[0][7], cube[0][6] = tmp[0]
                cube[1][2], cube[1][5], cube[1][8] = tmp[1]
                cube[5][2], cube[5][1], cube[5][0] = tmp[2]
                cube[3][0], cube[3][3], cube[3][6] = tmp[3]
            else:  # 0153 -> 3015
                left(2)
                s = tmp.pop()
                tmp.appendleft(s)
                cube[0][6], cube[0][7], cube[0][8] = tmp[0]
                cube[1][8], cube[1][5], cube[1][2] = tmp[1]
                cube[5][0], cube[5][1], cube[5][2] = tmp[2]
                cube[3][6], cube[3][3], cube[3][0] = tmp[3]
            # print_cube()

        elif side == 'B':  # 뒷면을 돌리면 0 1 3 5 가 바뀜
            tmp = deque()
            # +(시계방향 일 때), 0153 -> 3015
            # -(반시계방향 일 때), 0153 -> 1530
            tmp.append([cube[0][0], cube[0][1], cube[0][2]])
            tmp.append([cube[1][0], cube[1][3], cube[1][6]])
            tmp.append([cube[5][6], cube[5][7], cube[5][8]])
            tmp.append([cube[3][2], cube[3][5], cube[3][8]])
            if d == '+':
                right(4)
                s = tmp.pop()
                tmp.appendleft(s)   # 반대: 1, 3
                cube[0][0], cube[0][1], cube[0][2] = tmp[0]
                cube[1][6], cube[1][3], cube[1][0] = tmp[1]
                cube[5][6], cube[5][7], cube[5][8] = tmp[2]
                cube[3][8], cube[3][5], cube[3][2] = tmp[3]
            else:
                left(4)
                s = tmp.popleft()
                tmp.append(s)
                cube[0][2], cube[0][1], cube[0][0] = tmp[0]
                cube[1][0], cube[1][3], cube[1][6] = tmp[1]
                cube[5][8], cube[5][7], cube[5][6] = tmp[2]
                cube[3][2], cube[3][5], cube[3][8] = tmp[3]
            # print_cube()

        elif side == 'L':  # 왼쪽을 돌리면 0254 가 바뀜
            tmp = deque()
            # +(시계방향 일 때), 0254 -> 4025
            # -(반시계방향 일 때), 0254 -> 2540
            tmp.append([cube[0][0], cube[0][3], cube[0][6]])
            tmp.append([cube[2][0], cube[2][3], cube[2][6]])
            tmp.append([cube[5][0], cube[5][3], cube[5][6]])
            tmp.append([cube[4][2], cube[4][5], cube[4][8]])
            if d == '+':
                right(1)
                s = tmp.pop()
                tmp.appendleft(s)    # 0, 4
                cube[0][6], cube[0][3], cube[0][0] = tmp[0]
                cube[2][0], cube[2][3], cube[2][6] = tmp[1]
                cube[5][0], cube[5][3], cube[5][6] = tmp[2]
                cube[4][8], cube[4][5], cube[4][2] = tmp[3]
            else:
                left(1)
                s = tmp.popleft()
                tmp.append(s)  # 5 4
                cube[0][0], cube[0][3], cube[0][6] = tmp[0]
                cube[2][0], cube[2][3], cube[2][6] = tmp[1]
                cube[5][6], cube[5][3], cube[5][0] = tmp[2]
                cube[4][8], cube[4][5], cube[4][2] = tmp[3]
            # print_cube()

        elif side == 'R':  # 오을 돌리면 0254 가 바뀜
            tmp = deque()
            # +(시계방향 일 때), 0254 -> 2540
            # -(반시계방향 일 때), 0254 -> 4025
            tmp.append([cube[0][2], cube[0][5], cube[0][8]])
            tmp.append([cube[2][2], cube[2][5], cube[2][8]])
            tmp.append([cube[5][2], cube[5][5], cube[5][8]])
            tmp.append([cube[4][0], cube[4][3], cube[4][6]])
            if d == '+':
                right(3)
                s = tmp.popleft()
                tmp.append(s)  # 5, 4
                cube[0][2], cube[0][5], cube[0][8] = tmp[0]
                cube[2][2], cube[2][5], cube[2][8] = tmp[1]
                cube[5][8], cube[5][5], cube[5][2] = tmp[2]
                cube[4][6], cube[4][3], cube[4][0] = tmp[3]
            else:
                left(3)
                s = tmp.pop()
                tmp.appendleft(s)   # 0, 4
                cube[0][8], cube[0][5], cube[0][2] = tmp[0]
                cube[2][2], cube[2][5], cube[2][8] = tmp[1]
                cube[5][2], cube[5][5], cube[5][8] = tmp[2]
                cube[4][6], cube[4][3], cube[4][0] = tmp[3]
            # print_cube()

    for i in range(9):
        if i != 0 and i % 3 == 0:
            print()
        print(cube[0][i], end="")
    print()