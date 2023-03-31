V, E = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(E)]

# run Bellman Ford
def bellman_ford():
    # return [] if there exist negative cycle
    dist = [float('inf')] * (V + 1)
    dist[1] = 0

    for repeat in range(V-1):
        for s, e, c in edges:
            dist[e] = min(dist[e], dist[s] + c)

    for s, e, c in edges:
        if dist[e] > dist[s]+c: return []

    return dist

res = bellman_ford()

if res:
    for d in res[2:]: print(d if d < float('inf') else -1)
else:
    print(-1)