import sys
input = sys.stdin.readline
s = input().strip()
res = ''

l = r = 0
while r < len(s):
    if s[l] == '<':
        if s[r] == '>':
            res += s[l:r+1]
            l = r = r+1
        else:
            r += 1
    elif s[r] == '<':
        res += s[l:r][::-1]
        l = r
    elif s[r] == ' ':
        res += s[l:r][::-1] + ' '
        l = r = r + 1
    else:
        r += 1

# switch l .. r
res += s[l:r][::-1]
print(res)