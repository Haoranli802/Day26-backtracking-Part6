class Solution { 
    // 构造图，key是始发地，value是目的地，目的地用PriorityQueue存放，就可以自动按升序排序了 
    Map<String, PriorityQueue<String>> map = new HashMap<>(); 
    // 用链表来记录路线
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 遍历所有的机票，把票的起止信息都存到map里面
        for (List<String> ticket : tickets) {
            // 把票的始发地和目的地拆开存。src source 始发地 dest destination 目的地。 也可用start 和 end
            String src = ticket.get(0), dest = ticket.get(1); 
            // 这里要注意，首次存入需要新建优先队列，然后执行入队操作 add/offer 都可
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>()); // 这个写法要记一下
            }
            map.get(src).add(dest); // 往优先队列里添加元素，自动升序排序
        }
        dfs("JFK"); // 从起点开始深度优先搜索
        Collections.reverse(res); // 反转链表，最先找到的是最深的不能再走的目的地，所以要反转过来
        return res;
    }

    public void dfs(String src) {
        // 当传入的参数是始发地而且还有边的时候，取边出队删除并且继续递归深搜这条边的点，一直到不能再走再返回
        while (map.containsKey(src) && map.get(src).size() > 0) {
            dfs(map.get(src).poll());
        }
        // 没有子递归可以调用时，递归函数开始返回，把搜过的点一次加到结果集的路线里
        res.add(src);
    }
}
// O(MlogM), O(M)
