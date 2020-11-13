package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch<U> {
	
	private static boolean NOT_VISITED = false;
	private static boolean VISITED = true;
	
	private Map<U,List<U>> edgeMap;
	private Map<U,Boolean> visitedMap;
	private Map<U,U> parentMap;
	private LinkedList<U> queue;
	private LinkedList<U> path;
	
	
	
	public BreadthFirstSearch(Map<U,List<U>> m){
		edgeMap = m;
		//prepare a "Boolean" map to set if a node is WHITE(not yet discovered), GRAY(is discovered) and BLACK(is dequeued)
		visitedMap = new HashMap<>();
		for(U node : edgeMap.keySet()) {
			visitedMap.put(node, NOT_VISITED);
		}
		//prepare an HashMap to set the parent of each node (at the beginning all nodes are without parent (NULL))
		parentMap = new HashMap<>();
		for(U node : edgeMap.keySet()) {
			parentMap.put(node, null);
		}
		queue = new LinkedList<>();
		path = new LinkedList<>();
	}
	
	/*
	 * 
	 * Makes a bfs from source
	 * 	returns a parentMap(node,parent)
	 * 
	 */
	public Map<U,U> bfs(U source){
		visitedMap.put(source, VISITED);
		queue.add(source);
		while(queue.size() != 0) {
			U currentNode = queue.remove();
			for(U adj : edgeMap.get(currentNode)) {
				if(visitedMap.get(adj) == NOT_VISITED) {
					visitedMap.put(adj,VISITED);
					parentMap.put(adj, currentNode);
					queue.add(adj);
				}
			}
		}
		return parentMap;
	}
	
	/*
	 * get the nearest path from source to target
	 * and put it in a LinkedList<U>
	 * 
	 * 
	 */
	public List<U> getPath(Map<U,U> parentMap, U source, U target) {
		if(source.equals(target)) {
			path.add(source);
		}
		else if(parentMap.get(target).equals(null)) {
			System.out.println("There is not path from source to target.");
			return null;
		}
		else {
			getPath(parentMap,source,parentMap.get(target));
			path.add(target);
		}
		return path;
	}
	
	
	

}
