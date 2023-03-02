n = int(input())
cnt = 0
while True:
    if n < 0:       # base case 1: impossible
        cnt = -1
        break
    if n == 0:      # base case 2: complete
        break

    if n % 5 == 0:  # step 1: if n can be composed only with 5s
        cnt += n // 5
        n -= 5 * (n // 5)

    if n == 0:      # step 1 success
        break

    n -= 2          # step 2: use one coin of 2
    cnt += 1

print(cnt)