def solution(routes):
    maxi = max(map(max, routes))
    mini = min(map(min, routes))
    
    routes = sorted(routes)
    
    idx_s = 0
    idx_n = 1
    total = 0
    
    while True:
        print(f"idx_s {idx_s} idx_n {idx_n}")
        if idx_n == len(routes):
            break
        if routes[idx_s][1] < routes[idx_n][0]:
            total += 1
            idx_s = idx_n
        idx_n += 1
    
    return total + 1

# print(solution([[-2,-1], [1,2],[-3,0]])) #2
# print(solution([[0,0],])) #1
# print(solution([[0,1], [0,1], [1,2]])) #1
# print(solution([[0,1], [2,3], [4,5], [6,7]])) #4
# print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]])) #2
# print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]])) #2
# print(solution([[-20,15], [-20,-15], [-14,-5], [-18,-13], [-5,-3]])) #2