from collections import deque
# TLE
def solution(beginning, target):
    ROW, COL = len(beginning), len(beginning[0])

    q = deque([[[False] * ROW, [False] * COL, 0]])
    visited = set()

    def check(flip_row, flip_col):
        for i in range(ROW):
            for j in range(COL):
                if beginning[i][j] ^ flip_row[i] ^ flip_col[j] != target[i][j]:
                    return False
        return True

    while q:
        fr, fc, cost = q.popleft()
        if check(fr, fc):
            return cost

        if tuple(fr+fc) in visited:
            continue
        visited.add(tuple(fr+fc))

        for i in range(ROW):
            new_fr = fr[::]
            new_fr[i] ^= True
            for c in range(COL):
                if not fc[c]: continue
                if (fc[c] and new_fr[i]) and (beginning[i][c] != target[i][c]):
                    break
            else:
                q.append([new_fr, fc, cost+1])

        for j in range(COL):
            new_fc = fc[::]
            new_fc[j] ^= True
            for r in range(ROW):
                if not fr[r]: continue
                if (fr[r] and new_fc[j]) and (beginning[r][j] != target[r][j]):
                    break
            else:
                q.append([fr, new_fc, cost+1])

    return -1
