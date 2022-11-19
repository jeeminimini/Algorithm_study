import sys
x,y=map(int,sys.stdin.readline().split())

if x>=3 and y>=7:
    print(y-2)
elif x<3:
    if x==2:
        if y<3:
            print('1')
        elif y<5:
            print('2')
        elif y<7:
            print('3')
        else :
            print('4')
            
    if x==1:
        print('1')

elif y<7: #x>=3인거다
    if y==1:
        print('1')
    elif y==2:
        print('2')
    elif y==3:
        print('3')
    else:
        print('4')
    
