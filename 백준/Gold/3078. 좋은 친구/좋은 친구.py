from collections import defaultdict

N, K = map(int, input().split())
name_len = [len(input()) for _ in range(N)]
in_bound = defaultdict(int)

res = l = r = 0
# while r <= K:
#     in_ = name_len[r]
#     r += 1
#
#     if in_bound[in_]:
#         res += in_bound[in_]
#
#     in_bound[in_] += 1

while r < len(name_len):
    if K < r:
        out_ = name_len[l]
        l += 1

        in_bound[out_] -= 1

    in_ = name_len[r]
    r += 1

    if in_bound[in_]:
        res += in_bound[in_]

    in_bound[in_] += 1

print(res)