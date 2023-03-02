import heapq
n = int(input())
info = [list(map(int, input().split())) for _ in range(n)]

info.sort(key=lambda x: x[0])
heap = []

for deadline, ramen in info:
    heapq.heappush(heap, ramen)

    if len(heap) > deadline:
        heapq.heappop(heap)

print(sum(heap))