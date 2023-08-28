def solution(A, B):
    B = sorted(B, reverse = True)
    A_sorted = sorted(A, reverse = True)
    score = 0
    
    idx = 0
    for a in A_sorted:
        if idx == len(B):
            break
        if a < B[idx]:
            idx += 1
            score += 1
        
    return score