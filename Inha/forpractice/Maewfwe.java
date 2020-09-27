#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
   int n, m; cin >> n >> m;
   vector<string> arr(n);
   vector<int> hash(n);
   for (int i = 0; i < n; i++) {
      cin >> arr[i];
      hash[i] = 0;
      int size = arr[i].size();
      hash[i] = (int)(arr[i][0]);
   }

   vector<string> line(m);
   vector<int> linehash(m);
   bool* check = new bool[m];
   for (int i = 0; i < m; i++) {
      cin >> line[i];
      check[i] = false;
      linehash[i] = 0;
      int size = line[i].size();
      linehash[i] = (int)(line[i][0]);
   }

   int lineHashIndex = 0;
   int i = 0;
   while (true) {
      if (lineHashIndex == m || i == n) {
         break;
      }
      if (hash[i] != linehash[lineHashIndex]) {
         i++;
         continue;
      }
      if (arr[i].size() != line[lineHashIndex].size()) {
         i++;
         continue;
      }
      check[lineHashIndex] = true;
      i = 0;
      lineHashIndex++;
   }

   int ans = 1;
   for (int i = 0; i < m; i++) {
      if (check[i] == true) continue;
      ans = 0;
      break;
   }
   
   cout << ans << "\n";

   return 0;
}