public abstract class Musuh {

    protected String namaMusuh;
    protected int healthPoint;

    public Musuh(String nama, int hp) {
        this.namaMusuh = nama;
        this.healthPoint = hp;
    }

    // method menerima damage
    public void terimaDamage(int damage) {
        healthPoint -= damage;

        if (healthPoint < 0) {
            healthPoint = 0;
        }

        System.out.println(namaMusuh +
                " menerima " + damage +
                " damage! Sisa HP: " + healthPoint);
    }

    public abstract void serangPemain();
    public abstract void suaraKhas();
}