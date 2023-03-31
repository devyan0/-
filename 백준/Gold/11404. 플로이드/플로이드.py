V, E = int(input()), int(input())

graph = [[float('inf') for _ in range(V+1)] for _ in range(V+1)]

for _ in range(E):
    s, e, c = map(int, input().split())
    graph[s][e] = min(graph[s][e], c)


for k in range(1, V+1):
    for u in range(1, V+1):
        for v in range(1, V+1):
            graph[u][v] = min(graph[u][v], graph[u][k] + graph[k][v])


for i in range(1, V+1):
    for j in range(1, V+1):
        print(graph[i][j] if graph[i][j] != float('inf') and i != j else 0, end=' ')
    print()
