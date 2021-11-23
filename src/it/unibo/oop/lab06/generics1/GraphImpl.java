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

	private List<N> path = new LinkedList<>();
	// private Set<N> temp = new HashSet<>(); Utile in caso di Graph non chiuso
	private boolean found;
	private N current;

	public GraphImpl() {
	}

	// Constructor for multiple nodes
	@SafeVarargs
	public GraphImpl(N... node) {
		for (N n : node) {
			nodeList.putIfAbsent(n, new HashSet<>());
		}
	}

	public void addNode(N node) {
		if (node != null) {
			nodeList.putIfAbsent(node, new HashSet<>());
		}
	}

	public void addEdge(N source, N target) {
		if (source == null || target == null) {
		} else {
			nodeList.get(source).add(target);
		}
	}

	public Set<N> nodeSet() {
		return nodeList.keySet();
	}

	public Set<N> linkedNodes(N node) {
		return nodeList.get(node);
	}

	public List<N> getPath(N source, N target) {	// Graph ciclico!!!
		path.clear();
		found = false;
		path.add(source);
		this.current = linkedNodes(source).iterator().next(); 
		while (!found) {
			isFound(current, target);
		}
		return pathFixer(path);
	}

	private void isFound(N current, N target) {
		if (current == target) {
			this.found = true;
		}
		if (!path.contains(current)) {
			path.add(current);
			this.current = linkedNodes(current).iterator().next();
		} else {
			for (N node : linkedNodes(current)) {
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
	
	private List<N> pathFixer(List<N> initialPath) {
		List<N> fixedPath = new LinkedList<>();
		Iterator<N> iterator = initialPath.iterator();
		N temp = null;
		if (iterator.hasNext()) {
			temp=iterator.next();
			fixedPath.add(temp);
		}
		while (iterator.hasNext()) {
			N next=iterator.next();
			if (next == temp) {
			} else {
				fixedPath.add(next);
			}
			temp=next;
		}
		return fixedPath;
	}

}
