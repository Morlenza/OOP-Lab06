package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {
	
	private Map<N,List<N>> map;
	
	public GraphImpl() {
		this.map = new HashMap<>();
	}

	@Override
	public void addNode(N node) {
		if(node != null && !isNodeThere(node)) {
			this.map.put(node, new LinkedList<>());
		}
	}

	private boolean isNodeThere(N node) {
		return this.map.containsKey(node);
	}

	@Override
	public void addEdge(N source, N target) {
		if(source != null && target != null) {
			this.map.get(source).add(target);
			this.map.get(target).add(source);
		}
	}

	@Override
	public Set<N> nodeSet() {
		return new HashSet<N>(this.map.keySet());
	}

	@Override
	public Set<N> linkedNodes(N node) {
		return new HashSet<N>(this.map.get(node));
	}

	@Override
	public List<N> getPath(N source, N target) {
		BreadthFirstSearch<N> mybfs = new BreadthFirstSearch<>(map);
		Map<N,N> parentMap = mybfs.bfs(source);
		return mybfs.getPath(parentMap,source,target);
		
	}
}
