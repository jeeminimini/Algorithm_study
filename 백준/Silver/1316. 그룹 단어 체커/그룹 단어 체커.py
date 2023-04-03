n = int(input())
result = n
for i in range(n):
    numbers = [False for _ in range(26)]
    str = input()
    start = str[0]
    numbers[ord(start) - ord('a')] = True
    for s in str[1:]:
        if start != s and not numbers[ord(s) - ord('a')]:
            numbers[ord(s) - ord('a')] = True
        elif start != s and numbers[ord(s) - ord('a')]:
            result -= 1
            break
        start = s
print(result)
