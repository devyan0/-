def solution(commands):
    MAX = 51
    res = []
    merged = [[(i, j) for j in range(MAX)] for i in range(MAX)]
    values = [[None for _ in range(MAX)] for _ in range(MAX)]

    def printBoard():
        for i, row in enumerate(merged):
            for j, val in enumerate(row):
                nr, nc = val
                if values[nr][nc]:
                    print(i, j, values[nr][nc])
        print()

    for c in commands:
        info = c.split(' ')
        if info[0] == 'UPDATE':
            if len(info) == 4:
                _, r, c, val = info
                x, y = merged[int(r)][int(c)]
                values[x][y] = val

            if len(info) == 3:
                _, old_val, new_val = info
                for i, row in enumerate(values):
                    for j, val in enumerate(row):
                        if val == old_val:
                            values[i][j] = new_val

        if info[0] == 'MERGE':
            _, r1, c1, r2, c2 = info
            r1, c1, r2, c2 = int(r1), int(c1), int(r2), int(c2)
            x1, y1 = merged[r1][c1]
            x2, y2 = merged[r2][c2]
            val1 = values[x1][y1]
            val2 = values[x2][y2]
            for i in range(MAX):
                for j in range(MAX):
                    if merged[i][j] == (x2, y2):
                        merged[i][j] = (x1, y1)
            if val1: values[x1][y1] = val1
            elif val2: values[x1][y1] = val2

        if info[0] == 'UNMERGE':
            _, r, c = info
            r, c = int(r), int(c)
            x, y = merged[r][c]
            val = values[x][y]
            for i in range(MAX):
                for j in range(MAX):
                    if merged[i][j] == (x, y):
                        merged[i][j] = (i, j)
                        values[i][j] = None
            values[r][c] = val

        if info[0] == 'PRINT':
            _, r, c = info
            r, c = int(r), int(c)
            x, y = merged[r][c]
            res.append(values[x][y] if values[x][y] else 'EMPTY')

        # printBoard()

    return res
