package cm.domeni.demo.domain;

import java.io.Serializable;

public interface DemoEntity<T extends Serializable> extends Entity<T> {}
