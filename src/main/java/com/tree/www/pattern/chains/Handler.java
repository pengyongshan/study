package com.tree.www.pattern.chains;

public abstract class Handler {
	private int level = TypeEnum.DEFAULT.getValue();

	private Handler nextHandler;

	public Handler(int level) {
		this.level = level;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public abstract void response(IWomen women);

	public final void HandleMessage(IWomen women) {
		if (women.getType() == this.level) {
			this.response(women);
		} else {
			System.out.println(TypeEnum.getNameByValue(this.level) + "级别不够，请求下一级处理。");
			if (this.nextHandler != null) {
				this.nextHandler.HandleMessage(women);
			} else {
				System.out.println("-----暂无人能处理-----");
			}
		}
	}
}
