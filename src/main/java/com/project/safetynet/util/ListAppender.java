package com.project.safetynet.util;

	import java.util.ArrayList;
	import java.util.List;

	import ch.qos.logback.core.AppenderBase;

	public class ListAppender<E> extends AppenderBase<E> {

	    public List<E> list = new ArrayList<E>();

	    protected void append(E e) {
	        list.add(e);
	    }
	}

