n = int(input())
original = [list(map(int, input().split())) for _ in range(n)]
result = [[None for _ in range(n//2)] for _ in range(n//2)]

while n != 1:
    for i in range(0, n, 2):
        for j in range(0, n, 2):
            nums = [original[x][y] for x in [i, i+1] for y in [j, j+1]]
            result[i//2][j//2] = sorted(nums)[-2]

    n //= 2
    original, result = result, [[None for _ in range(n//2)] for _ in range(n//2)]

print(original[0][0])