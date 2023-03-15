from collections import deque

N, K = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(N)]
S, X, Y = map(int, input().split())

def bfs(si, sj):
    q = deque([(si, sj)])
    cost, reach = 0, 0

    while q:
        sz = len(q)
        for _ in range(sz):
            i, j = q.popleft()
            if mat[i][j]:
                reach = min(reach, mat[i][j]) if reach else mat[i][j]

            for di, dj in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                ni, nj = i+di, j+dj
                if not (0 <= ni < N and 0 <= nj < N): continue
                q.append((ni, nj))

        if reach: return reach, cost
        cost += 1

fug, dist = bfs(X-1, Y-1)
print(fug if dist <= S else 0)
