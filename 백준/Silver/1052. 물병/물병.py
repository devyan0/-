N, K = map(int, input().split())

cnt = 0
while K < f'{N:b}'.count('1'):
    cnt += N & -N
    N += N & -N

print(cnt)