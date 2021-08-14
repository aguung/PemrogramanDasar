package com.devfutech.pemrogramandasar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devfutech.pemrogramandasar.MainActivity
import com.devfutech.pemrogramandasar.R
import com.devfutech.pemrogramandasar.data.model.Content
import com.devfutech.pemrogramandasar.data.model.Materi
import com.devfutech.pemrogramandasar.data.model.SubMateri
import com.devfutech.pemrogramandasar.databinding.MateriFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MateriFragment : Fragment() {

    private val binding: MateriFragmentBinding by lazy {
        MateriFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        (activity as MainActivity).setHeaderTitle("Materi")
        val content = fetchContent()
        val pagerAdapter = ScreenSlidePagerAdapter(this, content)
        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = content[position].nama
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.viewPager.adapter = null
    }

    private fun fetchContent(): List<Materi> {
        val materi = mutableListOf<Materi>()
        val subMateriSatu = mutableListOf<SubMateri>()
        val contentMateriSatuSatu = mutableListOf<Content>()
        contentMateriSatuSatu.add(
            Content(
                nama = "Komputer",
                content = "Komputer adalah perangkat elektronik yang dapat membantu manusia dalam mengerjakan tugasnya dengan cepatdan mudah yang memerlukan instruksi-instruksi untuk menjalankan sebuah prosedur dalam menyelesaikan tugas. Instruksi-instruksi tersebut tersimpan dalam program komputer",
                image = R.drawable.komputer
            )
        )
        contentMateriSatuSatu.add(
            Content(
                nama = "Pemrograman",
                content = "Pemrigraman merupakan pengkodean atau sering disebut istilah coding, dan juga pengujian berdasaekan rencana tertentu. Pengkodean (coding) adalah proses penerjemahan algoritma ke dalam bahasa pemrograman tertentu, dengan mengacu pada desain algoritma yang telah dibuat.",
                image = R.drawable.program
            )
        )
        contentMateriSatuSatu.add(
            Content(
                nama = "Aplikasi",
                content = "Aplikasi / Program komputer merupakan sekumpulan instruksi berupa pernyataan yang tertulis menggunakan bahasa pemrograman yang melibatkan pemilihan struktur data. Dalam arti luas, program meliputi seluruh kegiatan yang mencakup pembuatan, perencanaan dan perwujudan program.",
                image = R.drawable.aplikasi
            )
        )
        val contentMateriSatuDua = mutableListOf<Content>()
        contentMateriSatuDua.add(
            Content(
                nama = "Pengertian Algoritma",
                content = """
                    <p><b>Algoritma</b> adalah urutan langkah-langkah logis penyelesaian masalah yang disusun secara sistematis.</p>
                """.trimIndent()
            )
        )
        contentMateriSatuDua.add(
            Content(
                nama = "Konsep Dasar Algoritma",
                content = """
                    <p>Algoritma merupakan urutan langkah-langkah (instruksi-instruksi/aksi-aksi) terbatas yang disusun secara sistematis dan menggunakan bahasa yang logis untuk menyelesaikan suatu permasalahan</p>
                    <p>Contoh gambaran konsep algoritma : <a href="pemrog.dev/content?konsep">Lihat</a></p>
                """.trimIndent()
            )
        )
        contentMateriSatuDua.add(
            Content(
                nama = "Alur Logika Algoritma",
                content = """
                    <p>Penyajian algoritma secara garis besar bisa dalam 2 bentuk penyajian yaitu tulisan dan gambar</p>
                     <ol>
                      <li>Natural
                          <p>Dalam kehidupan sehari-hari ditemui algoritma dengan menggunakan bahasa natural(bahasa sehiari-hari). Bahasa yang digunakan tentunya bahasa yang mudah dipahami oleh pengguna algoritma</p>
                          <p>Penyajian algoritma dalam bahasa natural menggunakan kalimat deskriptif, yaitu menjelaskan secara detail algoritma dengan bahasa atau kata-kata yang mudah dipahami. Penyajian algoritma ini cocok untuk algoritma singkat, namun penyajian dengan bahasa natural sulit untuk algoritma yang besar. Selain itu, algoritma dengan bahasa natural akan sulit dikonversi ke dalam bahasa pemrograman tertentu.</p>
                          <p>Contoh gambaran alur natural : <a href="pemrog.dev/content?natural">Lihat</a></p>
                      </li>
                      <li>Pseudocode
                          <p>Pseudocode adalah suatu teknik penulisan algoritma dengan menggunakan sebanyak mungkin komponen-komponen dari salah satu bahasa tingkat tinggi (suatu bahasa pemrograman yang masih memerlukan unit kompilator untuk mengeksekusi program agar dapat berjalan). Penulisan algoritma dengan pseudocode hampir menyerupai sebuah program, tetapi tanpa menyertakan atribut-atribut program (seperti tipe data dan lain-lain), hanya saja menuliskan proses intinya saja</p>
                          <p>"Pseudo berarti imitisi atau tiruan atau menyerupai, sedangkan code menunjuk pada kdoe program"</p>
                          <p>Contoh gambaran alur pseudoce : <a href="pemrog.dev/content?pseudoce">Lihat</a></p>
                      </li>
                      <li>Flowchart
                            <p>Flowchart meruapakan gambar atau bagan yang memperlihatkan urutan dan hubungan antar proses beserta pernyataannya. Gambaran ini dinyatakan dengan simbol yang menggambarkan proses tertentu dengan garis penghubung. Flowchart akan memudahkan kita untuk melakukan pengecekan bagian-bagian yang terlupakan dalam analisis masalah dan sebagai fasilitas untuk berkomunikasai antara pemrogram yang bekerja dalam tim suatu proyek.</p>
                            <p>Contoh gambaran alur flowchart : <a href="pemrog.dev/content?flowchart">Lihat</a></p>
                      </li>
                    </ol>
                """.trimIndent()
            )
        )
        contentMateriSatuDua.add(
            Content(
                nama = "Struktur Algoritma",
                content = """
                    <p>Algoritma berisi langkah-langkah penyelesaian suatu masalah. Langkah-langkah tersebut dapat berupa runtunan aksi (sequence), pemilihan aksi (selection), pengulangan aksi (iteration) atau kombinasi dari ketiganya. Jadi struktur dasar pembangunan algoritma ada tiga, yaitu:</p>
                    <ol>
                      <li>
                          <p>Struktur Runtunan / Beruntun : Digunakan untuk program yang pernyataannya sequential atau urutan.</p>
                          <p>Contoh gambaran struktur algoritma runtutan : <a href="pemrog.dev/content?sekuensial">Lihat</a></p>
                      </li>
                      <li>
                          <p>Struktur Pemilihan / Percabangan : Digunakan untuk program yang menggunakan pemilihan atau penyeleksian kondisi.</p>
                          <p>Contoh gambaran struktur algoritma percabangan : <a href="pemrog.dev/content?percabangan">Lihat</a></p>
                       </li>
                      <li>
                          <p>Struktur Perulangan : Digunakan untuk program yang pernyataannya akan dieksekusi berulang-ulang.</p>
                          <p>Contoh gambaran struktur algoritma perulangan : <a href="pemrog.dev/content?perulangan">Lihat</a></p>
                      </li>
                    </ol>
                """.trimIndent()
            )
        )
        val contentMateriSatuTiga = mutableListOf<Content>()
        contentMateriSatuTiga.add(
            Content(
                nama = "Pengertian Bahasa Pemrograman",
                content = """
                    <p>Bahasa pemrograman merupakan suatu sistem komunikasi yang berupa instruksi-instruksi standar untuk memerintahkan komputer agar menjalakan fungsi tertentu. Kumpulan instruksi ini harus dimengerti oleh komputer, berstruktur terntetu (sintaksis) dan bermakna</p>
                    <p>Penulisan bahasa pemrograman sebagai alat komunikasi untuk memberikan perintah kepada komputer tidak berlaku kebebasan berekspresi seperti layaknya dalam menulis dalam bahasa ilmiah</p>
                    <p>Penulisan bahasa pemrograman harus mengikuti aturan sintaksis masing-masing bahasa pemrograman yang digunakan</p>
                    <p>Bahasa pemrograman yang umum digunakan oleh <i>programmer</i> adalah HTMLS/CSS, Javascript, PHP, C++, C#, C, Python, Java, Ruby dan Visual Basic</p>
                """.trimIndent()
            )
        )
        contentMateriSatuTiga.add(
            Content(
                nama = "Tingkatan Bahasa Pemrograman",
                content = """
                    <p>Berdasarkan kerumitan bahasanya, bahasa pemrograman di bagi menjadi dua yaitu:</p>
                     <ol>
                        <li> Bahasa Pemrograman Tingkat rendah (Bahasa mesin, Biner)
                            <p>Bahasa tingkat rendah dirancang agar setiap instruksinya langsung dikerjakan oleh komputer, tanpa harus melalui penerjemah (translatir). Bahasa tingkat rendah bersifat primitif, sangat sederhana, orientasinya lebih dekat ke mesin, dan sulit dipahami oleh manusia. Contoh dari bahasa pemrograman tingkat rendah adalah bahasa mesin dan bahasa assembly</p>
                            <p>Bahasa mesin merupakan representasi tertulis machine core (kode mesin), yaitu kode operasi suatu mesin tertentu. Abstraksi bahasa ini adalah kumpulan kombinasi kode biner 0 dan 1, yang berarti sangat tidak alamiah dan sulit dimengerti oleh kebanyakan orang</p>
                        </li>
                        <li> Bahasa Pemrograman Tingkat tinggi
                            <p>Bahasa tingkat tinggi mempunyai ciri-ciri mudah untuk dibaca, ditulis, maupun diperbarui, sebelum bisa dijalankan program harus terlebih dahulu di-compile</p>
                            <p>Bahasa pemrograman tingkat tinggi harus dicompile menggunakan compiler. Compiler adalah suatu program yang menerjemahkan bahasa program (source code) ke dalam bahasa objek (object code). Compiler memerlukan waktu untuk membuat suatu program yang dapat dieksekusi oleh komputer. Akan tetapi program yang diproduksi dengan compiler akan berjalan lebih cepat dibandingkan dengan program yang diproduksi dengan interpreter. Interpreter menganalisis dan mengeksekusi setiap bari dari program tanpa melihat sebuah program secara keseluruhan. Tanpa melalui kompilasi, intepreter biasanya digunakan pada pembuatan program berskala besar</p>
                        </li>
                     </ol>
                """.trimIndent()
            )
        )
        contentMateriSatuTiga.add(
            Content(
                nama = "Mengenal Bahasa C",
                content = """
                    <p>Bahasa pemrograman C adalah sebuah bahasa pemrograman yang bisa digunakan untuk membuat berbagai aplikasi (general-purpose programming language)</p>
                    <p>Contoh kode sederhana : <a href="pemrog.dev/content?contoh">Lihat</a></p>
                    <p>Contoh hasil kode sederhana : <a href="pemrog.dev/content?hasil">Lihat</a></p>
                """.trimIndent()
            )
        )
        contentMateriSatuTiga.add(
            Content(
                nama = "Kelebihan dan kekurangan Bahasa C",
                content = """
                    <p>Kelebihan</p>
                     <ol>
                        <li>Bahasa C tersedia hampir disemua jenis komputer</li>
                        <li>Kode bahasa C sifatnya portable dan fleksibel untuk semua jenis komputer</li>
                        <li>Bahasa C hanya menyediakan sedikit kata-kata kunci, hanya terdapat 32 kata kunci</li>
                        <li>Proses executable program bahasa C lebih cepat</li>
                        <li>Dukungan pustaka banyak</li>
                        <li>C ada bahasa terstruktur</li>
                        <li>Bahasa C termasuk bahasa tingkat menengah</li>
                     </ol>
                     <p>Kekurangan</p>
                     <ol>
                        <li>Banyak operator serta fleksibilitas penulisan kadang-kadang membingungkan pemakai</li>
                        <li>Bagi pemula pada umumnya akan kesulitan menggunakan pointer</li>
                     </ol>
                """.trimIndent()
            )
        )
        contentMateriSatuTiga.add(
            Content(
                nama = "Contoh penggunaan bahasa C",
                content = """
                     <ol>
                        <li>Mempelajari kernel dalam sistem operasi</li>
                        <li>Membangun aplikasi dekstop</li>
                        <li>Membuat aplikasi mikrokontroler</li>
                        <li>Ikut pengembangan teknologi open source</li>
                        <li>Membuat/mempelajari bahasa pemrograman C/C++</li>
                        <li>Membuat library untuk bahasa pemrograman lain</li>
                        <li>Membuat aplikasi perangkat mobile</li>
                        <li>Membuat game</li>
                     </ol>
                """.trimIndent()
            )
        )
        contentMateriSatuTiga.add(
            Content(
                nama = "Mengenal Software Pemrograman",
                content = """
                    <p>Bahasa pemrograman C pastinya menggunakan software untuk mengolah bahasa C itu sendiri, ada beberapa macam software yang bisa gunakan antara lain:</p>
                    <ul>
                        <li>Borlan C++</li>
                        <li>Dev C++</li>
                        <li>Atom</li>
                        <li>Sublime Text</li>
                    </ul>
                """.trimIndent()
            )
        )
        subMateriSatu.add(
            SubMateri(
                nama = "Alur Logika Pemrograman Komputer",
                content = contentMateriSatuSatu,
                type = "Alur"
            )
        )
        subMateriSatu.add(
            SubMateri(
                nama = "Algoritma",
                content = contentMateriSatuDua,
                type = "Bacaan"
            )
        )
        subMateriSatu.add(
            SubMateri(
                nama = "Bahasa Pemrograman",
                content = contentMateriSatuTiga,
                type = "Bacaan"
            )
        )
        materi.add(Materi(nama = "BAB 1", subMateri = subMateriSatu))

        val subMateriDua = mutableListOf<SubMateri>()
        val contentMateriDuaSatu = mutableListOf<Content>()
        contentMateriDuaSatu.add(
            Content(
                nama = "Pengertian Tipe Data",
                content = """
                    <p>Tipe data adalah jenis data yang dapat diolah oleh komputer untuk memenuhi kebutuhan dalam pemrograman komputer<p>
                    <p>Setiap variable atau konstanta yang ada dalam kode program, sebaiknya kita tentukan dengan pasti tipe datanya. Ketepatan pemilihan tipe data pada variabel atau konstanta akan sangat menentukan pemakaian sumber daya komputer (terutama memori komputer). Salah satu tugas penting seorang programmer adalah memilih tipe data yang sesuai untuk menghasilkan program yang efisien dan berkinerja tinggi.</p>
                """.trimIndent()
            )
        )
        contentMateriDuaSatu.add(
            Content(
                nama = "Tipe Data Primitiv",
                content = """
                    <p>Type data dasar yang tersedia langsung pada suatu bahasa pemrograman</p>
                """.trimIndent()
            )
        )
        contentMateriDuaSatu.add(
            Content(
                nama = "Tipe Data Composite",
                content = """
                    <p>Tipe data bentukan yang terdiri dari dua atau lebih tipe data primitive</p>
                """.trimIndent()
            )
        )
        contentMateriDuaSatu.add(
            Content(
                nama = "Tipe Data Numeric",
                content = """
                    <p>Tipe data numeric digunakan pada variable atau konstanta untuk menyimpan nilai dalam bentukan bilangan atau angka. Semua bahasa pemrograman menyediakan tipe data numeric, hanya berbeda dalam jenis numeric yang diakamodasi.</p>
                    <p>Jenis yang termasuk dalam tipe data numeric<p>
                     <ol>
                        <li>Integer(Bilangan Bulat)
                            <p>Tipe data integer merupakan bilangan bulat yang tidak mengandung angka pecahan desimal, misalnya -3,-2,-1,0,1,2,3 dan sebagainya. Jika terdapat pecahan maka dibulatkan.</p>
                        </li>
                        <li>Float/Double(Bilangan Rill)
                            <p>Tipe data float/double merupakan bilangan rill yang mengandung pecahan desimal, misalnya 4.35, 7.333 dan sebagainya. Yang termasuk ke dalam tipe data ini adalah float, double, dan long double</p>
                        </li>
                        <li>Tipe Currency
                            <p>Tipe currency sudah disiapkan pada beberapa bahasa pemrograman seperi visual basic untuk uang mata negara yang didukung oleh Windows. Pengaturan mata uang bisa dilakukan untuk mendeklarasikan melalui pilihan Regional Setting pada Control Panel</p>
                        </li>
                     </ol>
                """.trimIndent()
            )
        )
        contentMateriDuaSatu.add(
            Content(
                nama = "Tipe Data String",
                content = """
                    <p>Tipe data string adalah data yang digunakan untuk mendeklarasikan variable yang akan selalu diisi dengan teks dan tidak akan diisi dengan nilai numerik</p>
                    <p>Bersama dengan tipe data numerik, string maupun character merupakan tipe data yang paling banyak digunakan. Tipe data ini kadang disebut sebagai char atau string. Tipe data string hanya dapat digunakan menyimpan teks atau apapun sepanjang berada dalam tanda petik dua ("...") atau petik tunggal ('...')</p>
                """.trimIndent()
            )
        )
        contentMateriDuaSatu.add(
            Content(
                nama = "Tipe Data Boolean",
                content = """
                    <p>Tipe data boolean digunakan untuk menyimpan nilai True/False (Benar/Salah). Pada sebagian besar bahasa pemrograman nilai selain 0 menunjukan True dan 0 melambangkan False. Tipe data ini banyak digunakan untuk pengambilan keputusan pada struktur percabangan dengan IF...THEN atau IF...THEN..ELSE</p>
                """.trimIndent()
            )
        )
        contentMateriDuaSatu.add(
            Content(
                nama = "Tipe Data Variant",
                content = """
                    <p>Suatu variabel dengan tipe data variant mampu digunakan untuk menyimpan semua tipe data yang didefinisikan oleh sistem. Anda tidak perlu mengubah tipe data untuk variabel data yang bertipe variant, karena Visual Basic secara otomatis akan memberikan tipe data tersebut</p>
                    <p>Beberapa hal yang perlu diperhatikan saat melakukan operasi data variabel bertipe variant tanpa memperhatikan jenis data yang diisikan, yaitu sebagai berikut:</p>
                    <ol>
                        <li>Jika menggunakan operasi aritmatika atau fungsi matematika pada suatu variant, variant hanya berisi suatu nilai</li>
                        <li>Jika ingin menggabungkan data teks, lebih baik menggunakan operator "&" daripada menggunakan operator "+"</li>
                    </ol>
                """.trimIndent()
            )
        )
        val contentMateriDuaDua = mutableListOf<Content>()
        contentMateriDuaDua.add(
            Content(
                nama = "Pengertian Variabel",
                content = """
                    <p>Variable adalah tempat dimana kita dapat mengisi atau mengosongkan nilainya dan memanggil kembali apabila dibutuhkan. Setiap variable akan mempunyai nama (identifier) dan nilai</p>
                    <p>Pada sebagian besar bahasa pemrograman, variabel harus dideklarasikan lebih dahulu untuk mempermudah compiler bekerja. Apabila variabel tidak dideklarasikan maka setiap kali compiler bertemu dengan variabel baru. Pemberian nama variabel harus mengikuti aturan yang ditetapkan oleh bahasa pemrograman yang kita gunakan.</p>
                """.trimIndent()
            )
        )
        contentMateriDuaDua.add(
            Content(
                nama = "Jenis Variabel",
                content = """
                    <p>Variabel Numerik</p>
                    <ul>
                        <li>Bilangan Bulat</li>
                        <li>Bilangan Desimal Berpresisi Tunggal atau Floating Point</li>
                        <li>Bilangan Disimal Bepresisi Ganda atau Double Precision</li>
                    </ul>
                    <p>Variabel text</p>
                    <ul>
                        <li>Character (Karakter Tunggal)</li>
                        <li>String (Untaian Rangkaian Character)</li>
                    </ul>
                """.trimIndent()
            )
        )
        contentMateriDuaDua.add(
            Content(
                nama = "Aturan Penulisan Variabel",
                content = """
                    <p>Secara umum ada aturan yang berlaku untuk hampir semua bahasa pemrograman. Aturan-aturan tersebut yaitu :</p>
                    <ul>
                        <li>Nama variable harus diawali dengan huruf</li>
                        <li>Tidak boleh menggunakan spasi pada satu nama variabel. Spasi bisa diganti dengan karakter underscore ( _ )
                        </li>
                        <li>Nama variabel tidak boleh mengandung karakter-karakter khusus, seperti: ., +, -, *, /, <, >, &, (, ) dan lain-lain</li>
                        <li>Nama variable tidak boleh menggunakan kata-kata kunci di bahasa pemrograman</li>
                    </ul>
                """.trimIndent()
            )
        )
        contentMateriDuaDua.add(
            Content(
                nama = "Deklarasi Variabel",
                content = """
                    <p>Deklarasi variabel adalah proses memperkenalkan variable kepada bahasa C/C++ dan pendeklarasian tersebut bersifat mutlak karena jika tidak diperkenalkan terlebih dahulu maka bahasa C/C++ tidak menerima variable tersebut</p>
                    <p>Deklarasi variabel ini meliputi tipe variabel, seperi: integer atau character dan nama variabel itu sendiri. Setiap kali pendeklarasian variabel harus diakhiri oleh tanda titik koma (;)</p>
                """.trimIndent()
            )
        )
        contentMateriDuaDua.add(
            Content(
                nama = "Contoh Penulisan",
                content = """
                     <p>Contoh penulisan variable pada bahasa C : <a href="pemrog.dev/content?variable">Lihat</a></p>
                """.trimIndent()
            )
        )
        val contentMateriDuaTiga = mutableListOf<Content>()
        contentMateriDuaTiga.add(
            Content(
                nama = "Pengertian Kontanta",
                content = """
                    <p>Konstanta adalah variabel yang nilai datanya bersifat tetap dan tidak bisa diubah</p>
                    <p>Jadi konstanta juga variabel bedanya adalah nilai yang disimpannya. Jika nilai datanya sepanjang program berjalan tidak berubah-ubah, maka sebuah variabel lebih baik diperlakukan sebagai konstanta</p>
                """.trimIndent()
            )
        )
        contentMateriDuaTiga.add(
            Content(
                nama = "Contoh Kasus",
                content = """
                    <p>Sebagai contoh, jika kita membuat program perhitungan matematika yang menggunakan nilai pi (3.14159) yang mungkin akan muncul dibanyak tempat pada kode program, kita dapat membuat pi sebagai konstanta. Penggunaan konstanta pi akan lebih memudahkan penulisan kode program dibanding harus mengetikkan nilai 3.14159 berulang-ulang</p>
                """.trimIndent()
            )
        )
        contentMateriDuaTiga.add(
            Content(
                nama = "Contoh Pada Bahasa C",
                content = """
                     <p>Contoh penulisan konstanta pada bahasa C : <a href="pemrog.dev/content?konstanta">Lihat</a></p>
                """.trimIndent()
            )
        )
        val contentMateriDuaEmpat = mutableListOf<Content>()
        contentMateriDuaEmpat.add(
            Content(
                nama = "Pengertian Operator",
                content = """
                    Operator merupakan simbol atau karakter yang biasa dilibatkan dalam program untuk melakukan sesuatu operasi atau manipulasi, seperti penjumlahan, pengurangan dan lain-lain
                """.trimIndent()
            )
        )
        contentMateriDuaEmpat.add(
            Content(
                nama = "Sifat",
                content = """
                    <p>Operator mempunyai sifat sebagai berikut:</p>
                    <ul>
                        <li>Unary</li>
                        <p>Sifat unary pada operator adalah hanya melibatkan sebuah operand pada suatu operasi aritmatik. Contoh : -5</p>
                        <li>Binary</li>
                        <p>Sifat binary pada operator adalah melibatkan dua buah operand pada suatu operasi aritmatik. Contoh : 4 + 8</p>
                        <li>Ternary</li>
                        <p>Sifat ternary pada operator adalah melibatkan tiga buah operand pada suatu operasi aritmatik. Contoh : (10 % 3) + 4 + 2</p>
                    </ul>
                """.trimIndent()
            )
        )
        contentMateriDuaEmpat.add(
            Content(
                nama = "Simbol",
                content = """
                    <p>Operator untuk operasi aritmatika yang tergolong sebagai operator binary berikut :</p>
                    <ul>
                        <li>*</li>
                        <p>Perkalian -> Contoh : 4 * 5</p>
                        <li>/</li>
                        <p>Pembagian -> Contoh : 8 / 2</p>
                        <li>%</li>
                        <p>Sisa Pembagian -> Contoh : 5 % 2</p>
                        <li>+</li>
                        <p>Penjumlahan -> Contoh : 7 + 2</p>
                        <li>-</li>
                        <p>Pengurangan -> Contoh : 6 - 2</p>
                    </ul>
                    <p>Bahasa C menyediakan operator penambah dan pengurang untuk memberi nilai. Sebagai penyederhanaannya dapat digunakan opertor penambah dan pengurang sebagai berikut ini</p>
                    <ul>
                        <li>++</li>
                        <p>Penambahan</p>
                        <li>--</li>
                        <p>Pengurangan</p>
                    </ul>
                """.trimIndent()
            )
        )
        contentMateriDuaEmpat.add(
            Content(
                nama = "Contoh Pada Bahasa C",
                content = """
                     <p>Contoh penulisan operator pada bahasa C : <a href="pemrog.dev/content?operator">Lihat</a></p>
                """.trimIndent()
            )
        )
        subMateriDua.add(
            SubMateri(
                nama = "Tipe Data",
                content = contentMateriDuaSatu,
                type = "Bacaan"
            )
        )
        subMateriDua.add(
            SubMateri(
                nama = "Variabel",
                content = contentMateriDuaDua,
                type = "Bacaan"
            )
        )
        subMateriDua.add(
            SubMateri(
                nama = "Konstanta",
                content = contentMateriDuaTiga,
                type = "Bacaan"
            )
        )
        subMateriDua.add(
            SubMateri(
                nama = "Operator",
                content = contentMateriDuaEmpat,
                type = "Bacaan"
            )
        )
        materi.add(Materi(nama = "BAB 2", subMateri = subMateriDua))

        return materi
    }

    class ScreenSlidePagerAdapter(
        fragment: Fragment,
        private val content: List<Materi>
    ) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = content.size

        override fun createFragment(position: Int): Fragment {
            val fragment = SubMateriFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(SubMateriFragment.ITEM, content[position])
            }
            return fragment
        }
    }

}