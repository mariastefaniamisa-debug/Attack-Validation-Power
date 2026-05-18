// 1. Warisi class Exception bawaan Java
public class SeranganTidakValidException extends Exception {
    
     // 2. Constructor menerima pesan error
        public SeranganTidakValidException(String pesan) {
        super(pesan);
        }
}