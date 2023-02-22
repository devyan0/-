from heapq import heappush as push, heappop as pop
import sys
input = sys.stdin.readline

N = int(input())
info = sorted([list(map(int, input().split())) for _ in range(N)])

res, save, t = 0, 1, info[-1][0]
tasks = []
while 0 < t:
    while info and t <= info[-1][0]:
        push(tasks, -info.pop()[1])

    if 0 < save and tasks:
        res += -pop(tasks)
        save -= 1

    t, save = t-1, save+1

print(res)