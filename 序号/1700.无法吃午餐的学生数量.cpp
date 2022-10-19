class Solution {
 public:
  /** 三明治有0和1两种，学生喜欢其中一种。栈顶学生喜欢栈顶三明治就拿走，栈顶学生不喜欢栈顶就重新排队，返回吃不到的学生数量 */
  int countStudents(vector<int>& students, vector<int>& sandwiches) {
    // 无法吃到的情况为剩下学生全都喜欢0，栈顶为1 ；或反过来
    int odd = 0, even = 0;
    for (int& i : students) {
      if (i % 2 == 0)
        even++;
      else
        odd++;
    }
    while (odd > 0 && even > 0) {
      int topStudent = students[0];
      if (topStudent == sandwiches[0]) {
        students.erase(students.begin());
        sandwiches.erase(sandwiches.begin());
        if (topStudent % 2 == 0)
          even--;
        else
          odd--;
      } else {
        students.erase(students.begin());
        students.emplace_back(topStudent);
      }
    }
    if (odd == 0) {
      while (!sandwiches.empty() && sandwiches[0] % 2 == 0) {
        sandwiches.erase(sandwiches.begin());
      }
    } else {
      while (!sandwiches.empty() && sandwiches[0] % 2 == 1) {
        sandwiches.erase(sandwiches.begin());
      }
    }
    return sandwiches.size();
  }
};