x=input()

index=0
stack=[]
num=0

def push(n):
    global index
    global stack
    stack.append(1)
    index+=1
    

def pop():
    global index
    global stack
    global num
    num+=stack[index-1]
    del stack[index-1]
    index-=1

def add():
    global stack
    for i in range(len(stack)):
        stack[i]+=1

for i in range(len(x)):
    if x[i]=='(':
        if x[i+1]!=')': # 레이저가 아니면
            push(x[i])
        elif x[i+1]==')': #레이저이면
            add() # stack에 하나씩 더해주기
            #i+=1 이런거 왜 안됨..?
            
    elif x[i]==')':
        if x[i-1]!='(':
            pop()
print(num)