import sys
n = int(sys.stdin.readline())
numbers = [0]
for i in range(n):
    numbers.append(int(sys.stdin.readline()))

answer = set()


def dfs(first, second, now):
    first.add(now)
    second.add(numbers[now])
    if numbers[now] in first:
        if first == second:
            answer.update(first)
            return True
        return False
    return dfs(first, second, numbers[now])


for i in range(1, n + 1):
    if i not in answer:
        dfs(set(), set(), i)

print(len(answer))
for num in sorted(list(answer)):
    print(num)

