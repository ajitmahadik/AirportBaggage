package com.example.barclays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConveyorSystem {
	private Map<String, Node> points = new HashMap<String, Node>();

	public Map<String, Node> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Node> points) {
		this.points = points;
	}

	public void buildConveyorPath(String s, String d, int t) {
		Node dest = null;
		Node source = null;

		if (!this.points.containsKey(s)) {
			source = new Node(s);
			this.points.put(s, source);
		} else {
			source = this.points.get(s);
		}

		if (!this.points.containsKey(d)) {
			dest = new Node(d);
			this.points.put(d, dest);
		} else {
			dest = this.points.get(d);
		}

		Path sp = createDestination(dest, t);
		Path dp = createDestination(source, t);

		source.addDestination(sp);
		dest.addDestination(dp);
	}

	private Path createDestination(Node source, int t) {
		return new Path(source, t);
	}

	public double findPath(String start, String end) {
		Node node = this.points.get(start);

		Queue<Node> queue = new PriorityQueue<Node>();
		queue.add(node);

		node.setMinimumDistance(0);

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			List<Path> destinations = n.getDestinations();
			for (Path path : destinations) {
				Node targetNode = path.getTargetNode();
				int travelTime = path.getTravelTime();

				double distance = n.getMinimumDistance() + travelTime;

				if (distance < targetNode.getMinimumDistance()) {
					targetNode.setMinimumDistance(distance);
					targetNode.setPrev(n);

					queue.add(targetNode);
				}
			}
		}

		Node node2 = this.points.get(end);

		if (node2 != null) {
			return node2.getMinimumDistance();
		} else {
			return 0;
		}
	}

	public String showPath(String targetNode) {
		Node node = this.points.get(targetNode);

		StringBuilder sb = new StringBuilder();

		for (Node n = node; n != null; n = n.getPrev()) {
			sb.insert(0, " " + n.getName());
		}

		sb.delete(0, 1);

		return sb.toString();
	}
}
