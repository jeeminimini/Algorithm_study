import sys
while True:
    tics = list(sys.stdin.readline().rstrip())
    if ''.join(tics) == "end":
        break
    X_len = tics.count('X')
    O_len = tics.count('O')
    if not (0 <= X_len - O_len <= 1):
        print("invalid")
        continue

    new_tics = []
    for i in range(0, 9, 3):
        new_tics.append(tics[i: i + 3])

    X_win = 0
    O_win = 0
    for i in range(3):
        x = 0
        o = 0
        for j in range(3):
            if new_tics[i][j] == 'X':
                x += 1
            elif new_tics[i][j] == 'O':
                o += 1
        if x == 3:
            X_win += 1
        elif o == 3:
            O_win += 1

    for i in range(3):
        x = 0
        o = 0
        for j in range(3):
            if new_tics[j][i] == 'X':
                x += 1
            elif new_tics[j][i] == 'O':
                o += 1
        if x == 3:
            X_win += 1
        elif o == 3:
            O_win += 1

    if new_tics[0][0] == new_tics[1][1] == new_tics[2][2]:
        if new_tics[0][0] == 'X':
            X_win += 1
        elif new_tics[0][0] == 'O':
            O_win += 1
    if new_tics[0][2] == new_tics[1][1] == new_tics[2][0]:
        if new_tics[0][2] == 'X':
            X_win += 1
        elif new_tics[0][2] == 'O':
            O_win += 1

    # print(f"X_len {X_len} O_len {O_len} {X_win, O_win}")
    if X_win > 0 and O_win > 0:
        print("invalid")
        continue
    elif X_win == 0 and O_win > 0:
        if X_len != O_len:
            print("invalid")
            continue
    elif X_win > 0 and O_win == 0:
        if X_len == O_len:
            print("invalid")
            continue
    elif X_win == 0 and O_win == 0:
        if tics.count('.') > 0:
            print("invalid")
            continue

    print("valid")
