def solution(sticker):
    length = len(sticker)
    dp_0 = [0 for _ in range(length - 1)]
    dp_1 = [0 for _ in range(length)]
    if length == 1:
        return sticker[0]
    elif length == 2:
        return max(sticker)
    dp_0[0] = sticker[0]
    for i in range(1, length - 1):
        dp_0[i] = max(dp_0[i - 1], dp_0[i - 2] + sticker[i])
        # print(dp_0)
    # print("--------")
    for i in range(1, length):
        dp_1[i] = max(dp_1[i - 1], dp_1[i - 2] + sticker[i])
        # print(dp_1)
    return max(dp_0[-1], dp_1[-1])