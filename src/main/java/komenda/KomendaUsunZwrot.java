package komenda;

import database.DataAccessObject;
import model.Zwrot;

public class KomendaUsunZwrot implements Komenda{
    private DataAccessObject<Zwrot> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "usun zwrot";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id zwrotu:");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        dao.delete(Zwrot.class, id);
    }
}
