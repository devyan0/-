from heapq import heappush as push, heappop as pop
import sys
input = sys.stdin.readline

N = int(input())
info = sorted([list(map(int, input().split()[1:])) for x in range(N)])
res, q = 0, []

for start, end in info:
    if q and q[0] <= start: pop(q)
    push(q, end)

    res = max(res, len(q))

print(res)