def solution(wallpaper):
    x, y = [], []
    for i, row in enumerate(wallpaper):
        for j, val in enumerate(row):
            if val == '#':
                x.append(i)
                y.append(j)
    
    a, b = min(x), min(y)
    c, d = max(x), max(y)
    return [a, b, c+1, d+1]
    
    
    