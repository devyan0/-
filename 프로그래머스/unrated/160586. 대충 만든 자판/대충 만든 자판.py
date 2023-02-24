from collections import defaultdict

def solution(keymap, targets):
    d = defaultdict(lambda: float('inf'))
    for km in keymap:
        for i, c in enumerate(km):
            d[c] = min(d[c], i+1)

    res = []
    for t in targets:
        cnt = 0
        for k in t:
            if d[k] == float('inf'):
                cnt = -1
                break
            cnt += d[k]
        res.append(cnt)

    return res
