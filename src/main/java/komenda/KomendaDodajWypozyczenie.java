package komenda;

import database.DataAccessObject;
import model.Klient;
import model.Samochod;
import model.Wypozyczenie;

import java.time.LocalDate;
import java.util.Optional;

public class KomendaDodajWypozyczenie implements Komenda{
    private DataAccessObject<Wypozyczenie> dao = new DataAccessObject<>();
    private DataAccessObject<Klient> daoKlient = new DataAccessObject<>();
    private DataAccessObject<Samochod> daoSamochod = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "dodaj wypozyczenie";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta:");
        String idKlientString = Komenda.SCANNER.nextLine();
        Long idKlient = Long.parseLong(idKlientString);
        Optional<Klient> klientOptional = daoKlient.find(Klient.class, idKlient);
        if (klientOptional.isEmpty()) {
            System.err.println("Klient o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj id samochodu:");
        String idSamochodString = Komenda.SCANNER.nextLine();
        Long idSamochod = Long.parseLong(idSamochodString);
        Optional<Samochod> samochodOptional = daoSamochod.find(Samochod.class, idSamochod);
        if (samochodOptional.isEmpty()) {
            System.err.println("Samochod o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj numer umowy:");
        String numerUmowy = Komenda.SCANNER.nextLine();

        System.out.println("Podaj date planowanego zwroru(YYYY-MM-DD):");
        String dataPlanowanegoZwrotuString = Komenda.SCANNER.nextLine();
        LocalDate dataPlanowanegoZwrotu = LocalDate.parse(dataPlanowanegoZwrotuString);

        System.out.println("Podaj cene wynajmu:");
        String cenaWynajmuString = Komenda.SCANNER.nextLine();
        double cenaWynajmu = Double.parseDouble(cenaWynajmuString);

        Wypozyczenie wypozyczenie = Wypozyczenie.builder()
                .klient(klientOptional.get())
                .samochod(samochodOptional.get())
                .numerUmowy(numerUmowy)
                .dataPlanowanegoZwrotu(dataPlanowanegoZwrotu)
                .cenaWynajmu(cenaWynajmu)
                .build();

        dao.insert(wypozyczenie);
    }
}
