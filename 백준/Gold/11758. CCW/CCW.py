p1_x, p1_y = map(int, input().split())
p2_x, p2_y = map(int, input().split())
p3_x, p3_y = map(int, input().split())

res = p1_x * p2_y + p2_x * p3_y + p3_x * p1_y - (p2_x * p1_y + p3_x * p2_y + p1_x * p3_y)

if res > 0:
    print(1)
elif res < 0:
    print(-1)
else:
    print(0)

