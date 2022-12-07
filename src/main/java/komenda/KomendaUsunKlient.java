package komenda;

import database.DataAccessObject;
import model.Klient;

public class KomendaUsunKlient implements Komenda{
    private DataAccessObject<Klient> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "usun klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Klient.class, id);
    }
}
