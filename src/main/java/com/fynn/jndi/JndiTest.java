package com.fynn.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class JndiTest {
	/**
	* @param args
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		// manually create the ROOT DIR
		env.put(Context.PROVIDER_URL, "file:/D://");
		try {
			Context ctx = new InitialContext(env);
			ctx.createSubcontext("sylilzy");
			NamingEnumeration list = ctx.list("/");
			while (list.hasMore()) {
				NameClassPair nc = (NameClassPair) list.next();
				System.out.println(nc);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
