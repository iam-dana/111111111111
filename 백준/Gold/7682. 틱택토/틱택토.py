
def isValid(game):

    if ''.join(game) == 'end':
        exit(0)

    if game.count('X') < game.count('O'):  # X의 개수가 O 보다 작을 수 없음
        print("invalid")
        return

    if game.count('X') - game.count('O') > 1:  # X와 O 의 차이가 1보다 클 수 없음
        print("invalid")
        return

    if game.count('X') < 3 and game.count('O') < 3:  # X와 O 의 개수가 모두 3보다 작으면 게임이 끝날 수 없음.
        print("invalid")
        return

    def findBingo():
        global bingo
        bingo = [0, 0]
        for i in range(3):  # 가로 확인
            if board[i] == ['X', 'X', 'X']:
                bingo[0] += 1
            elif board[i] == ['O', 'O', 'O']:
                bingo[1] += 1

        for i in range(3):  # 세로 확인
            tmp = []
            for j in range(3):
                tmp.append(board[j][i])
            if tmp == ['X', 'X', 'X']:
                bingo[0] += 1
            elif tmp == ['O', 'O', 'O']:
                bingo[1] += 1

        # 대각선 확인
        if [board[0][0], board[1][1], board[2][2]] == ['X', 'X', 'X']:
            bingo[0] += 1
        elif [board[0][0], board[1][1], board[2][2]] == ['O', 'O', 'O']:
            bingo[1] += 1

        if [board[0][2], board[1][1], board[2][0]] == ['X', 'X', 'X']:
            bingo[0] += 1
        elif [board[0][2], board[1][1], board[2][0]] == ['O', 'O', 'O']:
            bingo[1] += 1

    board = []

    for i in [0, 3, 6]:
        board.append(game[i:i + 3])

    findBingo()

    if bingo[0] > 0 and bingo[1] > 0:  # X, O 의 빙고가 동시에 존재할 수 없음
        print("invalid")
        return

    if game.count('X') > game.count('O'):  # X의 개수가 O 의 개수보다 많을 때, O의 빙고가 있을 수 없음.
        if bingo[1] > 0:
            print("invalid")
            return

        if bingo[0] == 2:  # X 빙고가 두 개일 때, 나눠진 빙고일 수 없음
            if board[1] == ['O', 'O', 'O']:
                print("invalid")
                return

            if [board[0][1], board[1][1], board[2][1]] == ['O', 'O', 'O']:
                print("invalid")
                return

        if bingo[0] == 0 and bingo[1] == 0:
            if game.count('X') + game.count('O') < 9:
                print("invalid")
                return

    if game.count('X') == game.count('O'):  # X와 O 의 개수가 같을 때
        if bingo[0] > 0:  # X 가 빙고였으면 O 를 두기 전에 끝났어야함
            print("invalid")
            return
        if bingo[1] == 0:   # O 가 빙고여야 최종상태임
            print("invalid")   
            return

    print("valid")
    return

while 1:
    game = list(input())
    isValid(game)
