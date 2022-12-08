import sys
n=int(sys.stdin.readline())
stock=list(map(int,sys.stdin.readline().split()))

pay=n
num=0
#준현이
for i in range(14):
    num+=pay//stock[i]
    pay=pay%stock[i]
total1=num*stock[-1]+pay

#성민이
pay=n
num=0
up=0
down=0
for i in range(13):
    if down>=3:
        num+=pay//stock[i]
        pay=pay%stock[i]
    if up>=3:
        pay+=num*stock[i]
        num=0
    if stock[i]<stock[i+1]:
        up+=1
        down=0
    elif stock[i]>stock[i+1]:
        down+=1
        up=0
    else:
        down=0
        up=0
 
total2=num*stock[-1]+pay

if total1==total2:
    print('SAMESAME')
elif total1>total2:
    print('BNP')
else:
    print('TIMING')
