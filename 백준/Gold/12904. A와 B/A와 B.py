import sys
sys.setrecursionlimit(10**6)
a = sys.stdin.readline().rstrip()
b = list(sys.stdin.readline().rstrip())

while len(b) > len(a):
    last = b[-1]
    b = b[:-1]
    if last == 'B':
        b.reverse()

if ''.join(b) == a:
    print(1)
else:
    print(0)