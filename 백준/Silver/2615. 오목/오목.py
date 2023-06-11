import sys
s=[]
for i in range(19):
    s.append(list(map(int,sys.stdin.readline().split())))

minib=[19,19]
miniw=[19,19]
black=0
white=0
for i in range(19-4):
    for j in range(19):
        if s[i][j]==s[i+1][j]==s[i+2][j]==s[i+3][j]==s[i+4][j] and s[i][j]!=0:
            if (i>0 and s[i-1][j]==s[i][j]) or (i+4<19-1 and s[i+5][j]==s[i][j]):
                continue
            else:
                if s[i][j]==1:
                    minib=min(minib,[i,j])
                    black+=1
                else:
                    miniw=min(miniw,[i,j])
                    white+=1
            
for i in range(19):
    for j in range(19-4):
        if s[i][j]==s[i][j+1]==s[i][j+2]==s[i][j+3]==s[i][j+4] and s[i][j]!=0:
            if (j>0 and s[i][j-1]==s[i][j]) or (j+4<19-1 and s[i][j+5]==s[i][j]):
                continue
            else:
                if s[i][j]==1:
                    minib=min(minib,[i,j])
                    black+=1
                else:
                    miniw=min(miniw,[i,j])
                    white+=1

for i in range(19-4):
    for j in range(19-4):
        if s[i][j]==s[i+1][j+1]==s[i+2][j+2]==s[i+3][j+3]==s[i+4][j+4] and s[i][j]!=0:
            if (j>0 and i>0 and s[i-1][j-1]==s[i][j]) or (j+4<19-1 and i+4<19-1 and s[i+5][j+5]==s[i][j]):
                continue
            else:
                if s[i][j]==1:
                    minib=min(minib,[i,j])
                    black+=1
                else:
                    miniw=min(miniw,[i,j])
                    white+=1
                    
for i in range(4,19):
    for j in range(19-4):
        if s[i][j]==s[i-1][j+1]==s[i-2][j+2]==s[i-3][j+3]==s[i-4][j+4] and s[i][j]!=0:
            if (i<19-1 and j>0 and s[i+1][j-1]==s[i][j]) or (j+4<19-1 and i-4>0 and s[i-5][j+5]==s[i][j]):
                continue
            else:
                if s[i][j]==1:
                    minib=min(minib,[i,j])
                    black+=1
                else:
                    miniw=min(miniw,[i,j])
                    white+=1      

if black>white:
    print(1)
    print(minib[0]+1,minib[1]+1)
elif white>black:
    print(2)
    print(miniw[0]+1,miniw[1]+1)
else:
    print(0)


#print('black,white',black,white)
