package hamburgueseria;
import java.util.ArrayList;

public class Hamburgueseria {
		private static final int GRAMOS_POR_MEDALLON = 110;
		private ArrayList<Pedido> pedidos;
		private int cantPedidos;
		private float subTotal;
		private float aPagar;
		private int cantPancetas;
		private int cantMedallones;
		private int cantMedallonesVeggies;
		private int cantFetasCheddar;
		private int cantBurgers;

		public Hamburgueseria() {
			this.pedidos = new ArrayList<>();
		}

		private void setCantPedidos(int cantPedidos) {
			this.cantPedidos = cantPedidos;
		}

		private void setSubTotal() {
			float precio = 0;
			for (Pedido pedido : pedidos) {
				precio = precio + pedido.getSubTotal();
			}
			this.subTotal = precio;
		}

		private void setAPagar() {
			float precio = 0;
			for (Pedido pedido : pedidos) {
				precio = precio + pedido.getPrecioTotal();
			}
			this.aPagar = precio;
		}

		private void setCantPancetas() {
			int cant = 0;
			for (Pedido pedido : pedidos) {
				cant = cant + pedido.cantPancetaPedido();
			}
			this.cantPancetas = cant;
		}

		private void setCantMedallones() {
			int cant = 0;
			for (Pedido pedido : pedidos) {
				cant = cant + pedido.cantMedallones();
			}
			this.cantMedallones = cant;

		}

		private void setCantMedallonesVeggies() {
			int cant = 0;
			for (Pedido pedido : pedidos) {
				cant = cant + pedido.cantMedallonesVeggie();
			}
			this.cantMedallonesVeggies = cant;

		}

		private void setCantFetasCheddar() {
			int cant = 0;
			for (Pedido pedido : pedidos) {
				cant = cant + pedido.cantFetas();
			}
			this.cantFetasCheddar = cant;

		}

		public void finPedidos() {
			datosFinalesPedidos();
			this.setCantPedidos(this.pedidos.size());
			this.setSubTotal();
			this.setCantMedallones();
			this.setCantMedallonesVeggies();
			this.setCantFetasCheddar();
			this.setCantPancetas();
			this.setCantBurgers();
			this.setAPagar();
		}

		private void setCantBurgers() {
			int cant = 0;
			for (Pedido pedido : pedidos) {
				cant = cant + pedido.getCantBurgers();
			}
			this.cantBurgers = cant;

		}

		public void crearPedido(String nombre, String direccion, String comentario) {
			ArrayList<Hamburguesas> burgers = new ArrayList<>();

			this.pedidos.add(new Pedido(nombre, direccion, comentario, burgers));

		}

		public void agregarBurgersAPedido(String nombre, String burger, int cant) {
			Pedido pedido = buscarPedido(nombre);
			pedido.agregarBurger(cant, burger);

		}

		private Pedido buscarPedido(String nombre) {
			Pedido pedido = null;
			String nombreActual;
			int i = 0;

			while (i < this.pedidos.size() && pedido == null) {
				nombreActual = this.pedidos.get(i).getNombre();
				if (nombreActual == nombre) {
					pedido = this.pedidos.get(i);
				} else {
					i++;
				}
			}
			return pedido;
		}

		private int cuantasDeUnTipo(TipoBurgers tipo) {
			int contador = 0;
			for (Pedido pedido : pedidos) {
				contador = contador + pedido.cuantas(tipo);
			}
			return contador;
		}

		private void datosFinalesPedidos() {
			for (Pedido pedido : pedidos) {
				pedido.datosFinalesPedidos();
			}
		}

		public void datosFinales() {
			System.out.println("En total hay " + this.cantPedidos + " pedidos");
			System.out.println(this.cantBurgers + " hamburguesas pedidas");
			System.out.println("DETALLE:");
			System.out.println(this.cuantasDeUnTipo(TipoBurgers.CUARTO_DE_LIBRA) + " Cuarto de libra");
			System.out.println(this.cuantasDeUnTipo(TipoBurgers.OKLAHOMA) + " Oklahomas");
			System.out.println(this.cuantasDeUnTipo(TipoBurgers.CHEESE) + " Cheeses");
			System.out.println(this.cuantasDeUnTipo(TipoBurgers.VEGGIE) + " Veggies");
			System.out.println("Se necesitan: ");
			System.out.println(this.cantBurgers + " panes");
			System.out.println(this.cantPanesPapa() + " de papa");
			System.out.println(this.cantPanesQueso() + " de queso");
			System.out.println(this.cantMedallones + " medallones de carne");
			System.out.println(((double) (this.cantMedallones * GRAMOS_POR_MEDALLON) / 1000) + " kilos de carne");
			System.out.println(this.cantMedallonesVeggies + " medallones vegetarianos");
			System.out.println(this.cantFetasCheddar + " fetas de queso");
			System.out.println(this.cantPancetas + " fetas de panceta");
			System.out.println("SubTotal sin delivery: $" + this.subTotal);
			System.out.println("Total con delivery: $" + this.aPagar);
		}

		private int cantPanesQueso() {
			int contador = 0;
			for (Pedido pedido : pedidos) {
				contador = contador + pedido.cantPanQueso();
			}
			return contador;
		}

		private int cantPanesPapa() {
			int contador = 0;
			for (Pedido pedido : pedidos) {
				contador = contador + pedido.cantPanPapa();
			}
			return contador;
		}
	}
