package br.com.mildevs.carro;



import br.com.mildevs.carrosDAO.carrosDao;
import br.com.mildevs.entity.carro;

import java.util.*;

public class PogramaTeste {
	
	public static void main(String[] args) {
		
				
		Scanner in = new Scanner(System.in);
		
		carrosDao carroDao = new carrosDao();
		
		String placa;
		String cor;
		String marca;
		String modelo;
		double vel_max;
		
		//------------------------------
		System.out.println("Digite a placa a ser inserida: ");
		placa = in.nextLine();
		
		System.out.println("Digite a cor a ser inserida: ");
		cor = in.nextLine();
		
		System.out.println("Digite a marca a ser inserida: ");
		marca = in.nextLine();
		
		System.out.println("Digite a modelo a ser inserida: ");
		modelo = in.nextLine();
		
		System.out.println("Digite a velocidade maxima a ser inserida: ");
		vel_max = in.nextDouble();
		in.nextLine();
		
		carro ford = new carro(placa, cor, marca, modelo, vel_max);
		
		carrosDao.insereCarro(ford);
		
		//-------------------------------
		
		for(carro carros : carrosDao.mostraCarro())
		{
			System.out.println("-------------------");
			System.out.println(carros);
			System.out.println("-------------------");
		}
		//-------------------------------
		
		System.out.println("Digite a placa do carro que vai ser removido: ");
		placa = in.nextLine();
		carroDao.removerCarro(placa);
		
		//------------------------------
		
		
		System.out.println("digite a placa do carro pra consultar: ");
		placa = in.nextLine();
		carroDao.consultarCarros(placa);
		
		//------------------------------
		
	}
}
