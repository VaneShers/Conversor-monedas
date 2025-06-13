import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean valido = false;
        boolean salir = false;
        Scanner lectura = new Scanner(System.in);
        while(!salir){
                System.out.println("************************************");
                System.out.println("Sea bienvenido al conversor de monedas, por favor, elija qué moneda desea convertir:");
                System.out.println("""
                        1) USD
                        2) MXN
                        3) ARS
                        4) Salir
                        ************************************""");
                int monedabase = lectura.nextInt();
                while (valido == false){
                    if (monedabase == 4){
                        salir = true;
                        break;
                    } else if (monedabase != 1 && monedabase != 2 && monedabase != 3) {
                        System.out.println("Por favor, seleccione una opción valida");
                        monedabase = lectura.nextInt();
                        }else{
                        valido = true;
                        }
                }
                if (salir) continue;
                valido = false;
                System.out.println("""
                        ************************************
                        Indique a qué divisa desea convertirla:
                        1) USD
                        2) MXN
                        3) ARS
                        ************************************""");
                int divisa = lectura.nextInt();
                while(valido == false){
                    if(divisa != 1 && divisa != 2 && divisa != 3) {
                        System.out.println("Por favor, seleccione una opción valida");
                        divisa = lectura.nextInt();
                    }else{
                        valido = true;
                    }
                }
                System.out.println("""
                        ************************************
                        ¿Cuál es la cantidad que desea convertir?
                        ************************************""");
                int cantidad = lectura.nextInt();
                String monedabasetexto = switch (monedabase) {
                    case 1 -> "USD";
                    case 2 -> "MXN";
                    case 3 -> "ARS";
                    default -> "0";
                };

                String divisatexto = switch (divisa) {
                    case 1 -> "USD";
                    case 2 -> "MXN";
                    case 3 -> "ARS";
                    default -> "0";
                };
                ConsultaMoneda consulta = new ConsultaMoneda();
                Moneda moneda = consulta.convierteMoneda(monedabasetexto,divisatexto, cantidad);

                System.out.println("El valor de " + cantidad + " " + monedabasetexto + " corresponde a " + moneda.conversion_result() + " " + divisatexto);
        }
    }
}