#  Aplikasi Simulasi Investasi Saham & SBN (Java CLI)

Aplikasi berbasis console (CLI) ini memungkinkan pengguna untuk mensimulasikan kegiatan investasi di pasar modal, khususnya untuk pembelian dan penjualan **saham** serta pembelian dan simulasi keuntungan dari **Surat Berharga Negara (SBN)**. Program ini membedakan antara **Admin** dan **Customer**, dengan fitur yang disesuaikan.

---
## UML
![UML](images/1.png)

---
### Bagian Admin
![Admin](images/2.png)
- **Login**: Pada bagian ini berisi halaman login, untuk tampilan login untuk admin dan user sama saja. Yang membedakan hanya username untuk custumer dan admin pastinya berbeda. 
---
![Admin](images/3.png)
- **Tambah Saham**: Seorang admin dapat menambahkan saham baru ke dalam daftar saham, admin juga dapat menyesuaikan harganya dan juga kode saham.
---
![Admin](images/10.png)
- **Ubah Harga Saham**: Seorang admin dapat mengubah harga dari saham yang telah terdaftar, ini berfungsi jika ada kesalahan input ketika menambahkan saham
---
![Admin](images/4.png)
- **Tambah SBN**: Sama seperti pada saham, seorang admin dapat menambahkan Surat Berharga Negara(SBN) beserta detailnya kedalam daftar. Hanya saja pada SBN admin tidak dapat mengubah persentase bunga, jatuh tempo, dan kuota nasional, jadi admin hanya bisa menambah SBN dan setelah ditambah maka sudah tidak bisa lagi diubah.
---
### Bagian Customer
![Costumer](images/5.png)
- **Login**: Bagian login untuk costumer.
---
![Costumer](images/6.png)
- **Beli Saham**: Costumer dapat membeli saham yang tersedia pada daftar saham berdasarkan jumlah lembar saham yang diinginkan. Jika berhasil akan muncul output seperti pada gambar diatas
---
![Costumer](images/11.png)
- **Jual Saham**: Costumer juga dapat menjual sebagian atau seluruh saham yang dimiliki sesuai dengan harga yang tertera pada daftar saham. Apabila berhasil maka akan muncul output seperti pada gambar
---
![Costumer](images/7.png)
- **Beli SBN**: Costumer dapat melakukan Pembelian SBN berdasarkan kuota nasional yang tersedia. Apabila costumer melakukan pembelian melebihi kuota nasional maka pembelian akan gagal.
---
![Costumer](images/8.png)
- **Simulasi SBN**: Pada bagian ini hanya Menampilkan simulasi hasil bulanan berdasarkan investasi yang dilakukan costumer
---
![Costumer](images/9.png)
- **Lihat Portofolio**: Menampilkan seluruh portofolio saham dan SBN yang dimiliki costumer beserta nilai pasar yang terakhir diupdate oleh admin.
