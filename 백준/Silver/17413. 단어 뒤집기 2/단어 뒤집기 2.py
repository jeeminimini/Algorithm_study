import sys
n=sys.stdin.readline().rstrip()
n+=' '
s=''
tmp=0
mini=len(n)
maxi=0
for i in range(len(n)):
    if n[i]==' ':
        maxi=i-1
        for j in range(maxi,mini-1,-1):
            s+=n[j]
        s+=n[i]
        mini=len(n)
    elif n[i]=='<':
        tmp=1
        maxi=i-1
        for j in range(maxi,mini-1,-1):
            s+=n[j]
        s+=n[i]
        mini=len(n)
    elif n[i]=='>':
        tmp=0
        s+=n[i]
    elif tmp==1:
        s+=n[i]
    else:
        mini=min(mini,i)
        
print(s)
    
