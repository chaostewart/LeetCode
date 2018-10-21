/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
// BFS
// won't need a HashSet visited here because there wont be any loops formed by subordinates
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) 
            map.put(e.id, e);
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee curr = queue.poll();
            ans += curr.importance;
            for (int i: curr.subordinates) 
                queue.add(map.get(i));
        }
        return ans;
    }
}