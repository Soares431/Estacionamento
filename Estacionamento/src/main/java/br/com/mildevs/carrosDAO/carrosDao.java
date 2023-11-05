package br.com.mildevs.carrosDAO;
import br.com.mildevs.entity.carro;
import java.sql.*;

import java.util.*;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class carrosDao {

	
	private static EntityManager manager;
	
	public carrosDao() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carros");
		this.manager = entityManagerFactory.createEntityManager();
	}

	public static boolean insereCarro(carro carros) {

//		String sql = "insert into carro(placa, cor, marca, modelo) values (?, ?, ?, ?)";
//		
//		PreparedStatement stmt;
//		try {
//			stmt  = con.prepareStatement(sql);
//			stmt.setString(1, carros.getPlaca());
//			stmt.setString(2, carros.getCor());
//			stmt.setString(3, carros.getMarca());
//			stmt.setString(4, carros.getModelo());
//			stmt.execute();
//			stmt.close();
//
//		} catch (SQLException e) {
//			System.err.println("Erro ao estacionar");
//			System.err.println(e.getErrorCode());
//			System.err.println(e.getMessage());
//			return false;
//		}
		
		manager.getTransaction().begin();
		manager.persist(carros);
		manager.getTransaction().commit();
		return true;

	}

	public static boolean removerCarro(String placa) {

//		String sql = "delete from carro where placa = ?";
//
//		try {
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, placa);
//
//			stmt.execute();
//			stmt.close();
//
//			return true;
//		} catch (SQLException e) {
//			System.err.println("Erro ao estacionar");
//			System.err.println(e.getErrorCode());
//			System.err.println(e.getMessage());
//			return false;
//		}
		
		carro carro = manager.find(carro.class, placa);
		
		if(carro != null) {
			
			manager.getTransaction().begin();
			manager.remove(carro);
			manager.getTransaction().commit();
			return false;
		}
		
		return false;

	}
	
	public static List<carro> mostraCarro() {

//		String sql = "select * from carro";
//		List<carro> carros = new ArrayList<carro>();
//
//		try {
//			PreparedStatement stnt = con.prepareStatement(sql);
//
//			ResultSet rs = stnt.executeQuery();
//
//			while (rs.next()) {
//				carro carro = new carro(null, null, null, null, 0);
//				
//				carro.setPlaca(rs.getString("placa"));
//				carro.setCor(rs.getString("cor"));
//				carro.setMarca(rs.getString("marca"));
//				carro.setModelo(rs.getString("modelo"));
//
//				carros.add(carro);
//			}
//
//			stnt.close();
//
//		} catch (SQLException e) {
//			System.err.println("Erro ao listar cidades");
//			System.err.println(e.getMessage());
//		}

		Query query = manager.createQuery("select c from carro as c");
		return query.getResultList();
	}

	public static carro consultarCarros(String placa) {
		
//		String sql = "select * from carro where placa = ?";
//		
//		carro carro = new carro(null, null, null, null, 0);
//		try {
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, placa);
//			ResultSet rs = stmt.executeQuery();
//			if (rs.next()) {
//				
//				carro.setPlaca(rs.getString("placa"));
//				carro.setCor(rs.getString("cor"));
//				carro.setMarca(rs.getString("marca"));
//				carro.setModelo(rs.getString("modelo"));
//				
//				return carro;
//			}
//			
//		} catch (SQLException e) {
//			System.err.println("Erro ao listar carro");
//			System.err.println(e.getMessage());
//			
//		}
		carro carro = manager.find(carro.class, placa);
		
		return carro;
		
	}
	

//codigo a parte

	public List<carro> listaCarrosPorFabricante(String fabricante) {
		Query query = this.manager.createQuery("select c from Carro as c where c.fabricante = :fabricante");
		query.setParameter("fabricante", fabricante);
		
		return query.getResultList();
	}
}
