public class Naga extends Musuh implements Terbang, BisaLoot {

    public Naga() {
        super("Naga Gemoy", 500);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuh +
        " menyemburkan nafas gemoy! Player -50 HP");
    }

    @Override
    public void suaraKhas() {
        System.out.println(this.namaMusuh +
        ": ROAARRR... SEMBURRR!");
    }

    // ===== Interface Terbang =====
    @Override
    public void lepasLandas() {
        System.out.println(this.namaMusuh +
        " terbang tinggi! Sulit diserang.");
    }

    @Override
    public void seranganUdara() {
        System.out.println(this.namaMusuh +
        " menyemburkan badai api! Pemain -80 HP.");
    }

    // ===== Interface BisaLoot =====
    @Override
    public void jatuhkanItem() {
        System.out.println("Loot Drop: "
        + this.namaMusuh +
        " menjatuhkan Sisik Naga Api!");
    }
}