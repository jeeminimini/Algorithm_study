#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(int a, int b, int c, int d) {
    vector<int> numbers(7, 0);
    int answer = 0;
    numbers[a]++;
    numbers[b]++;
    numbers[c]++;
    numbers[d]++;
    
    int n_4 = count(numbers.begin(), numbers.end(), 4);
    int n_3 = count(numbers.begin(), numbers.end(), 3);
    int n_2 = count(numbers.begin(), numbers.end(), 2);
    int n_1 = count(numbers.begin(), numbers.end(), 1);
    
    int first, second;
    
    if (n_4 == 1){
        answer = (find(numbers.begin(), numbers.end(), 4) - numbers.begin()) * 1111;
    } else if (n_3 == 1) {
        answer = pow((find(numbers.begin(), numbers.end(), 3) - numbers.begin()) * 10 + find(numbers.begin(), numbers.end(), 1) - numbers.begin(), 2);
    } else if (n_2 == 2) {
        first = find(numbers.begin(), numbers.end(), 2) - numbers.begin();
        second = find(numbers.begin() + first + 1, numbers.end(), 2) - numbers.begin(); 
        answer = (first + second) * abs(first - second);
    } else if (n_2 == 1) {
        first = find(numbers.begin(), numbers.end(), 1) - numbers.begin();
        second = find(numbers.begin() + first + 1, numbers.end(), 1) - numbers.begin();
        answer = first * second;
    } else {
        answer = find(numbers.begin(), numbers.end(), 1) - numbers.begin();
    }
    return answer;
}