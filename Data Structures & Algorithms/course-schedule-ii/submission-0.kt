class Solution {
    val fList: MutableList<Int> = mutableListOf()
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj: MutableList<MutableList<Int>> = mutableListOf()
        for(i in 0 until numCourses) {
            adj.add(mutableListOf<Int>())
        }

        for(i in 0 until prerequisites.size) {
            adj[prerequisites[i][0]].add(prerequisites[i][1])
        }

        val visited: Array<Level> = Array(numCourses){Level.UNIVISITED}
        for(r in 0 until numCourses) {
            if(visited[r] == Level.UNIVISITED) {
                val state = adj[r]
                if(!dfs(state, visited, r, adj)) {
                    return intArrayOf()
                }
            }
        }
        return fList.toIntArray()
    }

    fun dfs(state: MutableList<Int>, visited:Array<Level>, i: Int, adj: MutableList<MutableList<Int>>):Boolean {
        if(visited[i] == Level.VISITING) return false
        if(visited[i] == Level.DONE) return true
        visited[i] = Level.VISITING
        for(j in 0 until state.size) {
            val t = dfs(adj[state[j]], visited, state[j], adj)
            if(!t) {
                return false
            }
        }
        visited[i] = Level.DONE
        fList.add(i)
        return true
    }

    enum class Level {
        VISITING, DONE, UNIVISITED
    }
}
