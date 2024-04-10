package trabajo2;

public class Sorted {

    // Rosas Vera Anyali Guadalupe
    public static <E extends Comparable<E>> void ordenamiento(E[] arreglo) {
        int n = arreglo.length;
        int intervalo = n / 2;

        while (intervalo > 0) {
            for (int i = intervalo; i < n; i++) {
                E temp = arreglo[i];
                int j = i;

                while (j >= intervalo && arreglo[j - intervalo].compareTo(temp) > 0) {
                    arreglo[j] = arreglo[j - intervalo];
                    j -= intervalo;
                }

                arreglo[j] = temp;
            }

            intervalo /= 2;
        }
    }

  //Alegre castilla sthefany alexandra
    public static <E extends Comparable<E>> void listAll(E[] arreglo) {
        selectSort(arreglo);
        for (E item : arreglo) {
            System.out.println(item);
        }
    }

    private static <E extends Comparable<E>> void selectSort(E[] arreglo) {
        int n = arreglo.length;
        boolean ordenado = true;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j].compareTo(arreglo[minIndex]) < 0) {
                    minIndex = j;
                    ordenado = false;
                }
            }
            if (minIndex != i) {
                E temp = arreglo[i];
                arreglo[i] = arreglo[minIndex];
                arreglo[minIndex] = temp;
            }
        }
        if (ordenado) {
            return;
        }
    }


  //VARGAS ARISPE JONATHAN SNAYDER
    public static <E extends Comparable<E>> E searchItem(E[] arreglo, E ele) throws ItemNotFound {
        ordenamiento(arreglo);
        int index = binarySearch(arreglo, ele, 0, arreglo.length - 1);
        if (index != -1) {
            return arreglo[index];
        } else {
            throw new ItemNotFound("Elemento no encontrado");
        }
    }
    private static <E extends Comparable<E>> int binarySearch(E[] arreglo, E ele, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arreglo[mid].compareTo(ele) == 0) {
                return mid;
            }

            if (arreglo[mid].compareTo(ele) < 0) {
                return binarySearch(arreglo, ele, mid + 1, right);
            } else {
                return binarySearch(arreglo, ele, left, mid - 1);
            }
        }
        return -1;
        //clases asicionales para separar
        
        class Persona implements Comparable<Persona> {
    private int codigo;
    private String nombre;
    private float peso;

    public Persona(int codigo, String nombre, float peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peso = peso;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        return this.nombre.compareTo(otraPersona.nombre);
    }

    @Override
    public String toString() {
        return "Persona <<" +
                "codigo:" + codigo +
                " nombre: '" + nombre + '\'' +
                " peso: " + peso +
                ">>";
    }
}

        public class ItemNotFound extends Exception {
    public ItemNotFound(String message) {
        super(message);
    }
}

    }

public static void main(String[] args) {

        Integer[] numeros = {4, 2, 7, 1, 5, 3, 6};
        System.out.println("Datos de tipo Int antes del ordenamiento:");
        for (Integer num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
        ordenamiento(numeros);
        System.out.println("Datos de tipo Int después del ordenamiento:");
        for (Integer num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();


        Persona[] personas = {
            new Persona(1, "Juan", 70.5f),
            new Persona(2, "Ana", 65.2f),
            new Persona(3, "Pedro", 80.8f)
        };
        System.out.println("Datos de tipo Persona antes del ordenamiento:\n");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
        System.out.print("\n");
        System.out.println("Datos de tipo Persona después del ordenamiento:");
        listAll(personas);


        try {
            Integer[] numerosBusqueda = {4, 2, 7, 1, 5, 3, 6};
            Integer elementoBusqueda = searchItem(numerosBusqueda, 5);
            System.out.println("Elemento encontrado: " + elementoBusqueda);

            searchItem(numerosBusqueda, 10);
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}