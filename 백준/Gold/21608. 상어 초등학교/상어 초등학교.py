import sys
n=int(sys.stdin.readline())
student=[]
for i in range(n**2):
    student.append(list(map(int,sys.stdin.readline().split())))

seat=[[0 for j in range(n)]for i in range(n)]
seat[1][1]=student[0][0]
x=[1,-1,0,0]
y=[0,0,1,-1]

for w in range(1,n**2):
    maxi=0
    idx=[]
    for i in range(n):
        for j in range(n):
            if seat[i][j]==0:
                tmp=0
                for k in range(4):
                    if i+x[k]<n and i+x[k]>=0 and j+y[k]<n and j+y[k]>=0 and seat[i+x[k]][j+y[k]] in student[w][1:]:
                        #print(seat[i+x[k]][j+y[k]])
                        tmp+=1
                if tmp>maxi:
                    maxi=tmp
                    idx=[[i,j]]
                elif tmp==maxi:
                    idx.append([i,j])
    idx=sorted(idx)
    maxi=0
    idx2=[]
    for i in range(len(idx)):
        tmp=0
        for k in range(4):
            if idx[i][0]+x[k]<n and idx[i][0]+x[k]>=0 and idx[i][1]+y[k]<n and idx[i][1]+y[k]>=0 and seat[idx[i][0]+x[k]][idx[i][1]+y[k]]==0:
                tmp+=1
        if tmp>maxi:
            maxi=tmp
            idx2=[idx[i]]
        elif tmp==maxi:
            idx2.append(idx[i])
            
    #print('idx2',idx2)
    seat[idx2[0][0]][idx2[0][1]]=student[w][0]
    #print('seat',seat)
num=0
for w in range(0,n**2):
    for i in range(n):
        for j in range(n):
            if seat[i][j]==student[w][0]:
                tmp=0
                for k in range(4):
                    if i+x[k]<n and i+x[k]>=0 and j+y[k]<n and j+y[k]>=0 and seat[i+x[k]][j+y[k]] in student[w][1:]:
                        tmp+=1
                
                if tmp==0:
                    num+=0
                elif tmp==1:
                    num+=1
                elif tmp==2:
                    num+=10
                elif tmp==3:
                    num+=100
                else:
                    num+=1000

            
print(num)
                        
                    
                        
