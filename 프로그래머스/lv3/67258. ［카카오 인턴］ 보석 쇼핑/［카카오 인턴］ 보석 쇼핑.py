def checkOverOne(dic):
    for value in dic.values():
        if value == 0:
            return False
    return True

def solution(gems):
    category = set(gems)
    category_num = len(category)
    category_info = dict()
    category_exist = dict()
    for c in category:
        category_info[c] = 0
    
    gems_length = len(gems)
    start = 0
    end = 0
    mini = 100001
    result = [0, 0]
    exist = 0
    
    while start < gems_length:
        # print(f"start {start} end {end} category_info {category_info} result {result}")
        if exist != category_num:
            category_info[gems[start]] += 1
            if category_info[gems[start]] == 1:
                exist += 1
            start += 1
        else:
            if mini > start - end:
                result = [end + 1, start]
                mini = start - end
            category_info[gems[end]] -= 1
            if category_info[gems[end]] == 0:
                exist -= 1
            end += 1
            
    while end < gems_length:
        if exist == category_num:
            if mini > start - end:
                result = [end + 1, start]
            category_info[gems[end]] -= 1
            if category_info[gems[end]] == 0:
                exist -= 1
            end += 1
        else:
            break
        
    return result