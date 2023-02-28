sl = [input() for _ in range(int(input()))]
cond = lambda x: sum([int(c) for c in filter(lambda k: k.isdigit(), x)])

print(*sorted(sl, key=lambda x: (len(x), cond(x), x)), sep='\n')