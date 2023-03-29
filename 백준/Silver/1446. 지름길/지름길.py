N, D = map(int, input().split())
shortcuts = [list(map(int, input().split())) for _ in range(N)]

dist = [float('inf')] * (D+1)
dist[0] = 0

for i in range(D+1):
    dist[i] = min(dist[i], dist[i - 1] + 1)
    for s, e, c in shortcuts:
        if i != s or D < e: continue

        dist[e] = min(dist[e], dist[i]+c)

print(dist[D])