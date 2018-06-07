package com.tree.www.pattern.memento.memento2;

import java.util.HashMap;
import java.util.Map;

// 发起人
public class Originator {

	private String state1;

	private String state2;

	private String state3;

	public String getState1() {
		return state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public String getState2() {
		return state2;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public String getState3() {
		return state3;
	}

	public void setState3(String state3) {
		this.state3 = state3;
	}

	public IMemento createMemento() {
		return new Memento(BeanUtils.backupProp(this));
	}

	public void restoreMemento(IMemento memento) {
		BeanUtils.restoreProp(this, ((Memento) memento).getStateMap());
	}

	@Override
	public String toString() {
		return "state1=" + state1 + "\tstate2=" + state2 + "\tstate3=" + state3;
	}

	private class Memento implements IMemento {

		private Map<String, Object> stateMap = new HashMap<>();

		private Memento(Map<String, Object> map) {
			this.stateMap = map;
		}

		public Map<String, Object> getStateMap() {
			return stateMap;
		}

		public void setStateMap(Map<String, Object> stateMap) {
			this.stateMap = stateMap;
		}
	}

}
