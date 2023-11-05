package br.com.mildevs.connectoryFactory;

import java.sql.Connection;

public class programaTeste {
	
	public static void main(String[] args) {
		
		new ConnectionFactory();
		Connection con = ConnectionFactory.getConnection();
	
		
		System.out.println("Conectado");
		
	}
}
