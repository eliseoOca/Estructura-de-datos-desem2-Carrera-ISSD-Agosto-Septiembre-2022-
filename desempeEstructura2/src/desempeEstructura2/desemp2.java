package desempeEstructura2;

public class desemp2 {

	class Nodo {
		int info;
		Nodo izq, der;
	}

	Nodo raiz;
	int cant;

	public desemp2() {
		raiz = null;
	}

	// CONSIGNA 1
	public void insertar(int info) {
		Nodo nuevo;
		nuevo = new Nodo();
		nuevo.info = info;
		nuevo.izq = null;
		nuevo.der = null;
		if (raiz == null)
			raiz = nuevo;
		else {
			Nodo anterior = null, reco;
			reco = raiz;
			while (reco != null) {
				anterior = reco;
				if (info < reco.info)
					reco = reco.izq;
				else
					reco = reco.der;
			}
			if (info < anterior.info)
				anterior.izq = nuevo;
			else
				anterior.der = nuevo;
		}
	}

	private void recorrerPre(Nodo reco) {
		if (reco != null) {
			System.out.print(reco.info + "-");
			recorrerPre(reco.izq);
			recorrerPre(reco.der);
		}
	}

	public void recorrerpre() {
		recorrerPre(raiz);
		System.out.println();
	}

	// consigna 2
	public void mayorValor() {
		if (raiz != null) {
			Nodo reco = raiz;
			while (reco.der != null)
				reco = reco.der;
			System.out.println("El Mayor valor que tiene el subarbol  es el:" + reco.info);
		}
	}

	public void menorValor() {
		if (raiz != null) {
			Nodo reco = raiz;
			while (reco.izq != null)
				reco = reco.izq;
			System.out.println("El Menor valor que tiene el subarbol  es el:" + reco.info);
		}
	}

	// consigna 3

	private void imprimirPrimerosTresNiveles(Nodo reco, int info) {
		if (reco != null) {
			imprimirPrimerosTresNiveles(reco.izq, info + 1);
			System.out.print(reco.info + " (" + info + ") - ");
			imprimirPrimerosTresNiveles(reco.der, info + 1);
		}
	}

	public void imprimirPrimerosTresNiveles() {
		imprimirPrimerosTresNiveles(raiz, 1);
		System.out.println("El parametro info se encuentra en los primeros tres niveles");

	}

	public boolean existe(int info) {
		Nodo reco = raiz;
		while (reco != null) {
			if (info == reco.info)
				return true;
			else if (info > reco.info)
				reco = reco.der;
			else
				reco = reco.izq;
		}
		return false;
	}

	// consigna 4
	private void cantidadNodosHojaIzq(Nodo reco) {
		if (reco != null) {
			if (reco.izq == null)
				cant++;
			cantidadNodosHojaIzq(reco.izq);

		}
	}

	public int cantidadNodosHojaIZQ() {
		cant = 0;
		cantidadNodosHojaIzq(raiz);
		return cant;
	}

	// consigna 5
	public void borrarMayorDer() {
		if (raiz != null) {
			if (raiz.der == null)
				raiz = raiz.izq;
			else {
				Nodo atras = raiz;
				Nodo reco = raiz.der;
				while (reco.der != null) {
					atras = reco;
					reco = reco.der;
				}
				atras.der = reco.izq;
			}
		}
	}

	public static void main(String[] ar) {
		desemp2 arb = new desemp2();
		arb.insertar(10);
		arb.insertar(7);
		arb.insertar(9);
		arb.insertar(20);
		arb.insertar(15);
		arb.recorrerpre();
		System.out.println();
		arb.mayorValor();
		System.out.println();
		arb.menorValor();
		System.out.println();
		if (arb.existe(10) && arb.existe(7) && arb.existe(9) && arb.existe(20) && arb.existe(15))
			System.out.println("si se encuentra el parametro info en los tres primeros  niveles");
		else
			System.out.println("no se encuentra el parametro info en los tres primeros  niveles");
		System.out.println();
		arb.imprimirPrimerosTresNiveles();
		System.out.println();
		System.out.println("Cantidad de nodos hoja subarbol izquierdo:" + arb.cantidadNodosHojaIZQ());
		System.out.println();
		arb.borrarMayorDer();
		System.out.println();
		System.out.println("Borrar el mayor valor del subárbol : ");
		arb.recorrerpre();

	}
}
