package com.fruta.btuco.transformer;

public interface TriadicTransformer<A, B, C> {
	public C transform(A a, B b);
}
