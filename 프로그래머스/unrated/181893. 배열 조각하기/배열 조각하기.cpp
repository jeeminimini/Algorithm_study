#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    int start = 0;
    int end = arr.size();
    
    for(int i = 0; i < query.size(); i++) {
        if (i % 2 == 0) {
            end = start + query[i] + 1;
        } else {
            start = start + query[i];
        }
        // printf("%d %d\n", start, end);
        // for(int j = 0; j < arr.size(); j++){
        //     printf("%d", arr[j]);
        // }
        // printf("\n");
        
    }
    
    arr = vector<int>(arr.begin() + start, arr.begin() + end);
    if (arr.empty()){
        return {-1};
    }
    return arr;
}