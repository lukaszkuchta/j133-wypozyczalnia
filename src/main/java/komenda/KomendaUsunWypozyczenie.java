package komenda;

import database.DataAccessObject;
import model.Wypozyczenie;

public class KomendaUsunWypozyczenie implements Komenda{
    private DataAccessObject<Wypozyczenie> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "usun wypozyczenie";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id wypozyczenia:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Wypozyczenie.class, id);
    }
}
