// Kelas induk Bangun Datar
abstract class BangunDatar {
    abstract double luas();
    abstract double keliling();
}

// Kelas Segitiga sebagai turunan dari Bangun Datar
class Segitiga extends BangunDatar {
    double alas;
    double tinggi;
    double sisiA, sisiB, sisiC; // Sisi-sisi segitiga

    public Segitiga(double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    // Menghitung luas dengan Rumus Heron
    @Override
    double luas() {
        double s = (sisiA + sisiB + sisiC) / 2;
        return Math.sqrt(s * (s - sisiA) * (s - sisiB) * (s - sisiC));
    }

    @Override
    double keliling() {
        return sisiA + sisiB + sisiC;
    }
}

// Kelas Persegi sebagai turunan dari Bangun Datar
class Persegi extends BangunDatar {
    double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double luas() {
        return sisi * sisi;
    }

    @Override
    double keliling() {
        return 4 * sisi;
    }
}

// Kelas Lingkaran sebagai turunan dari Bangun Datar
class Lingkaran extends BangunDatar {
    double radius;

    public Lingkaran(double radius) {
        this.radius = radius;
    }

    @Override
    double luas() {
        return Math.PI * radius * radius;
    }

    @Override
    double keliling() {
        return 2 * Math.PI * radius;
    }
}

// Kelas SegitigaSikuSiku sebagai turunan dari Segitiga
class SegitigaSikuSiku extends Segitiga {
    public SegitigaSikuSiku(double alas, double tinggi) {
        super(alas, tinggi, alas, tinggi, Math.sqrt(alas*alas + tinggi*tinggi));
    }

    // Overriding untuk menghitung luas segitiga siku-siku
    @Override
    double luas() {
        return (alas * tinggi) / 2;
    }
}

// Kelas SegitigaSamaKaki sebagai turunan dari Segitiga
class SegitigaSamaKaki extends Segitiga {
    public SegitigaSamaKaki(double alas, double tinggi) {
        super(alas, tinggi, alas, tinggi, tinggi); // Asumsi sisi sama kaki adalah tinggi
    }

    // Overriding untuk menghitung luas segitiga sama kaki
    @Override
    double luas() {
        return (alas * tinggi) / 2;
    }
}

// Kelas SegitigaSamaSisi sebagai turunan dari Segitiga
class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(double sisi) {
        super(sisi, (sisi * Math.sqrt(3)) / 2, sisi, sisi, sisi);
    }

    // Overriding untuk menghitung luas segitiga sama sisi
    @Override
    double luas() {
        return (Math.sqrt(3) / 4) * (sisiA * sisiA);
    }
}

// Kelas SegitigaSembarang sebagai turunan dari Segitiga
class SegitigaSembarang extends Segitiga {
    public SegitigaSembarang(double sisiA, double sisiB, double sisiC) {
        super(0, 0, sisiA, sisiB, sisiC); // Alas dan tinggi tidak digunakan
    }

    // Tidak perlu overriding karena sudah menggunakan Rumus Heron di kelas Segitiga
}

// Contoh penggunaan
public class Main {
    public static void main(String[] args) {
        Segitiga segitiga = new SegitigaSamaSisi(3);
        System.out.println("Luas Segitiga Sama Sisi: " + segitiga.luas());
        System.out.println("Keliling Segitiga Sama Sisi: " + segitiga.keliling());
    }
}
