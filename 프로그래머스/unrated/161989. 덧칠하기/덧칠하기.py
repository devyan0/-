from collections import deque
def solution(n, m, section):
    q = deque(sorted(section))
    cur = 0
    cnt = 0
    while q and cur <= n:
        next_ = q.popleft()
        if next_ < cur:
            continue
        cur = next_ + m
        cnt += 1
    
    return cnt
            