n, k = map(int, input().split())
nums = list(map(int, input().split()))
nums_info = [0 for _ in range(max(nums) + 1)]
start = 0
end = 0
maxi = 0

while start < n and end < n:
    # print(f"nums_info {nums_info} start {start} end {end}")
    if nums_info[nums[start]] < k:
        nums_info[nums[start]] += 1
        start += 1
    elif nums_info[nums[start]] == k:
        nums_info[nums[end]] -= 1
        maxi = max(maxi, start - end)
        end += 1


maxi = max(maxi, n - end)
print(maxi)

'''
9 2
3 2 5 5 5 6 4 4 7
'''