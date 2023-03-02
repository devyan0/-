'''
주어진 정보들 중에서 선택하지 않을 정보를 제거하는 방식
'''
import heapq
n = int(input())
info = [list(map(int, input().split())) for _ in range(n)]

info.sort(key = lambda x : x[0]) #데드라인 순으로 정렬함
heap = []
heapq.heapify(heap)
for item in info:
    deadline, ramen = item
    heapq.heappush(heap, ramen) #라면의 개수를 힙에 넣어준다 (라면의 개수가 작은 것 순서로 정렬됨)

    if len(heap) > deadline: #힙에 넣은 라면의 수가 데드라인을 넘어가면
        heapq.heappop(heap) #제일 작은 라면의 개수 제거

print(sum(heap))