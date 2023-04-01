n = input()
examinees = map(int, input().split(" "))
main_director, sub_director = map(int, input().split(" "))
result = 0
for e in examinees:
    result += 1
    if e > main_director:
        result += (e - main_director + sub_director - 1) // sub_director
print(result)