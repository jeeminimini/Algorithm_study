def solution(w,h):
    answer = 1
    
    gcd = 0
    for i in range(min(w, h), 0, -1):
        if w % i == 0 and h % i == 0:
            gcd = i
            break
            
    origin = w*h
    typ = w // gcd + h // gcd - 1
    count = w // (w // gcd)
    
    # print(origin, typ, count)
    answer = origin - typ * count 
    
    return answer