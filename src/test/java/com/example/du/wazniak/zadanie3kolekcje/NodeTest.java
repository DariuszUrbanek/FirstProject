package com.example.du.wazniak.zadanie3kolekcje;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test() {

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");

		a.link(b);
		a.link(c);
		b.link(c);
		c.link(d);
		d.link(e);
		d.link(f);
		f.link(g);

//		d.walkThrough();
		g.walkAcross();

	}

}
