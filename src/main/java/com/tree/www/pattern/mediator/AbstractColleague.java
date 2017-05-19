package com.tree.www.pattern.mediator;

// 抽象同事类
public class AbstractColleague {

	protected AbstractMediator mediator;

	public AbstractColleague(AbstractMediator mediator) {
		this.mediator = mediator;
	}
}
