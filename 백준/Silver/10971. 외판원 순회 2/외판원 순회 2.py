import sys
from collections import deque
n=int(sys.stdin.readline())

x=[]
for i in range(n):
    x.append(list(map(int,sys.stdin.readline().split())))

num=0

dx=[0,0,-1,1]
dy=[-1,1,0,0]
mini=sys.maxsize

def dfs(start,follow,visited,num):
    global mini
    
    if len(visited)==n:
        if x[follow][start]!=0:
            mini=min(mini,num+x[follow][start])
        return
    for i in range(n):
        if i!=follow and x[follow][i]!=0 and i not in visited:
            visited.append(i)
            #print(visited)
            dfs(start,i,visited,num+x[follow][i])
            visited.pop()

for i in range(n):
    dfs(i,i,[i],0)

print(mini)
