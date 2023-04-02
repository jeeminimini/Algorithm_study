import sys

n = int(input())
abilities = []
combinations = []
for i in range(n):
    abilities.append(list(map(int, input().split(" "))))

total_ability = sum(sum(abilities, []))


def get_combination(start, combi):
    if len(combi) == n // 2:
        combinations.append(combi)
        return
    for i in range(start, n):
        get_combination(i + 1, combi + [i])


get_combination(0, [])
result = sys.maxsize
for combi in combinations:
    sum_1 = 0
    sum_2 = 0
    other_combi = [i for i in range(n) if i not in combi]
    for c in combi:
        for t in combi:
            sum_1 += abilities[c][t]
    for c in other_combi:
        for t in other_combi:
            sum_2 += abilities[c][t]

    result = min(result, abs(sum_1 - sum_2))

print(result)
