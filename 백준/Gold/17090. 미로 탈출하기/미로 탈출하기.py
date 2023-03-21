import sys
MOVE = {'U': (-1, 0), 'R': (0, 1), 'D': (1, 0), 'L': (0, -1)}

N, M = map(int, input().split())
sys.setrecursionlimit(N*M)

board = [list(input()) for _ in range(N)]
memo = [[-2 for _ in range(M)] for _ in range(N)]   # -2: undetermined, -1: finding, 0: False, 1: True
out_of_bound = lambda i, j: not (0<=i<N) or not (0<=j<M)


def dp(i, j):
    if 0 <= memo[i][j]:
        return memo[i][j]
    if memo[i][j] == -1:
        memo[i][j] = 0
        return memo[i][j]

    memo[i][j] = -1
    di, dj = MOVE[board[i][j]]
    ni, nj = i+di, j+dj

    memo[i][j] = out_of_bound(ni, nj) or dp(ni, nj)
    return memo[i][j]


cnt = 0
for i in range(N):
    for j in range(M):
        cnt += dp(i, j)
print(cnt)
