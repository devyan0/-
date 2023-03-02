remain = int(input())
cnt = 0

while 0 <= remain:
    if remain % 5 == 0:
        cnt += remain//5
        remain = 0
        break

    remain -= 2
    cnt += 1

print(cnt if remain == 0 else -1)