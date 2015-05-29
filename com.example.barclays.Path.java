package com.example.barclays;

public class Path {
	private Node targetNode;

	private int travelTime;

	public Path(Node targetNode, int travelTime) {
		this.targetNode = targetNode;
		this.travelTime = travelTime;
	}

	public Node getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((targetNode == null) ? 0 : targetNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Path other = (Path) obj;
		if (targetNode == null) {
			if (other.targetNode != null) {
				return false;
			}
		} else if (!targetNode.equals(other.targetNode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Destination [node=" + targetNode + ", travelTime=" + travelTime + "]";
	}

}
