import java.time.LocalDate;
/* Dari AI */
public class AlatUkur extends Alat implements Kalibrasiable {
    private final String satuan;
    private final LocalDate kalibrasiTerakhir;

    public AlatUkur(String kode, String nama, int tahun,
            String satuan, LocalDate kalibrasiTerakhir) {
        super(kode, nama, tahun);
        this.satuan = satuan;
        this.kalibrasiTerakhir = kalibrasiTerakhir;
    }

    @Override 
    public LocalDate jatuhTempoKalibrasi(){
        return kalibrasiTerakhir.plusMonths(12);
    }

    @Override
    public boolean perluKalibrasi(){
        return LocalDate.now().isAfter(jatuhTempoKalibrasi());
    }

    @Override
    public boolean siapDipinjam() {
        return !perluKalibrasi();
    }

    /* Buatan sebelumnya */
    @Override 
    public String deskripsi() {
        return super.deskripsi() + " " + satuan + " satuan ";
    }
}