
def solution(alp, cop, problems):
    A = max(problems, key=lambda x: x[0])[0]
    C = max(problems, key=lambda x: x[1])[1]
    dp = [[float('inf') for _ in range(C+1)] for _ in range(A+1)]
    alp = min(alp, A)
    cop = min(cop, C)

    dp[alp][cop] = 0
    for a in range(alp, A+1):
        for c in range(cop, C+1):
            if a+1 <= A: dp[a+1][c] = min(dp[a+1][c], dp[a][c]+1)
            if c+1 <= C: dp[a][c+1] = min(dp[a][c+1], dp[a][c]+1)

            for areq, creq, arwd, crwd, cost in problems:
                if areq <= a and creq <= c:
                    na, nc = min(a+arwd, A), min(c+crwd, C)
                    dp[na][nc] = min(dp[na][nc], dp[a][c]+cost)

    return dp[A][C]
