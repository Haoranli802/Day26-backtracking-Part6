# Day26-backtracking-Part6

● 332.重新安排行程 

首先，把ticket信息存到map里面，map里面的键为出发地，值为包含所有到达地的PriorityQueue因为PriorityQueue是自动升序，那么最小的出发地就在最前面。然后dfs JFK为初始点，当初始点在map内而且对应的到达点的que值不为空，删除最前面的到达点并且dfs此到达点，直到找到一个终点，然后从终点加入所有遍历的点。所以最后要reverse result。

● 51. N皇后 

传入board，每个可能的皇后位置都判断是否能放皇后，如果能的话就判断下一层直到找到所有的皇后或者没有满足的情况。

● 37. 解数独 
