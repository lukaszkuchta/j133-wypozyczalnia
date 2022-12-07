import komenda.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = List.of(
                new KomendaDodajKlient(),
                new KomendaDodajSamochod(),
                new KomendaDodajWypozyczenie(),
                new KomendaDodajZwrot()
        );

        String komenda;
        do {
            System.out.println("Lista dostedodpnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println();

            System.out.println("Podaj komende:");
            komenda = Komenda.SCANNER.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equals(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
