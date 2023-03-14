from collections import deque

N, M = map(int, input().split())
paint = [list(map(int, input().split())) for _ in range(N)]

def bfs(i, j):
    q, vis, sz = deque([(i, j)]), set(), 0

    while q:
        i, j = q.popleft()
        if (i, j) in vis: continue

        vis.add((i, j))
        paint[i][j] = 0
        sz += 1

        for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            ni, nj = i + di, j + dj
            if 0 <= ni < N and 0 <= nj < M and paint[ni][nj]:
                q.append((ni, nj))

    return sz


cnt = 0
max_size = 0
for i in range(N):
    for j in range(M):
        if paint[i][j]:
            max_size = max(max_size, bfs(i, j))
            cnt += 1 

print(cnt)
print(max_size)
