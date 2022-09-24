import sys
n=int(sys.stdin.readline())
init=[]
player=[]
for i in range(n):
    init.append(sys.stdin.readline().rstrip())
for i in range(n):
    player.append(sys.stdin.readline().rstrip())

x=[-1,0,1,-1,1,-1,0,1]
y=[-1,-1,-1,0,0,1,1,1]

answer=[]
danger=0
for i in range(n):
    ans=''
    for j in range(n):
        if player[i][j]=='x':
            if init[i][j]=='*':
                danger=1
            tmp=0
            for k in range(8):
                if i+x[k]<n and i+x[k]>=0 and j+y[k]<n and j+y[k]>=0 and init[i+x[k]][j+y[k]]=='*':
                    tmp+=1
            ans+=str(tmp)
        else:
            ans+='.'
    answer.append(ans)

if danger==1:
    for i in range(n):
        for j in range(n):
            if init[i][j]=='*':
                a=list(answer[i])
                a[j]='*'
                answer[i]=''.join(a)
        

for i in answer:
    print(i)