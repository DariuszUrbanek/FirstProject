package com.example.du.wazniak.zadanie1kolekcje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyMap<A, B> implements Map<A, B> {

	List<Pair<A, B>> list = new ArrayList<Pair<A, B>>();

	private static class Pair<C, D> {

		public C key;
		public D value;

		public Pair(C key, D value) {
			this.key = key;
			this.value = value;
		}

	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean containsKey(Object arg0) {
		for (Pair<A, B> element : list) {
			if (element.key.equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for (Pair<A, B> element : list) {
			if (element.value.equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public B get(Object arg0) {
		for (Pair<A, B> element : list) {
			if (element.key.equals(arg0)) {
				return element.value;
			}
		}
		return null;
	}

	@Override
	public B put(A arg0, B arg1) {
		list.add(new Pair<A, B>(arg0, arg1));
		return arg1;
	}

	@Override
	public B remove(Object arg0) {
		// for (int i = 0; i < list.size(); i++) {
		// if(list.get(i).key.equals(arg0)) {
		// B value = list.get(i).value;
		// list.remove(i);
		// return value;
		// }
		// }
		// return null;

		Iterator<Pair<A, B>> iterator = list.iterator();
		while (iterator.hasNext()) {
			Pair<A, B> pair = iterator.next();
			if (pair.key.equals(arg0)) {
				iterator.remove();
				return pair.value;
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends A, ? extends B> map) {
		list.addAll(map.entrySet().stream().map(this::transform).collect(Collectors.toList()));
	}

	private Pair<A, B> transform(Entry<? extends A, ? extends B> entry) {
		return new Pair<A, B>(entry.getKey(), entry.getValue());
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public Set<A> keySet() {
		Set<A> set = new HashSet<>();
		for (Pair<A, B> pair : list) {
			set.add(pair.key);
		}
		return set;
	}

	@Override
	public Collection<B> values() {
		Collection<B> collection = new HashSet<>();
		for (Pair<A, B> pair : list) {
			collection.add(pair.value);
		}
		return collection;
	}

	@Override
	public Set<Entry<A, B>> entrySet() {
		Set<Entry<A, B>> set = new HashSet<>();
		for (Pair<A, B> pair : list) {
			Entry<A, B> entry = new MyEntry<>(pair.key, pair.value);
			set.add(entry);
		}
		return set;
	}

	private class MyEntry<E, F> implements Entry<E, F> {

		public MyEntry(E key, F value) {
			this.key = key;
			this.value = value;
		}

		private E key;
		private F value;

		@Override
		public E getKey() {
			return key;
		}

		@Override
		public F getValue() {
			return value;
		}

		@Override
		public F setValue(F value) {
			return this.value = value;
		}

	}
}
