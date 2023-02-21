from collections import defaultdict, deque

def solution(n, paths, gates, summits):
    summits.sort()
    d = defaultdict(lambda: defaultdict(int))
    for p in paths:
        n1, n2, w = p
        d[n1][n2] = w
        d[n2][n1] = w
    excld = set(summits)
    gout = set(gates)
    
    def search(s, lim):
        q = deque([s])
        vis = set()
        while q:
            node = q.popleft()
            if node in gout:
                return True

            # do not meet other gates or summits
            elif node != s and node in excld: continue

            if node in vis: continue
            vis.add(node)

            for child in d[node]:
                cost = d[node][child]
                if lim < cost: continue
                q.append(child)

        return False

    g_to_s = defaultdict(int)

    def valid(lim):
        for s in summits:
            if search(s, lim):
                return s

        return -1

    MAX_R = max(paths, key=lambda x: x[-1])[-1]
    l, r = 0, MAX_R+1
    while l < r:
        mid = (l+r)//2
        sm = valid(mid)
        if 0 <= sm:
            r = mid
        else:
            l = mid + 1

    l = min(l, MAX_R)
    return [valid(l), l]
