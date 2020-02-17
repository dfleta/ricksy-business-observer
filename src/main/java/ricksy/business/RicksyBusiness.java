/**
 * Ricksy Business
 * ===============
 * Rick se queda a cargo Morty y Summer, 
 * pero en su lugar celebra una gran fiesta. 
 * Entre los invitados hay adolescentes, aliens, 
 * Gearhead, Squanchy, Ricks alternativos y 
 * Abradolf Lincler (una combinación de DNA
 * de Adolf Hitler y Abraham Lincoln).
 * 
 * Cuando un invitado/a llega a la fiesta, 
 * se le da de alta en el receptivo del sistema
 * mediante su tarjeta de crédito.
 * El receptivo carga en el crédito de la tarjeta:
 * - el coste del Ovni de vuelta a casa
 * - el coste de los productos del pack de bienvenida.
 * 
 * El componente de reserva de Ovnis y el componente
 * de entrega del pack de bienvenida observan al
 * componente receptivo, de modo que cuando el receptivo
 * da de alta a un invitado/a automáticamente cargan 
 * en la tarjeta del invitado/a el coste de ambos servicios. 
 */

package ricksy.business;

public class RicksyBusiness {
    
    public static void main(String[] args) {
        System.out.println();

        /**
         * Crea la clase tarjeta de crédito
         * de los invitados.
         * Como es una AndromedanExpress
         * el crédito inicial es de 3000 EZIS
         */

        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        
        System.out.println("\n" + "Tarjeta de Abradol" + "\n" + 
                                  "=================="        );
        System.out.println(card);

        /**
         * Primero hay que construir el componente de reserva de Ovnis
         * Recibe un objeto tarjeta de crédito en su método
         * dispatch(card)
         * y realiza el cargo a la tarjeta
         */





        /**
         * Crea el receptivo de invitados de nuestro sistema.
         * Da de alta a un invitado mediante su tarjeta de crédito.
         */







    }
}
