def solution(numbers):
    numbers = list(map(str, numbers))
    # print(sorted(numbers, reverse=True))
    hi = list(map(lambda x: x*3, numbers))
    # print(sorted(hi, reverse = True))
    numbers.sort(key=lambda x: x * 3, reverse=True)
    # print(numbers)
    return str(int(''.join(numbers)))