from collections import defaultdict
from bisect import bisect_left as bisect

def solution(e, starts):

    d = defaultdict(list)

    cnt = [1] * (e+1)
    for i in range(2, e+1):
        for j in range(i, e+1, i):
            cnt[j] += 1

    for i in range(1, e+1):
        c = cnt[i]
        d[c].append(i)

    keyset = sorted(d.keys(), reverse=True)
    res = []
    for s in starts:
        for k in keyset:
            idx = bisect(d[k], s)
            if idx == len(d[k]): continue
            res.append(d[k][idx])
            break


    return res