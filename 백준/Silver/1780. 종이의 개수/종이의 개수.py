import sys
a=int(sys.stdin.readline())

x=[0]*a
index=a
num_0=0
num_m1=0
num_p1=0

for i in range(a):
    x[i]=list(map(int,sys.stdin.readline().split()))


def confirm(h,w,index):
    tmp=x[h][w]
    for i in range(h,h+index):
        for j in range(w,w+index):
            if x[i][j]!=tmp:
                return False
    return True
            

def divide(h,w,index):
    global num_0
    global num_m1
    global num_p1
    if confirm(h,w,index):
        #print(index)
        if x[h][w]==0:
            num_0+=1
        elif x[h][w]==-1:
            num_m1+=1
        else:
            num_p1+=1
    else:
        size=index//3
        for i in range(h,h+index,size):
            for j in range(w,w+index,size):
                divide(i,j,size)
                
        
        
divide(0,0,index)
print(num_m1)
print(num_0)
print(num_p1)
    
