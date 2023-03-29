import itertools as p 
i, u = int, input
n=range(i(u()))
g=[list(map(i, u().split()))for _ in n]
for m,s,t in p.product(n,repeat=3):
    g[s][t]=g[s][t]|(g[s][m]&g[m][t])
for l in g:
    print(*l)