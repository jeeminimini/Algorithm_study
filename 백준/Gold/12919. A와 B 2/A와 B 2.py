import sys
sys.setrecursionlimit(10**6)
a = list(sys.stdin.readline().rstrip())
b = list(sys.stdin.readline().rstrip())
result = 0


def set_recursion(b):
    global result, a
    if len(a) == len(b):
        if a == b:
            result = 1
        return

    if b[-1] == 'A':
        set_recursion(b[:-1])

    if b[0] == 'B':
        set_recursion(b[:0:-1])


set_recursion(b)
print(result)
