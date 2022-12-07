package komenda;

import database.DataAccessObject;
import model.Samochod;

public class KomendaUsunSamochod implements Komenda{
    private DataAccessObject<Samochod> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "usun samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id samochodu:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Samochod.class, id);
    }
}
