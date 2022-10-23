import sys
n=int(sys.stdin.readline())

x=[]
for i in range(n):
    x.append(list(map(int,sys.stdin.readline().split())))

x.sort(key=lambda x:(x[1], x[0]))

#print(x)

k=x[0][1]
max_num=1

for i in range(1,n):
    if k <= x[i][0]:
        k=x[i][1]
        max_num+=1
        #print(i,k,x[i][0],max_num)
   
print(max_num)