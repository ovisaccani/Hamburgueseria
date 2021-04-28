package hamburgueseria;

import java.util.Scanner;

public class Main_Burgers_Test {

	public static void main(String[] args) {
		// nombres: cuarto, oklahoma, veggie, cheese//
		Hamburgueseria hamburgueseria = new Hamburgueseria();
		Scanner scanner = new Scanner(System.in);
		String nombreCliente;
		String hamburguesaPedida;
		String direccion;
		String comentarios;
		int cantMedallones;
		String agregarMasHamburguesas="S";
		String agregarMasPedidos="S";
		
				System.out.println("Bienvenido. El formato para agregar pedidos es: "
				+ "Nombre del cliente, hamburguesa pedida, cantidad de medallones");
		do {
			System.out.println("ingrese nombre del cliente");
			nombreCliente = scanner.nextLine();

			System.out.println("ingrese direccion del cliente");
			direccion = scanner.nextLine();

			System.out.println("ingrese comentarios/extras");
			comentarios = scanner.nextLine();

			hamburgueseria.crearPedido(nombreCliente, direccion, comentarios);

			do {
				System.out.println("ingrese la hamburguesa pedida");
				hamburguesaPedida = scanner.nextLine();

				System.out.println("ingrese la cantidad de medallones");
				cantMedallones = scanner.nextInt();
				scanner.nextLine();

				hamburgueseria.agregarBurgersAPedido(nombreCliente, hamburguesaPedida, cantMedallones);
				System.out.println("Desea agregar otra hamburguesa al pedido? (S/N)");
				agregarMasHamburguesas = scanner.nextLine();
				
			} while (agregarMasHamburguesas.equalsIgnoreCase("S"));
			
			System.out.println("Desea crear otro pedido? (S/N)");
			agregarMasPedidos = scanner.nextLine();
			
		} while (agregarMasPedidos.equalsIgnoreCase("S"));
		scanner.close();

		hamburgueseria.finPedidos();
		hamburgueseria.datosFinales();

	}

}
