import sys

n = int(sys.stdin.readline())
town = []
total = 0
for i in range(n):
    x, a = map(int, sys.stdin.readline().split())
    total += a
    town.append([x, a])

town.sort(key= lambda x: x[0])

people = 0
mini = 1_000_000_000 * 100_000
result = -1
for i in range(n):
    if abs(people - (total - people - town[i][1])) < mini:
        mini = abs(people - (total - people - town[i][1]))
        result = town[i][0]

    people += town[i][1]

print(result)