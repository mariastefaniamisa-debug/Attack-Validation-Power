import java.util.Scanner;

public class ArenaPertarungan {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Musuh[] gelombangMonster = new Musuh[4];
        gelombangMonster[0] = new Slime();
        gelombangMonster[1] = new Naga();
        gelombangMonster[2] = new Slime();
        gelombangMonster[3] = new Zombie();

        System.out.println("========================================");
        System.out.println(" ARENA RPG: GELOMBANG MONSTER ");
        System.out.println("========================================");
        System.out.println("AWAS! Sekelompok monster menghadang Anda!");

        boolean isBermain = true;

        while (isBermain) {

            System.out.println("\n--- STATUS MONSTER ---");

            for (int i = 0; i < gelombangMonster.length; i++) {
                System.out.println((i + 1) + ". "
                        + gelombangMonster[i].namaMusuh
                        + " (HP: "
                        + gelombangMonster[i].healthPoint + ")");
            }

            System.out.println("5. Kabur dari pertarungan");
            System.out.print("\nPilih target (1-4 / 5 kabur): ");

            try {

                int pilihanTarget = input.nextInt();

                // KELUAR GAME
                if (pilihanTarget == 5) {
                    System.out.println("Anda lari dari arena...");
                    isBermain = false;
                    continue;
                }

                if (pilihanTarget < 1 || pilihanTarget > 4) {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }

                int indeksMonster = pilihanTarget - 1;
  
                // CUSTOM EXCEPTION TARGET MATI
                if (gelombangMonster[indeksMonster].healthPoint <= 0) {
                    throw new TargetMatiException(
                            "Tindakan ilegal: Monster sudah mati!");
                }

                System.out.print("Masukkan kekuatan serangan (10-100): ");
                int power = input.nextInt();

                // CUSTOM EXCEPTION POWER
                if (power < 10 || power > 100) {
                    throw new SeranganTidakValidException(
                            "Kekuatan serangan harus di antara 10 sampai 100!");
                }

                System.out.println("\n>>> HASIL SERANGAN <<<");

                gelombangMonster[indeksMonster].terimaDamage(power);

                // SERANGAN BALIK MONSTER
                for (Musuh monsterAktif : gelombangMonster) {

                    if (monsterAktif.healthPoint > 0) {

                        monsterAktif.suaraKhas();

                        // MONSTER TERBANG
                        if (monsterAktif instanceof BisaTerbang) {

                            System.out.println("[PERINGATAN! SERANGAN UDARA]");

                            BisaTerbang t =
                                    (BisaTerbang) monsterAktif;

                            t.lepasLandas();
                            t.seranganUdara();

                        } else {
                            monsterAktif.serangPemain();
                        }

                    }
                    // LOOT JIKA MATI
                    else if (monsterAktif instanceof BisaLoot) {

                        BisaLoot loot =
                                (BisaLoot) monsterAktif;

                        loot.jatuhkanItem();
                    }
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("ERROR INPUT: Anda harus memasukkan ANGKA!");
                input.nextLine();

            } catch (TargetMatiException e) {
                System.out.println("KESALAHAN GAME: " + e.getMessage());

            } catch (SeranganTidakValidException e) {
                System.out.println("KESALAHAN GAME: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
            }
        }

        input.close();
        System.out.println("\nGame Selesai!");
    }
}