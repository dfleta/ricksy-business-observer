/**
 * Ricksy Business
 * ===============
 * Rick se queda a cargo Morty y Summer, 
 * pero en su lugar celebra una gran fiesta. 
 * Entre los invitados hay adolescentes, aliens, 
 * Gearhead, Squanchy, Birdpearson y 
 * Abradolph Lincler (una combinación de DNA
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
         * Crea una tarjeta de crédito para Abradolph.
         * Como es una AndromedanExpress
         * el crédito inicial es de 3000 EZIS
         */

        CreditCard cardA = new CreditCard("Abradolph Lincler", "4916119711304546");
        
        System.out.println("\n" + "Tarjeta de Abradolph" + "\n" + 
                                  "==================="        );
        System.out.println(cardA);

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
        String[] ufosID = { "unx", "dox" };
		for (String ovni : ufosID) {
			ufosPark.add(ovni);
        }
        
        // Procesamos el pago y reserva de ovni de Abradolph
        ufosPark.dispatch(cardA);

        // Mostramos el iD del ovni de Abradolph
        System.out.println("\n" + "Ovni de Abradolph" + "\n" + 
                                  "================"        );
        System.out.println(ufosPark.getUfoOf(cardA.number()));
       
        // Mostramos el credito de Abradolph
        System.out.println("Credito de Abradolph: " + cardA.credit());

        // Abradolph quiere reservar otro ovni
        // El sistema detecta que ya tiene uno 
        // e ignora la petición

        System.out.println("\n" + "Abradolph quiere otro ovni" + "\n" + 
                                  "========================="        );
        ufosPark.dispatch(cardA);
        System.out.println("Su credito no ha cambiado: " + cardA.credit());
        System.out.println("Ovni de Abradolph: " + ufosPark.getUfoOf(cardA.number()));

        // A GearHead le vacían la tarjeta un alien cracker 
        // mientras le da la chapa antes de pagar el ovni

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        CreditCard cardG = new CreditCard("Gearhead", "8888888888888888");

        cardG.pay(3000);
        ufosPark.dispatch(cardG);
        System.out.println("Su credito es cero: " + cardG.credit());
        System.out.println("No puede reservar ovni: " + ufosPark.getUfoOf(cardG.number()));
        
        // Squanchy quiere su ovni

        System.out.println("\nLLega Squanchy!\n" + 
                             "==============");
        CreditCard cardS = new CreditCard("Squanchy", "4444444444444444");
        ufosPark.dispatch(cardS);
        System.out.println("Su credito es: " + cardS.credit());
        System.out.println("Su ovni es: " + ufosPark.getUfoOf(cardS.number()));

        // Morty quiere su ovni, pero no hay disponibles

        System.out.println("\nAlgun ovni para Morty?\n" + 
                             "======================");
        CreditCard cardM = new CreditCard("Morty", "0000000000000000");
        ufosPark.dispatch(cardM);
        System.out.println("Su credito es: " + cardM.credit());
        System.out.println("No hay ovni Morty: " + ufosPark.getUfoOf(cardM.number()));

        // metemos un ovni mas en la flota de ovnis
        // y mostramos la flota por consola

        System.out.println("\nFlota de ovnis\n" + 
                             "==============");
        ufosPark.add("trex");
        System.out.println(ufosPark);


        /**
         * Construye el dispensador del pack de bienvenida.
         * Recibe el numero de unidades y el coste de cada
         * uno de ellos que es de 50 EZIs
         */

        PackExpender packExpender = new PackExpender(3, 50);

        // muestra el total de packs y su precio unidad
        System.out.println("\n" + "Packs" + "\n" + 
                                  "====="        );
        System.out.println(packExpender);

        // Abradolph compre su pack de bienvenida
        packExpender.dispatch(cardA);

        System.out.println("\n" + "Abradolph compra su pack" + "\n" + 
                                  "======================="        );
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de Abradolph: " + cardA.credit());

        // El pobre GerHead no tiene crédito para comprar su pack
        System.out.println("\n" + "GearHead sin credito para su pack" + "\n" + 
                                  "================================="        );
        packExpender.dispatch(cardG);
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de GearHead: " + cardG.credit());


        /**
         * Vamos a automatizar ahora ambas tareas, de modo que
         * cuando llega un invitado/a se le asige un ovni
         * y un pack y se realice el cargo a la tarjeta.
         * 
         * Para ello, crea el componente receptivo
         * y registra (añade) los componentes UberOvnis
         * y PacksDispatcher al receptivo
         */

        Receptivo receptivo = new Receptivo();
        receptivo.registra(packExpender);
        receptivo.registra(ufosPark);

        // implementa el metodo receptivo.dispatch()
        // para que invoque a ufosPark.dispatch()
        // y a packExpender.dispatch()

        // Squanchy es recibido en la fiesta 

        System.out.println("\nLLega Squanchy!\n" + 
                             "==============");
        receptivo.dispatch(cardS);
        mostrarReserva(cardS, packExpender, ufosPark);

        // Gearhead es recibido en la fiesta

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        // A GearHead le vacían la tarjeta mientras da la chapa
        // antes de pagar el ovni y el pack
        cardG.pay(3000);
        receptivo.dispatch(cardG);
        mostrarReserva(cardG, packExpender, ufosPark);

        // Birdpearson es recibido en la fiesta 

        System.out.println("\nLLega Birdpearson!\n" + 
                             "==================");
        CreditCard card = new CreditCard("Birpearson", "1111111111111111");
        receptivo.dispatch(card);
        mostrarReserva(card, packExpender, ufosPark);

        // Morty intenta pillar un ovni y un paclk pero no quedan

        System.out.println("\nMorty quiere pack y ovni pero no quedan :(\n" + 
                             "==========================================");
        card = new CreditCard("Morty", "0000000000000000");
        receptivo.dispatch(card);
        mostrarReserva(card, packExpender, ufosPark);
        
        /**
         * Si te ha sobrado tiempo, añade otra tarea al
         * recpetivo, de modo que cuando llega un invitado/a 
         * se le asige un ovni se realice el cargo a la tarjeta.
         */

         // tu código aquí
    }

    private static void mostrarReserva(CreditCard card, PackExpender expender, UfosPark ufos) {
        System.out.println(card);
        System.out.println("Packs: " + expender.stock());
        System.out.println("Ovni: " + ufos.getUfoOf(card.number()));
    }
}
