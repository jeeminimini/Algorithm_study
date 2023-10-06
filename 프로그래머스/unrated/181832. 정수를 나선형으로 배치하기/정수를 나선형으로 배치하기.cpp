#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer(n, vector<int>(n, 0));
    
    int x = 0;
    int y = n;
    int now = 0;
    while (now < n * n) {
        for(int j = x; j < x + y; j++) {
            answer[x][j] = ++now;
            if (now == n * n) {
                return answer;
            }
        }
        x++;
        y--;
        for(int i = x; i < x + y; i++) {
            answer[i][x + y - 1] = ++now;
            if (now == n * n) {
                return answer;
            }
        }
        printf("%d %d", n-1-x, n-1-x-y);
        for(int j = n - 1 - x; j > n - 1 - x - y; j--) {
            answer[n - x][j] = ++now;
            if (now == n * n) {
                return answer;
            }
        }
        y--;
        for(int i = n - 1 - x; i > n - 1 - x - y; i--) {
            answer[i][x - 1] = ++now;
            if (now == n * n) {
                return answer;
            }
        }
        
    }

    
    return answer;
}