from collections import deque

R, C = map(int, input().split())
field = [list(input()) for _ in range(R)]
mark = [[0] * C for _ in range(R)]


def bfs(i, j):
    q = deque([(i, j)])
    s, w = 0, 0
    mark[i][j] = 1

    while q:
        i, j = q.popleft()

        if field[i][j] == 'k':
            s += 1

        if field[i][j] == 'v':
            w += 1

        for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            ni, nj = i + di, j + dj
            if 0 <= ni < R and 0 <= nj < C and mark[ni][nj] == 0 and field[ni][nj] != '#':
                mark[ni][nj] = 1
                q.append((ni, nj))

    return (s, 0) if s > w else (0, w)


sheep, wolf = 0, 0
for i in range(R):
    for j in range(C):
        if field[i][j] != '#' and mark[i][j] == 0:
            s, w = bfs(i, j)
            sheep, wolf = sheep + s, wolf + w

print(sheep, wolf)

