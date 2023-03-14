from collections import defaultdict, deque

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(M)]
check = [[0 for _ in range(N)] for _ in range(M)]

size = defaultdict(int)
adj = defaultdict(set)

def bfs(si, sj, mark):
    q = deque([(si, sj)])

    while q:
        i, j = q.popleft()

        if check[i][j] == mark: continue
        check[i][j] = mark

        # if check[i][j] and check[i][j] != mark:
        #     adj[mark].add(check[i][j])
        #     continue

        size[mark] += 1
        for k in range(4):
            blocked = board[i][j] & (1 << k)
            ni, nj = i + [0, -1, 0, 1][k], j + [-1, 0, 1, 0][k]
            if not (0 <= ni < M and 0 <= nj < N): continue

            if blocked and check[ni][nj] != mark: adj[mark].add(check[ni][nj]); continue
            else: q.append((ni, nj))

for i in range(M):
    for j in range(N):
        if check[i][j]: continue
        bfs(i, j, len(size)+1)

print(len(size))
print(max(size.values()))

max_size = 0
for a1 in size.copy():
    for a2 in adj[a1]:
        max_size = max(max_size, size[a1] + size[a2])

print(max_size)