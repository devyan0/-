from itertools import accumulate

N, S = map(int, input().split())
nums = [int(x) for x in input().split()]
acc = [0] + list(accumulate(nums))

shortest = len(acc)+1
l, r = 0, 1
while r < len(acc):
    partial_sum = acc[r] - acc[l]
    if S <= partial_sum:
        shortest = min(shortest, r - l)
        l += 1
    else:
        r += 1

print(shortest if shortest <= len(acc) else 0)