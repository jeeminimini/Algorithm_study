total = 0
ban_length = 0
result = []

def getCombi(possible_ban, now, visited):
    global total, ban_length, result
    if ban_length == now:
        if visited.count(1) == ban_length:
            new = visited[:]
            if new not in result:
                result.append(new)
        return
    for idx in possible_ban[now]:
        if visited[idx] == 0:
            visited[idx] = 1
            getCombi(possible_ban, now + 1, visited)
            visited[idx] = 0
    

def solution(user_id, banned_id):
    global total, ban_length
    ban_length = len(banned_id)
    user_length = len(user_id)
    possible_ban = [[] for _ in range(ban_length)]
    for i in range(ban_length):
        ban_id_length = len(banned_id[i])
        for j in range(user_length):
            if len(user_id[j]) != ban_id_length:
                continue
            possible = True
            for k in range(ban_id_length):
                if banned_id[i][k] == '*':
                    continue
                if banned_id[i][k] != user_id[j][k]:
                    possible = False
            if possible:
                possible_ban[i].append(j)
    
    getCombi(possible_ban, 0, [0 for _ in range(user_length)])
    
    return len(result)