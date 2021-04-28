package hamburgueseria;

public class Hamburguesas {
	// Constants
	private static final float CHEESE_SIMPLE = 270;
	private static final float CHEESE_DOBLE = 320;
	private static final float CHEESE_TRIPLE = 380;
	private static final float CUARTO_SIMPLE = 310;
	private static final float CUARTO_DOBLE = 360;
	private static final float CUARTO_TRIPLE = 420;
	private static final float CUARTO_CUADRUPLE = 500;
	private static final float OK_SIMPLE = 290;
	private static final float OK_DOBLE = 330;
	private static final float OK_TRIPLE = 390;
	private static final float VEG_DOBLE = 300;
	private static final float VEG_SIMPLE = 250;
	private static final int FETAS_POR_MEDALLON = 2;

	// Attributes
	private int tamaño;
	private int cantMedVeggie;
	private float precio;
	private TipoBurgers tipo;
	private int cantFetas;
	private int cantPanceta;
	private int pan = 1;
	private TipoPan tipoPan;

	public Hamburguesas(int tamaño, TipoBurgers tipo) {
			this.setTipo(tipo);
			this.setTamaño(tamaño);
			this.establecerPrecio();
			this.setCantFetas();
			this.setCantPanceta();
			this.setTipoPan();
		}

	private void setTipoPan() {
		if (tipo == TipoBurgers.CHEESE || tipo == TipoBurgers.VEGGIE) {
			tipoPan = TipoPan.QUESO;
		} else {
			tipoPan = TipoPan.PAPA;
		}
	}

	private void setCantPanceta() {
		// Es 0 al menos que sea cuarto de libra//

		this.cantPanceta = 0;
		if (tipo == TipoBurgers.CUARTO_DE_LIBRA) {
			this.cantPanceta = 2;
			if (this.tamaño == 4) {
				this.cantPanceta = 3;
			}

		}

	}

	public int getPan() {
		return pan;
	}

	private void establecerPrecio() {

		if (tipo == TipoBurgers.CHEESE) {
			switch (tamaño) {
			case 1:
				this.setPrecio(CHEESE_SIMPLE);
				break;
			case 2:
				this.setPrecio(CHEESE_DOBLE);
				break;
			case 3:
				this.setPrecio(CHEESE_TRIPLE);
				break;
			}
		} else if (tipo == TipoBurgers.CUARTO_DE_LIBRA) {
			switch (tamaño) {
			case 1:
				this.setPrecio(CUARTO_SIMPLE);
				break;
			case 2:
				this.setPrecio(CUARTO_DOBLE);
				break;
			case 3:
				this.setPrecio(CUARTO_TRIPLE);
				break;
			case 4:
				this.setPrecio(CUARTO_CUADRUPLE);
				break;
			}
		} else if (tipo == TipoBurgers.OKLAHOMA) {
			switch (tamaño) {
			case 1:
				this.setPrecio(OK_SIMPLE);
				break;
			case 2:
				this.setPrecio(OK_DOBLE);
				break;
			case 3:
				this.setPrecio(OK_TRIPLE);
				break;
			}
		} else if (tipo == TipoBurgers.VEGGIE) {
			switch (cantMedVeggie) {
			case 1:
				this.setPrecio(VEG_SIMPLE);
				break;
			case 2:
				this.setPrecio(VEG_DOBLE);
				break;
			}
		}
	}

	public int getCantPanceta() {
		return cantPanceta;
	}

	public int getTamaño() {
		return tamaño;
	}

	public float getPrecio() {
		return precio;
	}

	public int getCantFetas() {
		return cantFetas;
	}

	public TipoBurgers getTipo() {
		return tipo;
	}

	public TipoPan getTipoPan() {
		return tipoPan;
	}

	private void setTamaño(int tamaño) {
		if (tipo == TipoBurgers.VEGGIE) {
			this.cantMedVeggie = tamaño;
			this.tamaño = 0;
		} else {
			this.tamaño = tamaño;
		}
	}

	private void setPrecio(float precio) {
		this.precio = precio;
	}

	private void setTipo(TipoBurgers tipo) {
		this.tipo = tipo;
	}

	private void setCantFetas() {

		if (tipo == TipoBurgers.CHEESE) {
			this.cantFetas = (FETAS_POR_MEDALLON * this.tamaño) + 1;
		} else if (tipo == TipoBurgers.VEGGIE) {
			this.cantFetas = (FETAS_POR_MEDALLON * this.cantMedVeggie);
		} else {
			this.cantFetas = (FETAS_POR_MEDALLON * this.tamaño);
		}

	}

	public int getCantMedVeggie() {
		return cantMedVeggie;
	}

}
