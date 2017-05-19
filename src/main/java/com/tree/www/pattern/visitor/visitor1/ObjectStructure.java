package com.tree.www.pattern.visitor.visitor1;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象角色类，这个结构对象角色持有一个聚集，并向外界提供add()方法作为对聚集的管理操作。
 * 
 * 通过调用这个方法，可以动态地增加一个新的节点。
 * 
 * @author pys
 *
 * @date 2016年4月29日 下午2:11:31
 */
public class ObjectStructure {

	private List<Node> nodes = new ArrayList<Node>();

	// 执行方法操作
	public void action(Visitor visitor) {
		for (Node node : nodes) {
			node.accept(visitor);
		}
	}

	public void add(Node node) {
		if (!nodes.contains(node)) {
			nodes.add(node);
		}
	}
}
