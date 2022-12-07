package komenda;

import database.DataAccessObject;
import model.Samochod;

public class KomendaDodajSamochod implements Komenda{
    private DataAccessObject<Samochod> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj numer rejesttracyjny samochodu:");
        String nrRej = Komenda.SCANNER.nextLine();

        System.out.println("Podaj marke samochodu:");
        String marka = Komenda.SCANNER.nextLine();

        System.out.println("Podaj model samochodu:");
        String model = Komenda.SCANNER.nextLine();

        System.out.println("Podaj ilosc miejsc w samochodzie:");
        String iloscMiejscString = Komenda.SCANNER.nextLine();
        int iloscMiejsc = Integer.parseInt(iloscMiejscString);

        Samochod samochod = Samochod.builder()
                .nrRej(nrRej)
                .marka(marka)
                .model(model)
                .iloscMiejsc(iloscMiejsc)
                .build();

        dao.insert(samochod);
    }
}
