class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var students = IntArray(n+1) { 1 }

        lost.forEach{
            students[it]--
        }

        reserve.forEach{
            students[it]++
        }

        for(i in 1..n){
            // 체육복이 도난 당했다면
            if(students[i]==0){

                // 왼쪽 친구가 있으면 빌림
                if(students[i-1] == 2){
                    students[i-1]--
                    students[i]++
                }

                // 오른쪽 친구가 있으면 빌림
                else if(i<n){
                    if(students[i+1] == 2){
                        students[i+1]--
                        students[i]++
                    }
                }
            }
        }

        return students.count{it > 0} - 1
    }
}
