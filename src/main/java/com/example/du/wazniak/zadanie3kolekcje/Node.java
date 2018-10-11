package com.example.du.wazniak.zadanie3kolekcje;

import java.util.LinkedHashSet;
import java.util.Set;

public class Node {

	private String napis;
	private Set<Node> connections = new LinkedHashSet<>();

	public Node(String napis) {
		this.napis = napis;
	}

	public void link(Node node) {
		this.connections.add(node);

		node.connections.add(this);
	}

	public void walkThrough() {
		walkThrough(new LinkedHashSet<>());
	}

	/**
	 * invokes walkThrough(Set<Node> visited) method on all connected nodes that are
	 * not visited yet.
	 * 
	 * @param visited
	 */
	private Set<Node> walkThrough(Set<Node> visited) {
		System.out.println(napis);

		visited.add(this);

		for (Node element : connections) {
			if (visited.contains(element))
				continue;

			Set<Node> visitedByConnection = element.walkThrough(visited);
			visited.addAll(visitedByConnection);
		}
		return visited;
	}

	public void walkAcross() {
		Set<Node> visited = new LinkedHashSet<>();
		Set<Node> toVisit = new LinkedHashSet<>();

		System.out.println(this.napis);

		visited.add(this);

		while (true) {
			for (Node element : visited) {
				for(Node elementConnection : element.connections)
					if(!visited.contains(elementConnection))
						toVisit.add(elementConnection);
			}
			
			if(visited.containsAll(toVisit))
				break;
			
			for (Node element : toVisit) {
				System.out.println(element.napis);
			}

			visited.addAll(toVisit);
			toVisit.clear();
		}
	}
}
