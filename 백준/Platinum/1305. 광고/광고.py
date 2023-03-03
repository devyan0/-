def get_pi(p):
    pi, j = [0] * len(p), 0

    for i in range(1, len(p)):
        while j > 0 and p[i] != p[j]:
            j = pi[j-1]

        if p[i] == p[j]:
            j += 1
            pi[i] = j
    return pi

N = int(input())
L = input()
pi = get_pi(L)
print(N-pi[-1])
