def solution(board):
    cnto = sum([x.count('O') for x in board])
    cntx = sum([x.count('X') for x in board])
    wino = win(board, 'O')
    winx = win(board, 'X')
    res = 1

    if wino and winx:
        res = 0
    elif wino:
        if not cnto == cntx+1:
            res = 0
    elif winx:
        if not cnto == cntx:
            res = 0
    else:
        if cnto not in [cntx, cntx+1]:
            res = 0
    
    return res

def win(board, c):
    for row in board:
        if all(map(lambda x: x==c, row)):
            return True
    for row in zip(*board):
        if all(map(lambda x: x==c, row)):
            return True
    diag1 = [board[i][i] for i in range(3)]
    if all(map(lambda x: x==c, diag1)):
        return True
    diag2 = [board[2-i][i] for i in range(3)]
    if all(map(lambda x: x==c, diag2)):
        return True
    
    return False