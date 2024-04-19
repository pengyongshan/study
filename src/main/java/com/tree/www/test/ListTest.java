package com.tree.www.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by pysh on 2021/5/7.
 */
public class ListTest {
  private static final ExecutorService executorHandler = new ThreadPoolExecutor(20, 40, 5, TimeUnit.MINUTES,
      new LinkedBlockingDeque<>(2000));

  public static void main(String[] args) {
    List<PO> list = new CopyOnWriteArrayList<>();
    List<CompletableFuture<Void>> taskList = new ArrayList<>();
    for (int i = 0; i < 500; i++) {
      taskList.add(CompletableFuture.runAsync(() -> {
        try {
          TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        list.add(new PO(1, "a"));
      }, executorHandler));
    }
    CompletableFuture.allOf(taskList.toArray(new CompletableFuture[0])).join();
    System.out.println(list.size());
    System.out.println(list);

    // 待解绑
    List<Long> oldList = new ArrayList<>();
    List<Long> abelConfigIds = new ArrayList<>();
    oldList.add(5L);
    oldList.add(6L);
    oldList.add(11L);
    abelConfigIds.add(11L);
    List<Long> toCancel = oldList.stream().filter(a -> !abelConfigIds.contains(a)).collect(Collectors.toList());
    // 待绑定
    List<Long> toBind = abelConfigIds.stream().filter(a -> !oldList.contains(a)).collect(Collectors.toList());
    System.out.println(toCancel);
    System.out.println(toBind);
  }
}

class PO {
  private Integer a;
  private String b;

  public PO(Integer a, String b) {
    this.a = a;
    this.b = b;
  }

  public Integer getA() {
    return a;
  }

  public void setA(Integer a) {
    this.a = a;
  }

  public String getB() {
    return b;
  }

  public void setB(String b) {
    this.b = b;
  }
}
