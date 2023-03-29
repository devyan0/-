N = int(input())
connected = [input().split() for _ in range(N)]
dist = [[float('inf') for _ in range(N)] for _ in range(N)]

for n1 in range(N):
    for n2 in range(N):
        if connected[n1][n2] == '1':
            dist[n1][n2] = 0

for k in range(N):
    for n1 in range(N):
        for n2 in range(N):
            dist[n1][n2] = min(dist[n1][n2], dist[n1][k] + dist[k][n2])


for i in range(N):
    for j in range(N):
        dist[i][j] = 0 if dist[i][j] else 1

for row in dist:
    print(*row)