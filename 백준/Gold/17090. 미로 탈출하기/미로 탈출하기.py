import sys
sys.setrecursionlimit(10**6)

n, m = map(int,input().split())

board = []
for _ in range(n):
    board.append(list(input()))

canExit = [[False for _ in range(m)] for _ in range(n)] # 이미 탐색이 끝난 노드가 탈출 가능한지 표시
visit = [[False for _ in range(m)] for _ in range(n)]

def dfs(y,x):
    visit[y][x] = True

    ny = y
    nx = x
    # 명령어에 따라 좌표 보정해줌
    if board[y][x] == 'U':
        ny -= 1
    elif board[y][x] == 'R':
        nx += 1
    elif board[y][x] == 'D':
        ny += 1
    elif board[y][x] == 'L':
        nx -= 1

    if ny < 0 or ny >= n or nx < 0 or nx >= m : # 탈출한 경우 탈출 가능하다고 표시한다.
        canExit[y][x] = True
    elif visit[ny][nx] :  # 이미 방문한 노드면 탈출 가능여부도 정해졌으니까 dfs 안돌리고 탈출가능 여부만 가져온다.
        canExit[y][x] = canExit[ny][nx]
    else :
        canExit[y][x] = dfs(ny,nx)  # 아직 방문 안했으면 탈출 가능여부 모르니까 dfs탐색 돌려서 탈출가능한지 파악한다.
    return canExit[y][x]  # 현재 노드의 탈출 가능여부를 반환한다.

for y in range(n):
    for x in range(m):
        if not visit[y][x] :
            dfs(y,x)

ans = 0
for y in range(n):
    for x in range(m):
        if canExit[y][x] :
            ans += 1
print(ans)