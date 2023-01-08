import sys

n=int(sys.stdin.readline())

node={}
for i in range(n):
    a,b,c=map(str,sys.stdin.readline().split())
    node[a]=[b,c]

visited=[False for i in range(n+1)]
visited[0]=True
end=1
def preorder(node,a):
    global end
    visited[list(node.keys()).index(a)+1]=True
    print(a,end='')
    if all(visited)==True:
        return 0
    if node[a][0]!='.' and all(visited)==False:
        preorder(node,node[a][0])
    if node[a][1]!='.' and all(visited)==False:
        preorder(node,node[a][1])
preorder(node,list(node.keys())[0])
print()

visited=[False for i in range(n+1)]
visited[0]=True
end=1
def inorder(node,a):
    global end
    if node[a][0]!='.' and all(visited)==False:
        inorder(node,node[a][0])
    visited[list(node.keys()).index(a)+1]=True
    print(a,end='')
    if all(visited)==True:
        return 0
    if node[a][1]!='.' and all(visited)==False:
        inorder(node,node[a][1])
inorder(node,list(node.keys())[0])
print()

visited=[False for i in range(n+1)]
visited[0]=True
end=1
def postorder(node,a):
    global end
    if node[a][0]!='.' and all(visited)==False:
        postorder(node,node[a][0])
    if node[a][1]!='.' and all(visited)==False:
        postorder(node,node[a][1])
    visited[list(node.keys()).index(a)+1]=True
    print(a,end='')
    if all(visited)==True:
        return 0
    
postorder(node,list(node.keys())[0])
print()

    
