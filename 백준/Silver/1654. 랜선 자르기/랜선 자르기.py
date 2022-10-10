import sys
a,b=map(int,sys.stdin.readline().split())
x=[]
for i in range(a):
    x.append(int(sys.stdin.readline()))

mini=1
maxi=max(x)

def remain(now):
    total=0
    for i in range(a):
        total+=x[i]//now
    return total


while mini<=maxi:
    midi=(mini+maxi)//2
    total=remain(midi)

    if total>=b:
        mini=midi+1
    else:
        maxi=midi-1
    
    
print(maxi)