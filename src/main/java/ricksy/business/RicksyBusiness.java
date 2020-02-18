/**
 * Ricksy Business
 * ===============
 * Rick se queda a cargo Morty y Summer, 
 * pero en su lugar celebra una gran fiesta. 
 * Entre los invitados hay adolescentes, aliens, 
 * Gearhead, Squanchy, Birdpearson y 
 * Abradolf Lincler (una combinación de DNA
 * de Adolf Hitler y Abraham Lincoln).
 * 
 * Cuando un invitado/a llega a la fiesta, 
 * se le da de alta en el receptivo del sistema
 * mediante su tarjeta de crédito.
 * El receptivo carga en el crédito de la tarjeta:
 * - El coste del UberOvni de vuelta a casa
 * - El coste de los productos del pack de bienvenida.
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
         * Crea una tarjeta de crédito para Abradolf.
         * Como es una AndromedanExpress
         * el crédito inicial es de 3000 EZIS
         */

        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        
        System.out.println("\n" + "Tarjeta de Abradolf" + "\n" + 
                                  "==================="        );
        System.out.println(card);

        /**
         * Construye el componente de reserva de Ovnis
         * Recibe el objeto tarjeta de crédito del invitado/a
         * en el método dispatch(card)
         * y realiza un cargo a la tarjeta.
         * Si hay saldo suficiente se reserva un UberOvni
         * libre en el sistema para ese invitado/a.
         * El coste del ovni es de 500 EZIs.
         */

        UfosPark ufosPark = new UfosPark();

        // Disponemos sólo de 3 ovnis que hay que dar de alta en el sistema.
        String[] ufosID = { "unx", "dox", "trex" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
        }
        
        // Procesamos el pago y reserva de ovni de Abradolf
        ufosPark.dispatch(card);

        // Mostramos el iD del ovni de Abradolf
        System.out.println("\n" + "Ovni de Abradolf" + "\n" + 
                                  "================"        );
        System.out.println(ufosPark.getUfoOf(card.number()));
       
        // Mostramos el credito de Abradolf
        System.out.println("Credito de Abradolf: " + card.credit());

        // Abradolf quiere reservar otro ovni
        // El sistema detecta que ya tiene uno e ignora
        // la petición
        System.out.println("\n" + "Abradolf quiere otro ovni" + "\n" + 
                                  "================"        );
        ufosPark.dispatch(card);
        System.out.println("Su credito no ha cambiado: " + card.credit());
        System.out.println("Ovni de Abradolf: " + ufosPark.getUfoOf(card.number()));

        /**
         * Construye el dispensador del pack de bienvenida.
         * Hay 100 packs.
         * El coste de cada uno de ellos es de 50 EZIs
         */

        PackExpender packExpender = new PackExpender(3, 50);

        // muestra el total de packs y su precio unidad
        System.out.println("\n" + "Packs" + "\n" + 
                                  "====="        );
        System.out.println(packExpender);

        // Abradolf compre su pack de bienvenida
        packExpender.dispatch(card);

        System.out.println("\n" + "Abradolf compra su pack" + "\n" + 
                                  "======================="        );
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de Abradolf: " + card.credit());

        /**
         * Crea el receptivo de invitados de nuestro sistema.
         * Da de alta a un invitado mediante su tarjeta de crédito
         * y procesa el pago del Ovni y el pack correspondientes
         * a ese invitado.
         * 
         * Para ello, crea el componente receptivo
         * y registra (añade) los componentes UberOvnis
         * y PacksDispatcher
         */

        Receptivo receptivo = new Receptivo();
        receptivo.registra(packExpender);
        receptivo.registra(ufosPark);

        /**
         * Squanchy es recibido en la fiesta
         */ 

        System.out.println("\nLLega Squanchy!\n" + 
                             "==============");
        card = new CreditCard("Squanchy", "4444444444444444");
        receptivo.dispatch(card);
        mostrarReserva(card, packExpender, ufosPark);

        /**
         * Gearhead es recibido en la fiesta
         */ 

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        card = new CreditCard("Gearhead", "8888888888888888");
        // A GearHead le vacían la tarjeta mientras da la chapa
        // antes de pagar el ovni y el pack
        card.pay(3000);
        receptivo.dispatch(card);
        mostrarReserva(card, packExpender, ufosPark);

        /**
         * Birdpearson es recibido en la fiesta
         */ 

        System.out.println("\nLLega Birdpearson!\n" + 
                             "==================");
        card = new CreditCard("Birpearson", "1111111111111111");
        receptivo.dispatch(card);
        mostrarReserva(card, packExpender, ufosPark);

        /**
         * Birdpearson es recibido en la fiesta
         */

        System.out.println("\nMorty quiere pack y ovni pero no quedan :(\n" + 
                             "==========================================");

        card = new CreditCard("Morty", "0000000000000000");
        receptivo.dispatch(card);
        mostrarReserva(card, packExpender, ufosPark);        
    }

    private static void mostrarReserva(CreditCard card, PackExpender expender, UfosPark ufos) {
        System.out.println(card);
        System.out.println("Packs: " + expender.stock());
        System.out.println("Ovni: " + ufos.getUfoOf(card.number()));
    }
}
