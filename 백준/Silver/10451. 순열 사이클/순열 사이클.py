import sys
n=int(sys.stdin.readline())

    
def BFS(graph,c,m): 
    stack=[c]
    
    while stack:
        nn=stack.pop(0)
        for i in range(1,m+1):
            if graph[nn][i]==1 and visited[i]==0:
                stack.append(i)
                visited[i]=1

def num(graph,visited,m):
    num=0
    for i in range(1,len(visited)):
        
        if visited[i]==0:
            BFS(graph,i,m)
            num+=1
    return num
    

for i in range(n):
    m=int(sys.stdin.readline())
    cycle=list(map(int,sys.stdin.readline().split()))
    graph = [[0]*(m+1) for i in range(m+1)]
    visited=[0]*(m+1)
    for i in range(1,m+1):
        graph[i][cycle[i-1]]=1
    print(num(graph,visited,m))
             
