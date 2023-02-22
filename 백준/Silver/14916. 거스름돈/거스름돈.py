N = int(input())

if N <= 5:
    print([-1, -1, 1, -1, 2, 1][N])
    quit()

dp = [float('inf') for _ in range(N+1)]
dp[2] = dp[5] = 1

for i in range(1, N+1):
    if 2 <= i: dp[i] = min(dp[i], dp[i-2]+1)
    if 5 <= i: dp[i] = min(dp[i], dp[i-5]+1)

print(dp[N] if dp[N] < float('inf') else -1)