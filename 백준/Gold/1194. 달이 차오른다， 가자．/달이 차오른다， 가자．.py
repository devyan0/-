from collections import deque

N, M = map(int, input().split())
maze = [list(input()) for _ in range(N)]

res = float('inf')


def bfs(si, sj, s_keys):
    global res
    q = deque([(si, sj, s_keys, 0)])
    vis = set()
    while q:
        i, j, keys, cost = q.popleft()
        if (i, j, keys) in vis: continue
        vis.add((i, j, keys))

        # branch
        if res <= cost: continue

        # base case: out of range, wall
        if not (0 <= i < N and 0 <= j < M) or maze[i][j] == '#': continue

        # base case: found exit
        cur = maze[i][j]
        if cur == '1':
            res = min(res, cost)
            continue

        # base case: no keys in hand
        if cur in 'ABCDEF':
            s = ord(cur)-ord('A')
            if not (keys & (1 << s)): continue

        # add key if found
        if cur in 'abcdef':
            s = ord(cur)-ord('a')
            keys = keys | (1 << s)

        # travel
        for di, dj in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            ni, nj = i + di, j + dj
            q.append((ni, nj, keys, cost + 1))


for i in range(N):
    for j in range(M):
        if maze[i][j] == '0':
            bfs(i, j, 0)


print(res if res < float('inf') else -1)
