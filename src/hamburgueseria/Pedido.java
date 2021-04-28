package hamburgueseria;

import java.util.ArrayList;

public class Pedido {
	private static final float PRECIO_DELIVERY = 50;
	private String nombre;
	private String direccion;
	private float precioTotal;
	private float precioDelivery;
	private float subTotal;
	private String comentario;
	private ArrayList<Hamburguesas> burgers;
	private int cantBurgers;

	public Pedido(String nombre, String direccion, String comentario, ArrayList<Hamburguesas> burgers) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setComentario(comentario);
		this.setBurgers(burgers);
		this.setPrecioDelivery(PRECIO_DELIVERY);
	}

	public int getCantBurgers() {
		return cantBurgers;
	}

	private void setCantBurgers(int cantBurgers) {
		this.cantBurgers = cantBurgers;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public float getPrecioDelivery() {
		return precioDelivery;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public String getComentario() {
		return comentario;
	}

	public ArrayList<Hamburguesas> getBurgers() {
		return burgers;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	private void setPrecioTotal(float precioTotal) {
		this.precioTotal = this.precioConDelivery();
	}

	private void setPrecioDelivery(float precioDelivery) {
		this.precioDelivery = precioDelivery;
	}

	private void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	private void setComentario(String comentario) {
		this.comentario = comentario;
	}

	private void setBurgers(ArrayList<Hamburguesas> burgers) {
		this.burgers = burgers;
	}

	private float sumaBurgers() {
		float precio = 0;
		for (Hamburguesas burger : burgers) {
			precio = precio + burger.getPrecio();
		}
		return precio;
	}

	private float precioConDelivery() {
		return (this.subTotal + PRECIO_DELIVERY);
	}

	public int cantPancetaPedido() {
		int cant = 0;
		for (Hamburguesas burger : burgers) {
			cant = cant + burger.getCantPanceta();
		}
		return cant;
	}

	public int cantMedallones() {
		int cant = 0;
		for (Hamburguesas burger : burgers) {
			cant = cant + burger.getTamaño();
		}
		return cant;
	}

	public int cantFetas() {
		int cant = 0;
		for (Hamburguesas burger : burgers) {
			cant = cant + burger.getCantFetas();
		}
		return cant;
	}

	public void agregarBurger(int cantMedallones, String nombre) {
		TipoBurgers tipo;
		nombre = nombre.toLowerCase();

		switch (nombre) {
		case "oklahoma":
			tipo = TipoBurgers.OKLAHOMA;
			break;
		case "cheese":
			tipo = TipoBurgers.CHEESE;
			break;
		case "cuarto":
			tipo = TipoBurgers.CUARTO_DE_LIBRA;
			break;
		default:
			tipo = TipoBurgers.VEGGIE;
			break;
		}

		Hamburguesas burger = new Hamburguesas(cantMedallones, tipo);
		this.burgers.add(burger);
	}

	public int cuantas(TipoBurgers tipo) {
		int contador = 0;
		for (Hamburguesas burger : burgers) {
			if (burger.getTipo() == tipo) {
				contador = contador + 1;
			}
		}
		return contador;
	}

	public void datosFinalesPedidos() {
		this.setSubTotal(sumaBurgers());
		this.setPrecioTotal(precioConDelivery());
		this.setCantBurgers(this.burgers.size());
	}

	public int cantPanQueso() {
		int cant = this.cantBurgers - this.cantPanPapa();
		return cant;
	}

	public int cantPanPapa() {
		int contador = 0;
		for (Hamburguesas burger : burgers) {
			if (burger.getTipoPan() == TipoPan.PAPA) {
				contador = contador + 1;
			}
		}
		return contador;
	}

	public int cantMedallonesVeggie() {
		
		int cant = 0;
		for (Hamburguesas burger : burgers) {
			cant = cant + burger.getCantMedVeggie();
		}
		return cant;
	}
}
