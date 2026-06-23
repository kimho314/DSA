package neetcode;

import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        CloneGraph sol = new CloneGraph();
        Node root = sol.buildGraph(new int[][]{{2}, {1, 3}, {2}});
        Node res = sol.cloneGraph2(root);
        sol.printGraph(res);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node buildGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0)
            return null;

        // 1. 모든 노드 생성
        Node[] nodes = new Node[adjList.length + 1];
        for (int i = 1; i <= adjList.length; i++) {
            nodes[i] = new Node(i);
        }

        // 2. 이웃 연결
        for (int i = 0; i < adjList.length; i++) {
            for (int neighbor : adjList[i]) {
                nodes[i + 1].neighbors.add(nodes[neighbor]);
            }
        }

        return nodes[1];
    }

    private void printGraph(Node start) {
        if (start == null)
            return;

        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start.val);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // 현재 노드와 이웃 출력
            System.out.print("Node(" + curr.val + ") → [");
            List<String> neighborVals = new ArrayList<>();
            for (Node neighbor : curr.neighbors) {
                neighborVals.add("Node(" + neighbor.val + ")");
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            System.out.println(String.join(", ", neighborVals) + "]");
        }
    }

    private Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!oldToNew.containsKey(nei)) {
                    oldToNew.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }

        return oldToNew.get(node);
    }

    private Node cloneGraph2(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node newNode = new Node(node.val);
        oldToNew.put(node, newNode);
        for (Node nei : node.neighbors) {
            newNode.neighbors.add(dfs(nei, oldToNew));
        }
        return newNode;
    }
}
