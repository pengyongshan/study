package com.tree.www.pattern.state;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 状态模式
 * <p>
 * Created by pysh on 2018/3/8.
 */
public class Client {
    public static void main(String[] args) {
        VoteManager manager = new VoteManager();
        for (int i = 0; i < 8; i++) {
            manager.vote("A", "跑步");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            manager.vote("B", "读书");
        }
    }
}

class VoteManager {

    private VoteState state;
    /**
     * 记录用户投票的结果,Map<String,String>对应Map<用户名称,投票的选项>
     */
    private Map<String, String> mapVote = Maps.newHashMap();
    /**
     * 记录用户投票次数,Map<String,Integer>对应Map<用户名称,投票的次数>
     */
    private Map<String, Integer> mapVoteCount = Maps.newHashMap();
    /**
     * 记录当前每个用户对应的状态处理对象，每个用户当前的状态是不同的
     * Map<String,VoteState>对应Map<用户名称,当前对应的状态处理对象>
     */
    private Map<String, VoteState> mapState = Maps.newHashMap();

    public void vote(String user, String voteItem) {
        Integer oldVoteCount = mapVoteCount.get(user);
        if (oldVoteCount == null || oldVoteCount < 0) {
            oldVoteCount = 0;
        }
        mapVoteCount.put(user, ++oldVoteCount);

        state = mapState.get(user);
        if (state == null) {
            state = new NormalVoteState();
        }
        state.vote(user, voteItem, this);
    }

    public Map<String, VoteState> getMapState() {
        return mapState;
    }

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public Map<String, Integer> getMapVoteCount() {
        return mapVoteCount;
    }

    public VoteState getState() {
        return state;
    }

    public void setState(VoteState state) {
        this.state = state;
    }
}

interface VoteState {
    void vote(String user, String voteItem, VoteManager manager);
}

class NormalVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        manager.getMapVote().put(user, voteItem);
        System.out.println("投票成功," + user + "-" + voteItem);
        manager.getMapState().put(user, new RepeatVoteState());
    }
}

class RepeatVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        System.out.println("请不要重复投票");
        if (manager.getMapVoteCount().get(user) >= 5) {
            manager.getMapState().put(user, new SpiteVoteState());
        }
    }
}

class SpiteVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        manager.getMapVote().remove(user);
        System.out.println("你有恶意刷票行为，取消投票资格");
        if (manager.getMapVoteCount().get(user) >= 7) {
            manager.getMapState().put(user, new BlackVoteState());
        }
    }
}

class BlackVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager manager) {
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}

