package komenda;

import database.DataAccessObject;
import model.Wypozyczenie;
import model.Zwrot;

import java.util.Optional;

public class KomendaDodajZwrot implements Komenda{
    private DataAccessObject<Zwrot> dao = new DataAccessObject<>();
    private DataAccessObject<Wypozyczenie> daoWypozyczenie = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "dodaj zwrot";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id wypozyczenia:");
        String idWypozyczenieString = Komenda.SCANNER.nextLine();
        Long idWypozyczenie = Long.parseLong(idWypozyczenieString);
        Optional<Wypozyczenie> wypozyczenieOptional = daoWypozyczenie.find(Wypozyczenie.class, idWypozyczenie);
        if (wypozyczenieOptional.isEmpty()) {
            System.err.println("Wypozyczenie o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj notatke:");
        String notatka = Komenda.SCANNER.nextLine();

        Zwrot zwrot = Zwrot.builder()
                .wypozyczenie(wypozyczenieOptional.get())
                .notatka(notatka)
                .build();

        dao.insert(zwrot);
    }
}
