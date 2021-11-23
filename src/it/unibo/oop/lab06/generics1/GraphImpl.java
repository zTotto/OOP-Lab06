package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> nodeList = new HashMap<>();

    private final List<N> path = new LinkedList<>();
    // private Set<N> temp = new HashSet<>(); Utile in caso di Graph non chiuso
    private boolean found;
    private N current;

    public GraphImpl() {
    }

    // Constructor for multiple nodes
    @SafeVarargs
    public GraphImpl(final N... node) {
        for (final N n : node) {
            nodeList.putIfAbsent(n, new HashSet<>());
        }
    }

    public void addNode(final N node) {
        if (node != null) {
            nodeList.putIfAbsent(node, new HashSet<>());
        }
    }

    public void addEdge(final N source, final N target) {
        if (source != null && target != null) {
            nodeList.get(source).add(target);
        }
    }

    public Set<N> nodeSet() {
        return nodeList.keySet();
    }

    public Set<N> linkedNodes(final N node) {
        return nodeList.get(node);
    }

    public List<N> getPath(final N source, final N target) { // Graph ciclico!!!
        path.clear();
        found = false;
        path.add(source);
        this.current = linkedNodes(source).iterator().next();
        while (!found) {
            isFound(current, target);
        }
        return pathFixer(path);
    }

    private void isFound(final N current, final N target) {
        if (current.equals(target)) {
            this.found = true;
        }
        if (!path.contains(current)) {
            path.add(current);
            this.current = linkedNodes(current).iterator().next();
        } else {
            for (final N node : linkedNodes(current)) {
                if (!path.contains(node)) {
                    path.add(current);
                    path.add(node);
                    this.current = node;
                    return;
                }
            }
            path.add(current);
            this.current = linkedNodes(current).iterator().next();
        }
    }

    private List<N> pathFixer(final List<N> initialPath) {
        final List<N> fixedPath = new LinkedList<>();
        final Iterator<N> iterator = initialPath.iterator();
        N temp = null;
        if (iterator.hasNext()) {
            temp = iterator.next();
            fixedPath.add(temp);
        }
        while (iterator.hasNext()) {
            final N next = iterator.next();
            if (!next.equals(temp)) {
                fixedPath.add(next);
            }
            temp = next;
        }
        return fixedPath;
    }

}
