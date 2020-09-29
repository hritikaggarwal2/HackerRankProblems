import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        // implement this
        return result;
    }

    public void visitNode(TreeNode node) {
        // implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        // implement this
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private final int M = 1000000000 + 7;
    private long result = 1;

    public int getResult() {
        // implement this
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        // implement this
        if (node.getColor().equals(Color.RED) && node.getValue() != 0) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        // implement this
        if (leaf.getColor().equals(Color.RED) && leaf.getValue() != 0) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        // implement this
        return Math.abs(nonLeafEvenSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        // implement this
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        // implement this
        if (leaf.getColor().equals(Color.GREEN)) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        // read the tree from STDIN and return its root as a return value of this
        // function
        Scanner sc = new Scanner(System.in);
        int totalNodes = sc.nextInt();

        int nodeVals[] = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            nodeVals[i] = sc.nextInt();
        }

        Color nodeColors[] = new Color[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            if (sc.nextInt() == 0) {
                nodeColors[i] = Color.RED;
            } else {
                nodeColors[i] = Color.GREEN;
            }
        }

        // if no nodes
        if (totalNodes == 0) {
            return null;
        } else if (totalNodes == 1) { // if node is leaf
            Tree ret = new TreeLeaf(nodeVals[0], nodeColors[0], 0);
            return ret;
        }

        Map<Integer, Set<Integer>> edges = new HashMap<>();
        Tree root = null;

        for (int i = 0; i < totalNodes - 1; i++) {
            int left = sc.nextInt() - 1;
            int right = sc.nextInt() - 1;

            // connection from left to right
            if (!edges.containsKey(left)) {
                edges.put(left, new HashSet<Integer>());
            }

            edges.get(left).add(right);

            // connection from right to left
            if (!edges.containsKey(right)) {
                edges.put(right, new HashSet<Integer>());
            }

            edges.get(right).add(left);
        }

        root = new TreeNode(nodeVals[0], nodeColors[0], 0);

        Queue<Tree> toVisit = new LinkedList<>();
        Queue<Integer> toVisitVal = new LinkedList<>();
        toVisit.add(root);
        toVisitVal.add(0);

        while (!toVisit.isEmpty()) {
            Tree currNode = toVisit.remove();
            int currIndex = toVisitVal.remove();
            Integer currDepth = currNode.getDepth();
            Iterator<Integer> iterator = edges.get(currIndex).iterator();

            while (iterator.hasNext()) {
                Integer childNodeValue = iterator.next();

                edges.get(childNodeValue).remove(currIndex);
                if (edges.get(childNodeValue).isEmpty()) {
                    Tree leaf = new TreeLeaf(nodeVals[childNodeValue], nodeColors[childNodeValue], currDepth + 1);

                    ((TreeNode) currNode).addChild(leaf);
                } else {
                    Tree child = new TreeNode(nodeVals[childNodeValue], nodeColors[childNodeValue], currDepth + 1);

                    toVisit.add(child);
                    toVisitVal.add(childNodeValue);
                    ((TreeNode) currNode).addChild(child);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}