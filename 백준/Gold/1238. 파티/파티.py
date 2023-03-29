from heapq import heappush as push, heappop as pop

N, M, X = map(int, input().split())
origin = [[float('inf') for _ in range(N+1)] for _ in range(N+1)]
reverse = [[float('inf') for _ in range(N+1)] for _ in range(N+1)]

for _ in range(M):
    s, e, c = map(int, input().split())
    origin[s][e] = reverse[e][s] = c


def run_dijkstra(graph, start=X):
    q = [(0, start)]
    visited = set()
    dist = [float('inf') for _ in range(N+1)]

    while q:
        dist_cur, cur = pop(q)
        if cur in visited: continue
        visited.add(cur)
        dist[cur] = dist_cur

        for adj, cost in enumerate(graph[cur]):
            if cost == float('inf'): continue
            push(q, (dist_cur+cost, adj))

    return dist


distance = [in_ + out_ for in_, out_ in zip(run_dijkstra(origin), run_dijkstra(reverse))]

print(max(distance[1:]))